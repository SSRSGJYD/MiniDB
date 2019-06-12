package minidb.basic.bplustree;

import java.util.LinkedList;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashMap;


public class Cache<T extends BPlusTreeNode> {
	private RandomAccessFile fa; // file access
	private Path path;			 // file path
	private int pageSize;   	 // page size
	private int headerSize;
	private int keyType;         // type of key
    private int keySize;    	 // key size
    
    private HashMap<Long, T> valueMap;		 //(key, value)
    private HashMap<Long, Integer> indexMap; //(key, index)
    private LinkedList<Long> keyList;		 //[key], for LRU
    private int capacity;
    private int size;

    public Cache(RandomAccessFile fa, Path path, int pageSize, int headerSize, int keyType, int keySize, int capacity) {
        this.fa = fa;
        this.path = path;
    	this.pageSize = pageSize;
    	this.headerSize = headerSize;
    	this.keyType = keyType;
    	this.keySize = keySize;
    	this.capacity = capacity;
        this.valueMap = new HashMap<>();
        this.indexMap = new HashMap<>();
        this.keyList = new LinkedList<>();
    }

    public void put(Long key, T value) throws IOException {
    	// put into cache
        if(valueMap.size() == capacity) {
            release();
        }
        valueMap.put(key, value);
        if(indexMap.containsKey(key)) {
            int index = indexMap.get(key);
            keyList.remove(index);
            keyList.addLast(key);
        }
        else {
            keyList.addLast(key);
            indexMap.put(key, keyList.size()-1);
            size++;
        }
    }
    
    public void putWrite(Long key, T value) throws IOException {
    	value.dirty = true;
        if(valueMap.size() == capacity) {
            release();
        }
        valueMap.put(key, value);
        boolean write = true;
        if(indexMap.containsKey(key)) {
            int index = indexMap.get(key);
            if(index >= size-10) {
            	// do not write most recent 10 pages immediately
            	write = false;
            }
            keyList.remove(index);
            keyList.addLast(key);
        }
        else {
            keyList.addLast(key);
            indexMap.put(key, keyList.size()-1);
            size++;
        }
        if(write) {
        	value.writeNodeAsync(fa, path, pageSize, headerSize, keyType, keySize);
        }
        if(size > 10) {
        	// write No.11 element backwards
        	long keyToWrite = keyList.get(size-11);
        	T valueToWrite = valueMap.get(keyToWrite);
        	if(valueToWrite.dirty) {
        		valueToWrite.writeNodeAsync(fa, path, pageSize, headerSize, keyType, keySize); 
        	}
        }
    }

    public boolean containsKey(long key) {
        return valueMap.containsKey(key);
    }

    public T get(long key) {
        int index = indexMap.get(key);
        keyList.remove((int)index);
        keyList.addLast(key);
        indexMap.put(key, keyList.size()-1);
        return valueMap.get(key);
    }

    private void release() throws IOException {
        long numToRemove = capacity / 2;
        for(long i=0; i<numToRemove; i++) {
            long key = keyList.pop();
//            T value = valueMap.get(key);
//            value.writeNode(fa, pageSize, headerSize, keyType, keySize);
            valueMap.remove(key);
        }
        indexMap.clear();
        int index = 0;
        for(long key: keyList) {
            indexMap.put(key, index);
            index++;
        }
        size = keyList.size();
    }
    
    public void commitAll() throws IOException {
		Collection<T> values = valueMap.values();
		Boolean finish = false;
		while(!finish) {
			for(T value : values) {
				if(value.dirty) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					continue;
//					value.writeNode(fa, pageSize, headerSize, keyType, keySize);
//					value.dirty = false;
				}
			}
			finish = true;
		}
		
    }
}
