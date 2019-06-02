package minidb.basic.bplustree;

import java.util.LinkedList;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Collection;
import java.util.HashMap;


public class Cache<T extends BPlusTreeNode> {
	private RandomAccessFile fa; // file access
	private int pageSize;   	 // page size
	private int headerSize;
	private int keyType;         // type of key
    private int keySize;    	 // key size
    
    private HashMap<Long, T> valueMap;		 //(key, value)
    private HashMap<Long, Integer> indexMap; //(key, index)
    private LinkedList<Long> keyList;		 //[key], for LRU
    private int capacity;

    public Cache(RandomAccessFile fa, int pageSize, int headerSize, int keyType, int keySize, int capacity) {
        this.fa = fa;
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
        }
    }
    
    public void putWrite(Long key, T value) throws IOException {
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
        }
        value.writeNode(fa, pageSize, headerSize, keyType, keySize);
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
    }
    
    public void commitAll() throws IOException {
//    	for(long i=0; i<capacity; i++) {
//    		Collection<T> values = valueMap.values();
//    		for(T value : values) {
//    			value.writeNode(fa, pageSize, headerSize, keyType, keySize);
//    		}
//    	}
    }
}
