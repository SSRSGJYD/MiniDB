package minidb.basic.bplustree;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;

import minidb.basic.bplustree.BPlusTreeNode;
import minidb.basic.index.Key;
import minidb.basic.index.Value;


/**
 * Class of internal node of B+ Tree
 *
 * Internal node in file page:
 *      node type: 2 bytes(Short.SIZE)
 *      capacity: 4 bytes(Int.SIZE)
 *      key: keySize
 *      pointer: 8 bytes(Long.SIZE)
 * layout: pointer0 key1 pointer1 ... keyn pointern
 *
 */

public class BPlusTreeInternalNode<K extends Key, V extends Value> extends BPlusTreeNode<K,V> {

    protected LinkedList<K> keyList;
    protected LinkedList<Long> ptrList; // list of pointers to child nodes

    /**
     * constructor
     *
     */
    public BPlusTreeInternalNode(int nodeType, long pageIndex, int valueSize) {
        super(nodeType, pageIndex, valueSize);
        keyList = new LinkedList<K>();
        ptrList = new LinkedList<Long>();
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
    public void writeNode(RandomAccessFile fa, int pageSize, int headerSize, int keyType, int keySize) throws IOException {

        if(this.getNodeType() == BPlusTreeConst.NODE_TYPE_ROOT_INTERNAL ||
                this.getNodeType() == BPlusTreeConst.NODE_TYPE_ROOT_LEAF) {
            fa.seek(headerSize-16);
            fa.writeLong(getPageIndex());
        }
        fa.seek(getPageIndex());
        fa.writeShort(getNodeType());
        int capacity = getCapacity();
        fa.writeInt(capacity);
        for(int i = 0; i < capacity; i++) {
            BPlusTreeUtils.writeKeyToFile(fa, keyList.get(i));
            fa.writeLong(ptrList.get(i));   // Pointer
        }
        fa.writeLong(ptrList.get(capacity));

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
    public void writeNodeAsync(RandomAccessFile fa, String filename, int pageSize, int headerSize, int keyType, int keySize) throws IOException {

        if(this.getNodeType() == BPlusTreeConst.NODE_TYPE_ROOT_INTERNAL ||
                this.getNodeType() == BPlusTreeConst.NODE_TYPE_ROOT_LEAF) {
            fa.seek(headerSize-16);
            fa.writeLong(getPageIndex());
        }
        fa.seek(getPageIndex());
        fa.writeShort(getNodeType());
        int capacity = getCapacity();
        fa.writeInt(capacity);
        for(int i = 0; i < capacity; i++) {
            BPlusTreeUtils.writeKeyToFile(fa, keyList.get(i));
            fa.writeLong(ptrList.get(i));   // Pointer
        }
        fa.writeLong(ptrList.get(capacity));

        if(fa.length() < getPageIndex() + pageSize) {
            fa.setLength(getPageIndex() + pageSize);
        }
    }


    /**
     * check if node is full
     */
    @Override
    public boolean isFull(int internalNodeDegree, int leafNodeDegree, int overflowNodeDegree) {
        return getCapacity() == internalNodeDegree * 2 - 1;
    }

    /**
     * check if node is 'under-used'
     */
    @Override
    public boolean isSparse(int internalNodeDegree, int leafNodeDegree) {
        if(getNodeType() == BPlusTreeConst.NODE_TYPE_ROOT_INTERNAL) {
            return getCapacity() <= 1;
        }
        else {
            return getCapacity() < internalNodeDegree;
        }
    }


}
