package minidb.basic.bplustree;

import java.util.LinkedList;
import java.util.HashMap;

public class Cache<T> {
    private HashMap<Long, T> valueMap;
    private HashMap<Long, Integer> indexMap;
    private LinkedList<Long> keyList;
    private int capacity;

    public Cache(int capacity) {
        this.capacity = capacity;
    }

    public void put(Long key, T value) {
        if(valueMap.size() == capacity) {
            release();
        }
        valueMap.put(key, value);
        if(indexMap.containsKey(key)) {
            long index = indexMap.get(key);
            keyList.remove(index);
            keyList.addLast(key);
        }
        else {
            keyList.addLast(key);
            indexMap.put(key, keyList.size()-1);
        }
    }

    public boolean containsKey(long key) {
        return valueMap.containsKey(key);
    }

    public T get(long key) {
        int index = indexMap.get(key);
        keyList.remove(index);
        keyList.addLast(key);
        indexMap.put(key, keyList.size()-1);
        return valueMap.get(key);
    }

    private void release() {
        long numToRemove = capacity / 2;
        for(long i=0; i<numToRemove; i++) {
            long key = keyList.pop();
            valueMap.remove(key);
        }
        indexMap.clear();
        int index = 0;
        for(long key: keyList) {
            indexMap.put(key, index);
            index++;
        }
    }
}
