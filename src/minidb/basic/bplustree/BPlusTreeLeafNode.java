package minidb.basic.bplustree;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.concurrent.Future;

import minidb.basic.index.Key;
import minidb.basic.index.Value;

/**
 *
 * Class of leaf node of B+ Tree
 *
 * Leaf node in file page:
 *      node type: 2 bytes(Short.SIZE)
 *      next page index: 8 bytes(Long.SIZE)
 *      prev page index: 8 bytes(Long.SIZE)
 *      capacity: 4 bytes(Int.SIZE)
 *      key: keySize
 *      (deprecated!!) overflow node index:8 bytes(Long.SIZE)
 *      value: valueSize
 * layout: (key, value) ...
 *
 */

public class BPlusTreeLeafNode<K extends Key, V extends Value> extends BPlusTreeNode<K,V> {

    private long nextPageIndex;
    private long prevPageIndex;
    protected LinkedList<K> keyList;
    protected LinkedList<V> valueList;
    public boolean dirty;

    /**
     * constructor
     *
     */
    public BPlusTreeLeafNode(int nodeType, long pageIndex, int valueSize, long nextPageIndex, long prevPageIndex) {
        super(nodeType, pageIndex, valueSize);
        this.nextPageIndex = nextPageIndex;
        this.prevPageIndex = prevPageIndex;
        this.keyList = new LinkedList<K>();
        this.valueList = new LinkedList<V>();
        this.dirty = false;
    }

    public long getNextPageIndex() {
        return nextPageIndex;
    }

    public void setNextPageIndex(long nextPageIndex) {
        this.nextPageIndex = nextPageIndex;
    }

    public long getPrevPageIndex() {
        return prevPageIndex;
    }

    public void setPrevPageIndex(long prevPageIndex) {
        this.prevPageIndex = prevPageIndex;
    }

    /**
     *  write node to tree file
     *
     * @param fa file descriptor
     * @param pageSize
     * @param headerSize
     * @param keyType
     * @param keySize
     * @throws IOException
     */
    public void writeNode(RandomAccessFile fa, int pageSize, int headerSize, int keyType, int keySize)
            throws IOException {
        if(this.getNodeType() == BPlusTreeConst.NODE_TYPE_ROOT_INTERNAL ||
                this.getNodeType() == BPlusTreeConst.NODE_TYPE_ROOT_LEAF) {
            fa.seek(headerSize-16);
            fa.writeLong(getPageIndex());
        }
        fa.seek(getPageIndex());
        fa.writeShort(getNodeType());
        fa.writeLong(nextPageIndex);
        fa.writeLong(prevPageIndex);
        int capacity = getCapacity();
        fa.writeInt(capacity);
        for(int i = 0; i < capacity; i++) {
            BPlusTreeUtils.writeKeyToFile(fa, keyList.get(i));
            BPlusTreeUtils.writeRowToFile(fa, valueList.get(i));
        }

        if(fa.length() < getPageIndex() + pageSize) {
            fa.setLength(getPageIndex() + pageSize);
        }
    }
    
    /**
     *  write node to tree file
     *
     * @param fa file descriptor
     * @param pageSize
     * @param headerSize
     * @param keyType
     * @param keySize
     * @throws IOException
     */
    public void writeNodeAsync(RandomAccessFile fa, Path path, int pageSize, int headerSize, int keyType, int keySize)
            throws IOException {
        if(this.getNodeType() == BPlusTreeConst.NODE_TYPE_ROOT_INTERNAL ||
                this.getNodeType() == BPlusTreeConst.NODE_TYPE_ROOT_LEAF) {
            fa.seek(headerSize-16);
            fa.writeLong(getPageIndex());
        }
        if(fa.length() < getPageIndex() + pageSize) {
            fa.setLength(getPageIndex() + pageSize);
        }
        
        long position = getPageIndex();
    	AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
        ByteBuffer buffer = ByteBuffer.allocate(pageSize);
        buffer.putShort((short)getNodeType());
        buffer.putLong(nextPageIndex);
        buffer.putLong(prevPageIndex);
        int capacity = getCapacity();
        buffer.putInt(capacity);
        for(int i = 0; i < capacity; i++) {
            BPlusTreeUtils.writeKeyToBuffer(buffer, keyList.get(i));
            BPlusTreeUtils.writeRowToBuffer(buffer, valueList.get(i));
        }
        buffer.flip();
        fileChannel.write(buffer, position, buffer, new CompletionHandler<Integer, ByteBuffer>() {

            @Override
            public void completed(Integer result, ByteBuffer attachment) {
//                System.out.println("bytes written: " + result);
            	dirty = false;
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
//                System.out.println("Write failed");
//                exc.printStackTrace();
            }
        });
    }

    /**
     * check if node is full
     */
    @Override
    public boolean isFull(int internalNodeDegree, int leafNodeDegree, int overflowNodeDegree) {
        return getCapacity() == 2 * leafNodeDegree - 1;
    }

    /**
     * check if node is 'under-used'
     */
    @Override
    public boolean isSparse(int internalNodeDegree, int leafNodeDegree) {
        if(getNodeType() == BPlusTreeConst.NODE_TYPE_ROOT_LEAF) {
            return getCapacity() <= 1;
        }
        else {
            return getCapacity() < leafNodeDegree;
        }
    }
}