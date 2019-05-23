package minidb.basic.bplustree;

import java.util.LinkedList;
import java.util.Collections;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import minidb.basic.index.Key;
import minidb.basic.index.PrimaryKeyValue;
import minidb.basic.index.Value;
import minidb.result.DeleteResult;
import minidb.types.TypeConst;
import minidb.basic.bplustree.Cache;
import minidb.basic.bplustree.BPlusTreeUtils.*;
import minidb.result.SearchResult;

import minidb.basic.database.Row;

/**
 * Generic class of B+ Tree for all value types (int, long, float, double, string)
 *
 */

public class BPlusTree<K extends Key, V extends Value> {

    boolean isPrimaryIndex;     // true for primary index
    private int keyType;        // type of key
    private int attributeSize;  // size of key
    private int PKType;         // only for secondary index
    private int PKSize;         // size of primary key

	private BPlusTreeNode<K,V> root; // root of B+ tree
    private RandomAccessFile fa; // file access

    private LinkedList<Long> slotPool;      // pool for free slots(for key or value)
    private LinkedList<Long> slotPagePool;  // pool for free slot page(slot node)
    private long slotPageIndex;             // index of first slotPage(slot node)
    private long totalPageNum;              // num of pages used
    private long maxPageNumber;             // max id of used page

    // size
    private int pageSize;   // page size
    private int keySize;    // key size
    private int valueSize;  // value size
    private int entrySize;  // entry size

    // header size
    private int treeHeaderSize;
    private int internalNodeHeaderSize;
    private int leafNodeHeaderSize;
    private int slotNodeHeaderSize;

    // node degree
    private int internalNodeDegree;
    private int leafNodeDegree;
    private int overflowNodeDegree;
    private int slotNodeDegree;

    // for conditioning
    private int deleteCount;          // count for delete operation
    private int conditionThreshold;   // iterations to perform conditioning

    // node cache
    private Cache<BPlusTreeInternalNode<K,V>> internalNodeCache;
    private Cache<BPlusTreeLeafNode<K,V>> leafNodeCache;
    private int internalCacheSize = 1000;
    private int leafCacheSize = 1000;

    /**
     * constructor
     *
     * @param pageSize size of one page(node)
     * @param keySize size of total key
     * @param isPrimaryIndex whether is primary index
     * @param keyType type of first key
     * @param attributeSizeSize size of first key
     * @param PKType type of primary key in secondary index
     * @param PKSize size of primary key in secondary index
     * @param valueSize size of value stored
     * @param conditionThreshold threshold of re-organize tree
     * @param path file path of tree file
     * @throws IOException
     */
	public BPlusTree(int pageSize, boolean isPrimaryIndex, int keySize, int keyType,
                     int attributeSizeSize, int PKType, int PKSize, int valueSize,
                     int conditionThreshold, String path)
            throws IOException {
	    this.isPrimaryIndex = isPrimaryIndex;
        this.keyType = keyType;
        this.attributeSize = attributeSizeSize;
        this.PKType = PKType;
        this.PKSize = PKSize;

        this.pageSize = pageSize;
        this.keySize = keySize;
        this.valueSize = valueSize;
        this.entrySize = 20;

        this.treeHeaderSize = (4 * Integer.SIZE + 4 * Long.SIZE) / 8;
        this.internalNodeHeaderSize = (Short.SIZE + Integer.SIZE) / 8;
        this.leafNodeHeaderSize = (Short.SIZE + 2 * Long.SIZE + Integer.SIZE) / 8;
        this.slotNodeHeaderSize = 14;

        this.internalNodeDegree = calculateDegree(2 * this.keySize, internalNodeHeaderSize);
        this.leafNodeDegree = calculateDegree(2 * this.keySize + entrySize, leafNodeHeaderSize);
        this.overflowNodeDegree = calculateDegree(entrySize, leafNodeHeaderSize);
        this.slotNodeDegree = calculateDegree(this.keySize, slotNodeHeaderSize);

        this.slotPool = new LinkedList<Long>();
        this.slotPagePool = new LinkedList<Long>();
        this.slotPageIndex = -1L; // no extra slot page
        this.totalPageNum = 0L;
        this.maxPageNumber = 0L;
        this.deleteCount = 0;
        this.conditionThreshold = conditionThreshold;
        // initialize node cache
        internalNodeCache = new Cache<>(internalCacheSize);
        leafNodeCache = new Cache<>(leafCacheSize);

        File f = new File(path);
        if(f.exists()) {
        	this.fa = new RandomAccessFile(path, "rw");
            System.out.println("File already exists, path: "+path+",size: " + fa.length() + " bytes");
            readHeaderFromFile(fa);
            initializeSlotPage(true);
            System.out.println("Tree file loaded");
        }
        else {
            System.out.println("Creating new tree file");
            this.fa = new RandomAccessFile(path, "rw");
            fa.setLength(0);
            initializeSlotPage(false);
            createTree();
            writeFileHeader();
            System.out.println("Tree file created");
        }
    }

    /**
     * Reads an existing file and generates a B+ configuration based on the stored values
     *
     * @param fa file to read from
     * @throws IOException
     */
    private void readHeaderFromFile(RandomAccessFile fa)
            throws IOException {
        fa.seek(0L);

        int headerNumber = fa.readInt();
        this.pageSize = fa.readInt();
        this.entrySize = fa.readInt();
        this.keySize = fa.readInt();
        this.totalPageNum = fa.readLong();
        this.maxPageNumber = fa.readLong();

        long rootIndex = fa.readLong();
        this.slotPageIndex = fa.readLong();
        this.root = readNodeFromFile(rootIndex);
    }

    /**
     * Write file header into new tree file
     *
     * @throws IOException
     */
    private void writeFileHeader() throws IOException {
        fa.seek(0L);
        fa.writeInt(treeHeaderSize);
        fa.writeInt(pageSize);
        fa.writeInt(entrySize);
        fa.writeInt(keySize);
        fa.writeLong(totalPageNum);
        fa.writeLong(maxPageNumber);
        fa.writeLong(root.getPageIndex());
        fa.writeLong(slotPageIndex);
    }

    /**
     * Read a tree node from tree file according to its index
     *
     * @param index index of the page in the file
     * @return a BPlusTreeNode<K,V> object
     * @throws IOException
     */
    private BPlusTreeNode<K,V> readNodeFromFile(long index) throws IOException {
        if(index < 0) {
            return(null);
        }
        fa.seek(index);
        int nodeType = (int)fa.readShort();

        switch (nodeType) {
            case BPlusTreeConst.NODE_TYPE_INTERNAL:
            case BPlusTreeConst.NODE_TYPE_ROOT_INTERNAL: {
                // try to find in cache
                if(internalNodeCache.containsKey(index)) {
                    return internalNodeCache.get(index);
                }
                // not in cache
                BPlusTreeInternalNode<K,V> node = new BPlusTreeInternalNode<K,V>(nodeType, index, valueSize);
                int curCapacity = fa.readInt();
                if(isPrimaryIndex) {
                    for (int i = 0; i < curCapacity; i++) {
                        node.keyList.add(i, (K)BPlusTreeUtils.readPrimaryKeyFromFile(fa, keyType, keySize));
                        node.ptrList.add(i, fa.readLong());
                    }
                }
                else { // secondary index
                    for (int i = 0; i < curCapacity; i++) {
                        node.keyList.add(i, (K)BPlusTreeUtils.readSecondaryKeyFromFile(fa, keyType, attributeSize, PKType, PKSize));
                        node.ptrList.add(i, fa.readLong());
                    }
                }
                node.ptrList.add(curCapacity, fa.readLong());
                node.setCapacity(curCapacity);
                node.setValid(true);
                // put node into cache
                internalNodeCache.put(index, node);
                return node;
            }
            case BPlusTreeConst.NODE_TYPE_LEAF:
            case BPlusTreeConst.NODE_TYPE_ROOT_LEAF: {
                // try to find in cache
                if(leafNodeCache.containsKey(index)) {
                    return leafNodeCache.get(index);
                }
                // not in cache
                long nextptr = fa.readLong();
                long prevptr = fa.readLong();
                int curCapacity = fa.readInt();
                BPlusTreeLeafNode<K,V> node = new BPlusTreeLeafNode<K,V>(nodeType, index, valueSize, nextptr, prevptr);

                if(isPrimaryIndex) {
                    for (int i = 0; i < curCapacity; i++) {
                        node.keyList.add(i, (K)BPlusTreeUtils.readPrimaryKeyFromFile(fa, keyType, keySize));
                        node.valueList.add(i, (V)readRowFromFile(fa, valueSize));
                    }
                }
                else { // secondary index
                    for (int i = 0; i < curCapacity; i++) {
                        node.keyList.add(i, (K)BPlusTreeUtils.readSecondaryKeyFromFile(fa, keyType, attributeSize, PKType, PKSize));
                        node.valueList.add(i, (V)readPKValueFromFile(fa, valueSize));
                    }
                }
                node.setCapacity(curCapacity);
                node.setValid(true);
                // put into cache
                leafNodeCache.put(index, node);
                return node;
            }
            default: //BPlusTreeConst.NODE_TYPE_SLOT_OVERFLOW
            {
                long nextptr = fa.readLong();
                int curCapacity = fa.readInt();
                BPlusTreeSlotNode<K,V> node = createSlotNode(index, nextptr);

                for (int i = 0; i < curCapacity; i++) {
                    node.freeSlots.add(i, fa.readLong());
                }
                node.setCapacity(curCapacity);
                return node;
            }
        }
    }



    /**
     * Function that initially creates the tree. Here we always
     * create a Leaf that acts as our Root, until we split it.
     * @return tree root.
     * @throws IOException
     */
    private BPlusTreeNode<K,V> createTree() throws IOException {
        if(root == null) {
            root = new BPlusTreeLeafNode<K,V>(BPlusTreeConst.NODE_TYPE_ROOT_LEAF, getFreeSlot(), valueSize, -1, -1);
            writeNodeToFile(root);
        }
        return root;
    }

    /**
     * to initialize slot nodes / pages
     * read in from tree file; if not exist, create one
     *
     * @param exists flag to indicate if the file already exists
     * @throws IOException
     */
    private void initializeSlotPage(boolean exists) throws IOException {
        fa.seek(treeHeaderSize);
        int slotPageElemNum = (pageSize-slotNodeHeaderSize) / keySize;
        if(!exists) {
            for (int i = 0; i < slotPageElemNum; i++) {
                fa.writeLong(-1); // null ptr(index)
            }
        }
        else {
            long val;
            for (int i = 0; i < slotPageElemNum; i++) {
                if ((val = fa.readLong()) == -1L) {
                    break;
                }
                slotPool.add(val);
            }

            // check if we have more pages
            long index = slotPageIndex;
            BPlusTreeSlotNode<K,V> node;
            while (index != -1L) {
                slotPool.add(index);
                node = (BPlusTreeSlotNode<K,V>)readNodeFromFile(index);
                slotPool.addAll(node.freeSlots);
                index = node.getNextPageIndex();
            }
        }
    }



    /**
     * calculates the degree of a node (internal node or leaf node)
     *
     * @param elementSize node element size
     * @param elementHeaderSize node header size
     * @return node degree
     */
    private int calculateDegree(int elementSize, int elementHeaderSize) {
        return((int)((pageSize - elementHeaderSize)/(2.0 * elementSize)));
    }

    /**
     * find an available index for a page
     *
     * @return page index
     */
    private long getFreeSlot() {
        long index;
        if(slotPool.size() > 0) {
            index = slotPool.pop();
            totalPageNum++;
            return index;
        }
        else {
            if (maxPageNumber <= totalPageNum) {
                maxPageNumber++;
            }
            totalPageNum++;
            index = pageSize * (maxPageNumber + 1);
            return index;
        }
    }

    /**
     * search by key
     *
     * @param key
     * @param useAll for secondary key
     * @return a search result object
     * @throws IOException
     */
    public SearchResult<V> searchByKey(K key, boolean useAll) throws IOException {
        if(this.root == null || this.root.getCapacity() == 0) { // empty tree
            return new SearchResult<V>();
        }
        return searchByKey(this.root, key, useAll);
    }


    /**
     * search by key
     *
     * @param node node to search
     * @param key
     * @param useAll for secondary key
     * @return a search result object
     * @throws IOException
     */
    private SearchResult<V> searchByKey(BPlusTreeNode<K,V> node, K key, boolean useAll) throws IOException {
        // search for the key
        int i = searchNode(node, key, BPlusTreeConst.SEARCH_EXACT, 0, node.getCapacity()-1, useAll);
        int nodeType = node.getNodeType();
        if(nodeType == BPlusTreeConst.NODE_TYPE_LEAF_OVERFLOW
                || nodeType == BPlusTreeConst.NODE_TYPE_LEAF
                || nodeType == BPlusTreeConst.NODE_TYPE_ROOT_LEAF) { // leaf node
            BPlusTreeLeafNode<K,V> leaf = (BPlusTreeLeafNode<K,V>)node;
            if(i >= 0 && i < node.getCapacity() && key.compareTo(leaf.keyList.get(i), useAll) == 0) {
                return new SearchResult<V>(leaf.valueList.get(i));
            }
            else { // key not found
                return new SearchResult<V>();
            }
        }
        else { // internal node
            BPlusTreeInternalNode<K,V> internal = (BPlusTreeInternalNode<K,V>)node;
            // padding to account for the last pointer (if needed)
            if(i != node.getCapacity() && key.compareTo(internal.keyList.get(i), useAll) > 0) {
                i++;
            }
            BPlusTreeNode<K,V> nextToSearch = readNodeFromFile(internal.ptrList.get(i));
            return searchByKey(nextToSearch, key, useAll);
        }
    }

    /**
     * search by key in a range
     *
     * @param lbound lower bound
     * @param uselbound whether use lower bound or not
     * @param lstrict whether lower bound is strict
     * @param hbound higher bound
     * @param usehbound whether use higher bound or not
     * @param hstrict whether higher bound is strict
     * @param useAll for secondary key
     * @return a search result object
     * @throws IOException
     */
    public SearchResult<V> searchByKeyWithRange(K lbound, boolean uselbound, boolean lstrict, K hbound, boolean usehbound, boolean hstrict, boolean useAll)
            throws IOException {
        if(this.root == null || root.getCapacity() == 0) { // empty tree
            return new SearchResult<V>();
        }
        return searchByKeyWithRange(this.root, lbound, uselbound, lstrict, hbound, usehbound, hstrict, useAll);
    }

    /**
     * search by key in a range
     *
     * @param node node to search
     * @param lbound lower bound
     * @param uselbound whether use lower bound or not
     * @param lstrict whether lower bound is strict
     * @param hbound higher bound
     * @param usehbound whether use higher bound or not
     * @param hstrict whether higher bound is strict
     * @param useAll for secondary key
     * @return a search result object
     * @throws IOException
     */
    private SearchResult<V> searchByKeyWithRange(BPlusTreeNode<K,V> node, K lbound, boolean uselbound, boolean lstrict, K hbound, boolean usehbound, boolean hstrict, boolean useAll)
            throws IOException {
        assert (uselbound || usehbound);
        LinkedList<V> rows = new LinkedList<V>();
        if(uselbound) {
            // search for the key
            int i = searchNode(node, lbound, BPlusTreeConst.SEARCH_PREV, 0, node.getCapacity()-1, useAll);
            int nodeType = node.getNodeType();
            if(nodeType == BPlusTreeConst.NODE_TYPE_LEAF_OVERFLOW
                    || nodeType == BPlusTreeConst.NODE_TYPE_LEAF
                    || nodeType == BPlusTreeConst.NODE_TYPE_ROOT_LEAF) { // leaf node
                BPlusTreeLeafNode<K, V> leaf = (BPlusTreeLeafNode<K, V>) node;
                // find first key bigger than lower bound
                int lcondition = lstrict ? 0 : -1;
                while(leaf.keyList.get(i).compareTo(lbound, useAll) <= lcondition) {
                    if(i < leaf.getCapacity() - 1) {
                        i++;
                    }
                    else {
                    	if(leaf.getNextPageIndex() != -1L) {
                    		leaf = (BPlusTreeLeafNode<K, V>)readNodeFromFile(leaf.getNextPageIndex());
                            i = 0;
                    	}
                    	else {
                    		return new SearchResult<V>(rows);
                    	}
                    }
                }
                // save values
                if(usehbound) {
                    int hcondition = hstrict ? -1 : 0;
                    while(leaf.keyList.get(i).compareTo(hbound, useAll) <= hcondition) {
                        rows.add(leaf.valueList.get(i));
                        if(i < leaf.getCapacity() - 1) {
                            i++;
                        }
                        else if(leaf.getNextPageIndex() != -1L){
                            leaf = (BPlusTreeLeafNode<K, V>)readNodeFromFile(leaf.getNextPageIndex());
                            i = 0;
                        }
                        else {
                            return new SearchResult<V>(rows);
                        }
                    }
                }
                else { // no higher bound
                    while(true) {
                        rows.add(leaf.valueList.get(i));
                        if(i < leaf.getCapacity() - 1) {
                            i++;
                        }
                        else if(leaf.getNextPageIndex() != -1L){
                            leaf = (BPlusTreeLeafNode<K, V>)readNodeFromFile(leaf.getNextPageIndex());
                            i = 0;
                        }
                        else {
                            return new SearchResult<V>(rows);
                        }
                    }
                }
            }
            else { // internal node
                BPlusTreeInternalNode<K,V> internal = (BPlusTreeInternalNode<K,V>)node;
                BPlusTreeNode<K,V> nextToSearch = readNodeFromFile(internal.ptrList.get(i));
                return searchByKeyWithRange(nextToSearch, lbound, uselbound, lstrict, hbound, usehbound, hstrict, useAll);
            }
        }
        else { // only use higher bound, node must be root now
            assert node == root;
            if(root == null) {
                return new SearchResult<V>();
            }
            BPlusTreeNode<K,V> iterator = root;
            while(iterator.getNodeType() != BPlusTreeConst.NODE_TYPE_LEAF
                    && iterator.getNodeType() != BPlusTreeConst.NODE_TYPE_ROOT_LEAF) {
                iterator = readNodeFromFile(((BPlusTreeInternalNode<K,V>) iterator).ptrList.getFirst());
            }
            int hcondition = hstrict ? -1 : 0;
            // now iterator is at left-bottom leaf node
            BPlusTreeLeafNode<K,V> leaf = (BPlusTreeLeafNode<K,V>)iterator;
            while(true) {
                int capacity = leaf.getCapacity();
                for(int i=0; i<capacity; i++) {
                    if(leaf.keyList.get(i).compareTo(hbound, useAll) > hcondition) {
                        return new SearchResult<V>(rows);
                    }
                    rows.push(leaf.valueList.get(i));
                }
                // move on to nextInternal leaf node
                long nextLeafIndex = leaf.getNextPageIndex();
                if(nextLeafIndex != -1L) {
                    leaf = (BPlusTreeLeafNode<K,V>)readNodeFromFile(nextLeafIndex);
                }
                else{
                    return new SearchResult<V>(rows);
                }
            }
        }
        return new SearchResult<V>();
    }

    /**
     * search all values
     *
     * @return a search result object
     * @throws IOException
     */
    public SearchResult<V> searchAll() throws IOException {
        if(root == null) {
            return new SearchResult<V>();
        }
        LinkedList<V> rows = new LinkedList<V>();
        BPlusTreeNode<K,V> iterator = root;
        while(iterator.getNodeType() != BPlusTreeConst.NODE_TYPE_LEAF
            && iterator.getNodeType() != BPlusTreeConst.NODE_TYPE_ROOT_LEAF) {
            iterator = readNodeFromFile(((BPlusTreeInternalNode<K,V>) iterator).ptrList.getFirst());
        }
        // now iterator is at left-bottom leaf node
        BPlusTreeLeafNode<K,V> leaf = (BPlusTreeLeafNode<K,V>)iterator;
        while(true) {
            int capacity = leaf.getCapacity();
            for(int i=0; i<capacity; i++) {
            	rows.push(leaf.valueList.get(i));
            }
            // move on to nextInternal leaf node
            long nextLeafIndex = leaf.getNextPageIndex();
            if(nextLeafIndex != -1L) {
                leaf = (BPlusTreeLeafNode<K,V>)readNodeFromFile(nextLeafIndex);
            }
            else{
                break;
            }
        }

        return new SearchResult<V>(rows);
    }



    /**
     * to insert value into the tree
     *
     * @param key
     * @param value
     * @throws IOException
     */
    public void insert(K key, V value) throws IOException {

        assert root != null;

        if(isFullNode(root)) {
            // create a new root
            BPlusTreeNode<K,V> childNode = this.root;
            BPlusTreeInternalNode<K,V> node = createInternalNode(getFreeSlot());
            node.setNodeType(BPlusTreeConst.NODE_TYPE_ROOT_INTERNAL);
            node.ptrList.add(0, childNode.getPageIndex());
            this.root = node;
            // split old root node
            splitNode(node, childNode, 0);
            writeFileHeader();
            insertToNode(node, key, value);
        }
        else {
            insertToNode(root, key, value);
        }
    }

    /**
     * to insert key and value to a node which is not full
     *
     * @param node node to insert into
     * @param key
     * @param value
     * @throws IOException
     */
    private void insertToNode(BPlusTreeNode<K,V> node, K key, V value)
            throws IOException, IllegalArgumentException {
        boolean useChild = true;
        int i = searchNode(node, key, BPlusTreeConst.SEARCH_ADD_ONE, 0, node.getCapacity()-1, true);
        // check if we have a leaf
        int nodeType = node.getNodeType();
        if(nodeType == BPlusTreeConst.NODE_TYPE_LEAF_OVERFLOW
            || nodeType == BPlusTreeConst.NODE_TYPE_LEAF
            || nodeType == BPlusTreeConst.NODE_TYPE_ROOT_LEAF) { // leaf node

            BPlusTreeLeafNode<K,V> leaf = (BPlusTreeLeafNode<K,V>)node;
            int j = (leaf.getCapacity() > 0 && i == 0
                    && leaf.keyList.getFirst().compareTo(key) > 0) ? i : i-1;
            if(leaf.getCapacity() > 0 && leaf.keyList.get(j).compareTo(key) == 0) { // same value already exists
                if(isPrimaryIndex) {
                	throw new IllegalArgumentException("duplicate primary key!"); // should not have same key
                }
                return;
            }
            else { // a new key
                leaf.keyList.add(i, key);
                leaf.valueList.add(i, value);
                leaf.increaseCapacity();
                writeNodeToFile(leaf);
            }
        }
        else { // internal node
            // convert type
            BPlusTreeInternalNode<K,V> internal = (BPlusTreeInternalNode<K,V>)node;
            BPlusTreeNode<K,V> childNode = readNodeFromFile(internal.ptrList.get(i));
            BPlusTreeNode<K,V> nextChild = null;
            if(isFullNode(childNode)) {
                splitNode(internal, childNode, i);
                if (internal.keyList.get(i).compareTo(key) < 0) {
                    useChild = false;
                    nextChild = readNodeFromFile(internal.ptrList.get(i+1));
                }
            }
            insertToNode(useChild ? childNode : nextChild, key, value);
        }
    }

    /**
     * update one value given key, used only for primary index; if no such key, do nothing
     *
     * @param key key
     * @param value new value
     * @throws IOException
     */
    public void update(K key, V value) throws IOException {
        if(root == null) {
            return;
        }
        updateToNode(root, key, value);
    }

    /**
     * update one value given key, used only for primary index; if no such key, do nothing
     *
     * @param node node to deal node
     * @param key key
     * @param value new value
     * @throws IOException
     */
    private void updateToNode(BPlusTreeNode<K,V> node, K key, V value) throws IOException {
        // search for the key
        int i = searchNode(node, key, BPlusTreeConst.SEARCH_EXACT, 0, node.getCapacity()-1, true);
        int nodeType = node.getNodeType();
        if(nodeType == BPlusTreeConst.NODE_TYPE_LEAF_OVERFLOW
                || nodeType == BPlusTreeConst.NODE_TYPE_LEAF
                || nodeType == BPlusTreeConst.NODE_TYPE_ROOT_LEAF) { // leaf node
            BPlusTreeLeafNode<K,V> leaf = (BPlusTreeLeafNode<K,V>)node;
            if(i >= 0 && i < node.getCapacity() && key.compareTo(leaf.keyList.get(i)) == 0) {
                leaf.valueList.set(i, value);
            }
            else { // key not found
                return;
            }
        }
        else { // internal node
            BPlusTreeInternalNode<K,V> internal = (BPlusTreeInternalNode<K,V>)node;
            // padding to account for the last pointer (if needed)
            if(i != node.getCapacity() && key.compareTo(internal.keyList.get(i)) > 0) {
                i++;
            }
            BPlusTreeNode<K,V> nextToUpdate = readNodeFromFile(internal.ptrList.get(i));
            updateToNode(nextToUpdate, key, value);
        }
    }

    /**
     * delete by key
     *
     * @param key
     * @return a DeleteResult object
     * @throws IOException
     */
    public DeleteResult deleteByKey(K key) throws IOException{
        return deleteByKeyAtNode(key, root, null, -1, -1);
    }

    /**
     * delete by key at a node; useAll = true
     *
     * @param key key
     * @param node node node
     * @param parent parent of the node
     * @param parentPointerIndex index in parent.ptrList
     * @param parentKeyIndex index in parent.keyList
     * @return a DeleteResult object
     * @throws IOException
     */
    private DeleteResult deleteByKeyAtNode(K key, BPlusTreeNode<K,V> node, BPlusTreeNode<K,V> parent,
                                           int parentPointerIndex, int parentKeyIndex)
            throws IOException{
        // check whether need to adjust the node
        if(node.isSparse(internalNodeDegree, leafNodeDegree)) {
            int nodeType = node.getNodeType();
            BPlusTreeNode<K,V> mergedNode = null;
            switch (nodeType) {
                case BPlusTreeConst.NODE_TYPE_ROOT_INTERNAL:
                    mergedNode = adjustRootNode(node);
                    break;
                case BPlusTreeConst.NODE_TYPE_ROOT_LEAF:
                    break;
                case BPlusTreeConst.NODE_TYPE_INTERNAL:
                    mergedNode = adjustInternalNode((BPlusTreeInternalNode<K, V>) node, (BPlusTreeInternalNode<K, V>) parent, parentPointerIndex, parentKeyIndex);
                    break;
                case BPlusTreeConst.NODE_TYPE_LEAF:
                    mergedNode = adjustLeafNode((BPlusTreeLeafNode<K,V>) node, (BPlusTreeInternalNode<K, V>) parent, parentPointerIndex, parentKeyIndex);
                    break;
                default:
                    break;
            }
            if(mergedNode != null) {
                node = mergedNode;
            }
        }
        // search key in node
        int i = searchNode(node, key, BPlusTreeConst.SEARCH_NEXT, 0, node.getCapacity()-1, true);
        int nodeType = node.getNodeType();
        if(nodeType == BPlusTreeConst.NODE_TYPE_INTERNAL
                || nodeType == BPlusTreeConst.NODE_TYPE_ROOT_INTERNAL) { // internal node
            BPlusTreeInternalNode<K,V> internal = (BPlusTreeInternalNode<K,V>)node;
            int parentPtrIndex = i;
            // check if we are at the end of this node
            if(key.compareTo(internal.keyList.get(i)) >= 0) {
                parentPtrIndex++;
            }
            // deal node next internal node
            BPlusTreeNode<K,V> nextInternal = readNodeFromFile(internal.ptrList.get(parentPtrIndex));
            return deleteByKeyAtNode(key, nextInternal, internal, parentPtrIndex, i);
        }
        else if(nodeType == BPlusTreeConst.NODE_TYPE_LEAF
                || nodeType == BPlusTreeConst.NODE_TYPE_ROOT_LEAF) { // leaf node
            BPlusTreeLeafNode<K,V> leaf = (BPlusTreeLeafNode<K,V>)node;
            if(i == leaf.getCapacity()) { // key not found
                return new DeleteResult();
            }
            else if(key.compareTo(leaf.keyList.get(i))!=0) { // key not found
                return new DeleteResult();
            }
            else { // key has been found
                V valueToDelete = leaf.valueList.remove(i);
                leaf.keyList.remove(i);
                leaf.decreaseCapacity();
                writeNodeToFile(leaf);
                return new DeleteResult(valueToDelete);
            }
        }
        return new DeleteResult();
    }

    /**
     * split an internal node
     *
     * @param parent parent of the split node
     * @param child node to split
     * @param index index of key in parent node to insert new key
     * @throws IOException
     */
    private void splitNode(BPlusTreeInternalNode<K,V> parent, BPlusTreeNode<K,V> child, int index) throws IOException {
        int splitAt;
        BPlusTreeNode<K,V> nodeToAdd;
        K keyToAdd;
        // internal node
        if(child.getNodeType() == BPlusTreeConst.NODE_TYPE_ROOT_INTERNAL
            || child.getNodeType() == BPlusTreeConst.NODE_TYPE_INTERNAL) {
            BPlusTreeInternalNode<K,V> internalToAdd;
            BPlusTreeInternalNode<K,V> internalToSplit = (BPlusTreeInternalNode<K,V>)child;
            internalToAdd = createInternalNode(getFreeSlot());
            splitAt = internalNodeDegree - 1;
            // move key and pointer to new node
            int i;
            for(i = 0; i < splitAt; i++) {
                internalToAdd.keyList.add(i, internalToSplit.keyList.pop());
                internalToAdd.ptrList.add(i, internalToSplit.ptrList.pop());
            }
            internalToAdd.ptrList.add(i, internalToSplit.ptrList.pop());
            // move one key up to parent node
            keyToAdd = internalToSplit.keyList.pop();
            // update capacity
            internalToAdd.setCapacity(splitAt);
            internalToSplit.setCapacity(splitAt);
            // update node type
            internalToSplit.setNodeType(BPlusTreeConst.NODE_TYPE_INTERNAL);
            // update parent node
            parent.ptrList.add(index, internalToAdd.getPageIndex());
            parent.keyList.add(index, keyToAdd);
            parent.increaseCapacity();
            // nodeToAdd to use later
            nodeToAdd = internalToAdd;
        }
        else { // leaf node
            BPlusTreeLeafNode<K,V> leafToAdd, nextLeaf;
            BPlusTreeLeafNode<K,V> leafToSplit = (BPlusTreeLeafNode<K,V>)child;
            leafToAdd = createLeafNode(getFreeSlot(), leafToSplit.getNextPageIndex(), leafToSplit.getPageIndex());
            // update the prevPageIndex of the node after leafToSplit
            if(leafToSplit.getNextPageIndex() != -1) {
                nextLeaf = (BPlusTreeLeafNode<K,V>)readNodeFromFile(leafToSplit.getNextPageIndex());
                nextLeaf.setPrevPageIndex(leafToAdd.getPageIndex());
                writeNodeToFile(nextLeaf);
            }
            // update nextPageIndex of leafToSplit
            leafToSplit.setNextPageIndex(leafToAdd.getPageIndex());
            // move values from leafToSplit to leafToAdd
            splitAt = leafNodeDegree - 1;
            for(int i = 0; i < splitAt; i++) {
                leafToAdd.keyList.push(leafToSplit.keyList.removeLast());
                leafToAdd.valueList.push(leafToSplit.valueList.removeLast());
                leafToAdd.increaseCapacity();
                leafToSplit.decreaseCapacity();
            }
            // update nodeType
            leafToSplit.setNodeType(BPlusTreeConst.NODE_TYPE_LEAF);
            // update parent
            parent.ptrList.add(index + 1, leafToAdd.getPageIndex());
            parent.keyList.add(index, leafToAdd.keyList.get(0));
            parent.increaseCapacity();
            // nodeToAdd to use later
            nodeToAdd = leafToAdd;
        }
        nodeToAdd.setValid(true);
        // update node info in tree file
        writeNodeToFile(nodeToAdd);
        writeNodeToFile(child);
        writeNodeToFile(parent);
        // update info in tree file
        fa.seek(treeHeaderSize-32);
        fa.writeLong(totalPageNum); // update page count
        fa.writeLong(maxPageNumber); // update max page number
    }

    /**
     * binary search a key in a tree node
     *
     * @param node node to search
     * @param key key to search
     * @param l start index of key
     * @param r end index of key
     * @param policy search policy
     * @param useAll for secondary key
     * @return index of the found key or the bound
     */
    private int searchNode(BPlusTreeNode<K,V> node, K key, int policy, int l, int r, boolean useAll) {
        if (l > r) { // search stop here
            switch (policy) {
                case BPlusTreeConst.SEARCH_PREV:
                    return l == 0 ? l : l - 1;
                case BPlusTreeConst.SEARCH_NEXT:
                    return (l > 0 && l == node.getCapacity()) ? l - 1 : l;
                default: //BPlusTreeConst.SEARCH_EXACT
                    return l;
            }
        }
        else {
            int mid = (l + r) / 2;
            K midKey;
            int nodeType = node.getNodeType();
            if(nodeType == BPlusTreeConst.NODE_TYPE_LEAF || nodeType == BPlusTreeConst.NODE_TYPE_ROOT_LEAF){
                midKey = ((BPlusTreeLeafNode<K,V>)node).keyList.get(mid);
            }
            else { // internal node
                midKey = ((BPlusTreeInternalNode<K,V>)node).keyList.get(mid);
            }
            int compare = midKey.compareTo(key, useAll);
            if (compare < 0) {
                return searchNode(node, key, policy, mid + 1, r, useAll);
            } 
            else if (compare > 0) {
                return searchNode(node, key, policy, l, mid - 1, useAll);
            } 
            else if (policy == BPlusTreeConst.SEARCH_ADD_ONE){ // equal
                return mid+1;
            }
            else { // equal
            	return mid;
            }
        }
    }

    /**
     * internal node factory
     */
    private BPlusTreeInternalNode<K,V> createInternalNode(long pageIndex) {
        return new BPlusTreeInternalNode<K,V>(BPlusTreeConst.NODE_TYPE_INTERNAL, getFreeSlot(), valueSize);
    }

    /**
     * leaf node factory
     */
    private BPlusTreeLeafNode<K,V> createLeafNode(long pageIndex, long nextPage, long prevPage) {
        return new BPlusTreeLeafNode<K,V>(BPlusTreeConst.NODE_TYPE_LEAF, getFreeSlot(), valueSize, nextPage, prevPage);
    }

    /**
     * slot node factory
     */
    private BPlusTreeSlotNode<K,V> createSlotNode(long pageIndex, long nextPage) {
        return new BPlusTreeSlotNode<K,V>(BPlusTreeConst.NODE_TYPE_SLOT_OVERFLOW, getFreeSlot(), valueSize, nextPage);
    }

    /**
     * check if node is full
     */
    private boolean isFullNode(BPlusTreeNode<K,V> node) {
        return node.isFull(internalNodeDegree, leafNodeDegree, overflowNodeDegree);
    }

    /**
     * check if node is 'under-used'
     */
    private boolean isSparseNode(BPlusTreeNode<K,V> node) {
        return node.isSparse(internalNodeDegree, leafNodeDegree);
    }

    /**
     * update node information to tree file
     *
     * @param node
     * @throws IOException
     */
    private void writeNodeToFile(BPlusTreeNode<K,V> node)  throws IOException {
        // update node cache
        switch (node.getNodeType()) {
            case BPlusTreeConst.NODE_TYPE_ROOT_INTERNAL:
            case BPlusTreeConst.NODE_TYPE_INTERNAL:
                if(internalNodeCache.containsKey(node.getPageIndex())) {
                    internalNodeCache.put(node.getPageIndex(), (BPlusTreeInternalNode<K,V>)node);
                }
                break;
            case BPlusTreeConst.NODE_TYPE_ROOT_LEAF:
            case BPlusTreeConst.NODE_TYPE_LEAF:
                if(leafNodeCache.containsKey(node.getPageIndex())) {
                    leafNodeCache.put(node.getPageIndex(), (BPlusTreeLeafNode<K,V>)node);
                }
                break;
        }
        // write to file
        node.writeNode(fa, pageSize, treeHeaderSize, keyType, keySize);
        return;
    }

    /**
     * release a page slot
     *
     * @param pageIndex index of page to be release
     * @throws IOException
     */
    private void releasePage(long pageIndex) throws IOException{
        slotPool.add(pageIndex);
        totalPageNum--;
        deleteCount++;
        // check whether need to condition pages
        if(deleteCount == conditionThreshold) {
            deleteCount = 0; // reset
            updateSlotPage();
        }
    }

    /**
     * update slot information in tree files
     *
     * @throws IOException
     */
    private void updateSlotPage() throws IOException {
        int size = slotPagePool.size();
        for(int i=0; i<size; i++) {
            slotPool.add(slotPagePool.removeFirst());
        }
        // update file size
        updateFileSize();
        if(slotPagePool.size() <= (pageSize-treeHeaderSize) / Long.SIZE) {
            // do not need slotPageIndex, just update slots in slotPool
            fa.seek(treeHeaderSize - 8);
            this.slotPageIndex = -1L;
            fa.writeLong(slotPageIndex);
            int slotNum = slotPool.size();
            if (slotNum > 0) {
                for (Long fpIndex : slotPool) {
                    fa.writeLong(fpIndex);
                }
            }
            // if number of slots is smaller than maximum, just write -1L as end
            if (slotNum < (pageSize-treeHeaderSize) / Long.SIZE) {
                fa.writeLong(-1L);
            }
        }
        else { // need extra slot page
            int maxSlotNumPerPage = 2 * slotNodeDegree - 1;
            int slotPageNum = (int) Math.ceil((slotPool.size()-(pageSize-treeHeaderSize) / Long.SIZE) / maxSlotNumPerPage);
            for(int i=0; i<slotPageNum; i++) {
                slotPagePool.add(slotPool.removeFirst());
            }
            slotPagePool.add(-1L); // end
            slotPageIndex = slotPagePool.getFirst();
            // update all slot pages in tree file
            BPlusTreeSlotNode<K,V> slotNode;
            int curSlot = (pageSize-treeHeaderSize) / Long.SIZE;
            for(int i=0; i<slotPageNum; i++) {
                slotNode = createSlotNode(slotPagePool.get(i),slotPagePool.get(i+1));
                for(int j=0; j < 2*slotNodeDegree-1 && curSlot < slotPool.size(); j++, curSlot++) {
                    slotNode.freeSlots.add(j, slotPool.get(curSlot));
                    slotNode.increaseCapacity();
                }
                writeNodeToFile(slotNode);
            }
            slotPagePool.removeLast(); // remove -1L
            // update slotPageIndex and other slots
            fa.seek(treeHeaderSize - 8);
            fa.writeLong(slotPageIndex);
            for(int i=0; i< (pageSize-treeHeaderSize) / Long.SIZE; i++) {
                fa.writeLong(slotPool.get(i));
            }
        }
    }

    /**
     * update file size according to real page usages
     *
     * @throws IOException
     */
    private void updateFileSize() throws IOException {
        Collections.sort(slotPool);
        long lastSlotIndex = slotPool.size() > 0 ? slotPool.getLast() : -1L;
        while (lastSlotIndex != -1L && lastSlotIndex == (maxPageNumber+1)*pageSize) {
            maxPageNumber--;
            slotPool.removeLast();
            lastSlotIndex = slotPool.size() > 0 ? slotPool.getLast() : -1L;
        }
        // adjust the length
        fa.setLength((maxPageNumber+1)*pageSize);
    }

    /**
     * Simple helper function to check if we can re-distribute the node
     * values.
     *
     * @param node node to check the capacity
     * @return the number of positions to check
     */
    private boolean canRedistribute(BPlusTreeNode<K,V> node) {
        if(node != null) {
            int nodeType = node.getNodeType();
            switch (nodeType) {
                case BPlusTreeConst.NODE_TYPE_INTERNAL:
                case BPlusTreeConst.NODE_TYPE_ROOT_INTERNAL:
                    return node.getCapacity() - 1 >= internalNodeDegree-1;
                case BPlusTreeConst.NODE_TYPE_LEAF:
                case BPlusTreeConst.NODE_TYPE_ROOT_LEAF:
                    return node.getCapacity() - 1 >= leafNodeDegree-1;
                default:
                    return false;
            }
        }
        return false;
    }

    /**
     * redistribute two adjacent leaf nodes
     *
     * @param to move value to the node
     * @param from remove value from the node
     * @param leftToRight direction of move
     * @param parent parent node
     * @param parentKeyIndex index of splitting key in parent node
     * @throws IOException
     */
    private void redistributeLeafNodes(BPlusTreeLeafNode<K,V> to, BPlusTreeLeafNode<K,V> from, boolean leftToRight,
                                   BPlusTreeInternalNode<K,V> parent, int parentKeyIndex)
            throws IOException {
        K key; // need to pass to parent node
        if(leftToRight) { // move (key,value) from left to right leaf
            to.valueList.push(from.valueList.removeLast());
            to.keyList.push(from.keyList.removeLast());
            to.increaseCapacity();
            from.decreaseCapacity();
            key = to.keyList.get(0);
        }
        else { // move (key,value) from right to left leaf
            to.valueList.addLast(from.valueList.pop());
            to.keyList.addLast(from.keyList.pop());
            to.increaseCapacity();
            from.decreaseCapacity();
            key = from.keyList.get(0);
        }
        // update parent key
        parent.keyList.set(parentKeyIndex, key);
        // update tree file
        writeNodeToFile(to);
        writeNodeToFile(from);
        writeNodeToFile(parent);
    }

    /**
     * redistribute two adjacent internal nodes
     *
     * @param to move value to the node
     * @param from remove value from the node
     * @param leftToRight direction of move
     * @param parent parent node
     * @param parentKeyIndex index of splitting key in parent node
     * @throws IOException
     */
    private void redistributeInternalNodes(BPlusTreeInternalNode<K,V> to, BPlusTreeInternalNode<K,V> from, boolean leftToRight,
                                       BPlusTreeInternalNode<K,V> parent, int parentKeyIndex)
            throws IOException {
        K key; // need to pass to parent node
        K parentKey = parent.keyList.get(parentKeyIndex); // need to move from parent node to one of the two children
        if(leftToRight) { // move key from left to parent, parent to right
            to.keyList.push(parentKey);
            key = from.keyList.removeLast();
            to.ptrList.push(from.ptrList.removeLast());
            to.increaseCapacity();
            from.decreaseCapacity();
        }
        else { // move key from right to parent, parent to left
            to.keyList.addLast(parentKey);
            key = from.keyList.pop();
            to.ptrList.addLast(from.ptrList.pop());
            to.increaseCapacity();
            from.decreaseCapacity();
        }
        // update parent key
        parent.keyList.set(parentKeyIndex, key);
        // update tree file
        writeNodeToFile(to);
        writeNodeToFile(from);
        writeNodeToFile(parent);
    }

    /**
     * merge right leaf node to left leaf node, used when parent is root node
     *
     * @param left left leaf node
     * @param right right leaf node
     * @throws IOException
     */
    private void mergeLeafNodes(BPlusTreeLeafNode<K,V> left, BPlusTreeLeafNode<K,V> right)
        throws IOException {
        // move keys, values and pointers from right to left node
        int capacity = right.getCapacity();
        for(int i=0; i<capacity; i++) {
            left.keyList.addLast(right.keyList.pop());
            left.valueList.addLast(right.valueList.pop());
            left.increaseCapacity();
            right.decreaseCapacity();
        }
        // release the page slot of right node
        right.setValid(false);
        releasePage(right.getPageIndex());
    }

    /**
     * merge right leaf node to left leaf node
     *
     * @param left left internal node
     * @param right right internal node
     * @param other
     * @param parent parent of left and right nodes
     * @param parentPointerIndex index of pointer in parent
     * @param parentKeyIndex index of key in parent
     * @param isLeftOfNext
     * @param useNextPointer
     * @return merged node
     * @throws IOException
     */
    private BPlusTreeLeafNode<K,V> mergeLeafNodes(BPlusTreeLeafNode<K,V> left, BPlusTreeLeafNode<K,V> right, BPlusTreeLeafNode<K,V> other,
                                                          BPlusTreeInternalNode<K,V> parent, int parentPointerIndex, int parentKeyIndex, boolean isLeftOfNext, boolean useNextPointer)
            throws IOException{
        assert left.getCapacity() + right.getCapacity() <= 2*leafNodeDegree-1;
        if(isLeftOfNext && useNextPointer) {
            left.keyList.addLast(parent.keyList.get(parentKeyIndex+1));
        }
        else {
            left.keyList.addLast(parent.keyList.get(parentKeyIndex));
        }
        // move keys and pointers from right to left node
        int capacity = right.getCapacity();
        for(int i=0; i<capacity; i++) {
            left.keyList.addLast(right.keyList.pop());
            left.valueList.addLast(right.valueList.pop());
            left.increaseCapacity();
            right.decreaseCapacity();
        }
        // update prev and next pointer
        left.setNextPageIndex(right.getNextPageIndex());
        // update pointer in parent
        fixTheTopPointer(other, parent, parentPointerIndex,
                parentKeyIndex, isLeftOfNext, useNextPointer);
        if(right.getNextPageIndex() != -1) {
            BPlusTreeLeafNode<K,V> next = (BPlusTreeLeafNode<K,V>)readNodeFromFile(right.getNextPageIndex());
            next.setPrevPageIndex(left.getPageIndex());
            writeNodeToFile(next);
        }
        // release the page slot of right node
        right.setValid(false);
        releasePage(right.getPageIndex());
        // update
        parent.decreaseCapacity();
        writeNodeToFile(parent);
        writeNodeToFile(left);
        return left;
    }

    /**
     * merge right internal node to left internal node, used when parent is root node
     *
     * @param left left internal node
     * @param right right internal node
     * @param key key to split at
     * @throws IOException
     */
    private void mergeInternalNodes(BPlusTreeInternalNode<K,V> left, BPlusTreeInternalNode<K,V> right, K key)
        throws IOException{
        // move keys and pointers from right to left node
        left.keyList.addLast(key);
        left.increaseCapacity();
        int capacity = right.getCapacity();
        for(int i=0; i<capacity; i++) {
            left.keyList.addLast(right.keyList.pop());
            left.ptrList.addLast(right.ptrList.pop());
            left.increaseCapacity();
            right.decreaseCapacity();
        }
        left.ptrList.addLast(right.ptrList.pop());
        // release the page slot of right node
        right.setValid(false);
        releasePage(right.getPageIndex());
    }

    /**
     * merge right internal node to left internal node
     *
     * @param left left internal node
     * @param right right internal node
     * @param other
     * @param parent parent of left and right nodes
     * @param parentPointerIndex index of pointer in parent
     * @param parentKeyIndex index of key in parent
     * @param isLeftOfNext
     * @param useNextPointer
     * @return merged node
     * @throws IOException
     */
    private BPlusTreeInternalNode<K,V> mergeInternalNodes(BPlusTreeInternalNode<K,V> left, BPlusTreeInternalNode<K,V> right, BPlusTreeInternalNode<K,V> other,
                                    BPlusTreeInternalNode<K,V> parent, int parentPointerIndex, int parentKeyIndex, boolean isLeftOfNext, boolean useNextPointer)
            throws IOException{
        assert left.getCapacity() + right.getCapacity() <= 2*internalNodeDegree-1;
        if(isLeftOfNext && useNextPointer) {
            left.keyList.addLast(parent.keyList.get(parentKeyIndex+1));
        }
        else {
            left.keyList.addLast(parent.keyList.get(parentKeyIndex));
        }
        // move keys and pointers from right to left node
        int capacity = right.getCapacity();
        for(int i=0; i<capacity; i++) {
            left.keyList.addLast(right.keyList.pop());
            left.ptrList.addLast(right.ptrList.pop());
            left.increaseCapacity();
            right.decreaseCapacity();
        }
        left.ptrList.addLast(right.ptrList.pop());
        left.increaseCapacity();
        // release the page slot of right node
        right.setValid(false);
        releasePage(right.getPageIndex());
        // now fix the top pointer
        fixTheTopPointer(other, parent, parentPointerIndex,
                parentKeyIndex, isLeftOfNext, useNextPointer);
        // update
        parent.decreaseCapacity();
        writeNodeToFile(parent);
        writeNodeToFile(left);
        return left;
    }

    /**
     * adjust pointer in parent node during merging
     *
     * @param other another node
     * @param parent parent node
     * @param parentPointerIndex index of pointer in parent
     * @param parentKeyIndex index of key in parent
     * @param isLeftOfNext
     * @param useNextPointer
     */
    private void fixTheTopPointer(BPlusTreeNode<K,V> other, BPlusTreeInternalNode<K,V> parent,
                                  int parentPointerIndex, int parentKeyIndex,
                                  boolean isLeftOfNext, boolean useNextPointer) {
        if (useNextPointer) {
            if (isLeftOfNext) {
                parent.keyList.remove(parentKeyIndex + 1);
                parent.ptrList.remove(parentPointerIndex + 1);
            }
            else {
                parent.keyList.remove(parentKeyIndex);
                parent.ptrList.remove(parentPointerIndex + 1);
            }
        }
        else {
            if (isLeftOfNext) {
                parent.keyList.remove(parentKeyIndex);
                parent.ptrList.remove(parentPointerIndex);
            }
            else {
                parent.keyList.remove(parentKeyIndex);
                parent.ptrList.remove(parentPointerIndex);
                K key = null;
                int nodeType = other.getNodeType();
                switch (nodeType) {
                    case BPlusTreeConst.NODE_TYPE_ROOT_INTERNAL:
                    case BPlusTreeConst.NODE_TYPE_INTERNAL:
                        key = ((BPlusTreeInternalNode<K,V>)other).keyList.getFirst();
                        break;
                    case BPlusTreeConst.NODE_TYPE_ROOT_LEAF:
                    case BPlusTreeConst.NODE_TYPE_LEAF:
                        key = ((BPlusTreeLeafNode<K,V>)other).keyList.getFirst();
                        break;
                    default: // should not be here!!
                        break;
                }
                parent.keyList.set(parentKeyIndex - 1, key);
            }
        }
    }


    /**
     * adjust root node during deletion
     *
     * @param node root of the tree, supposed to be internal node
     * @return adjusted root node
     * @throws IOException
     */
    private BPlusTreeNode<K,V> adjustRootNode(BPlusTreeNode<K,V> node) throws IOException {
        if (node.getCapacity() > 1) { // no need to adjust
            return root;
        }
        BPlusTreeInternalNode<K,V> splitNode = (BPlusTreeInternalNode<K,V>)node;
        BPlusTreeNode<K,V> lChild, rChild;
        lChild = readNodeFromFile(splitNode.ptrList.get(0));
        rChild = readNodeFromFile(splitNode.ptrList.get(1));
        int lchildCapacity = lChild.getCapacity();
        int rchildCapacity = rChild.getCapacity();

        if(lChild.getNodeType() == BPlusTreeConst.NODE_TYPE_LEAF) {
            if(lchildCapacity > leafNodeDegree-1 && rchildCapacity > leafNodeDegree-1) {
                // both child is not sparse, no need to adjust
                return node;
            }
            // convert type
            BPlusTreeInternalNode<K,V> internal = (BPlusTreeInternalNode<K,V>)node;
            BPlusTreeLeafNode<K,V> lLeaf = (BPlusTreeLeafNode<K,V>) lChild;
            BPlusTreeLeafNode<K,V> rLeaf = (BPlusTreeLeafNode<K,V>) rChild;
            // redistribute
            boolean canRedistributeLeftChild = canRedistribute(rLeaf);
            boolean canRedistributeRightChild = canRedistribute(lLeaf);
            if(canRedistributeLeftChild) {
                redistributeLeafNodes(lLeaf, rLeaf, false, internal, 0);
            }
            else if(canRedistributeRightChild) {
                redistributeLeafNodes(rLeaf, lLeaf, true, internal, 0);
            }
            // merge the two nodes and promote them to root
            else {
                mergeLeafNodes(lLeaf, rLeaf);
                // update new root node
                lLeaf.setNodeType(BPlusTreeConst.NODE_TYPE_ROOT_LEAF);
                lLeaf.setNextPageIndex(-1L);
                lLeaf.setPrevPageIndex(-1L);
                // delete previous root page
                releasePage(root.getPageIndex());
                root = lChild;
                // update tree file
                writeFileHeader();
                writeNodeToFile(lChild);
                return lChild;
            }

        }
        else { // root is an internal node
            // check if it's time to merge
            if ((lchildCapacity + rchildCapacity) >= 2 * internalNodeDegree - 1) {
                // no need to merge to root
                return node;
            }
            // convert type
            BPlusTreeInternalNode<K,V> internal = (BPlusTreeInternalNode<K,V>)node;
            BPlusTreeInternalNode<K,V> lInternal = (BPlusTreeInternalNode<K,V>)lChild;
            BPlusTreeInternalNode<K,V> rInternal = (BPlusTreeInternalNode<K,V>)rChild;
            // redistribute
            boolean canRedistributeLeftChild = canRedistribute(rInternal);
            boolean canRedistributeRightChild = canRedistribute(lInternal);
            if(canRedistributeLeftChild) {
                redistributeInternalNodes(lInternal, rInternal, true, internal, 0);
            }
            else if(canRedistributeRightChild) {
                redistributeInternalNodes(rInternal, lInternal, false, internal, 0);
            }
            // merge the two nodes and promote them to root
            else {
                mergeInternalNodes(lInternal, rInternal, splitNode.keyList.getFirst());
                // update root node
                lInternal.setNodeType(BPlusTreeConst.NODE_TYPE_ROOT_INTERNAL);
                // delete previous root page
                releasePage(root.getPageIndex());
                root = lChild;
                // update tree file
                writeFileHeader();
                writeNodeToFile(lChild);
                return lChild;
            }
        }
        return root;
    }

    /**
     * adjust internal node during deletion
     *
     * @param node internal node to be adjusted
     * @param parent parent of node
     * @param parentPointerIndex index in parent.ptrList
     * @param parentKeyIndex index in parent.keyList
     * @return adjusted node
     * @throws IOException
     */
    private BPlusTreeNode<K,V> adjustInternalNode(BPlusTreeInternalNode<K,V> node, BPlusTreeInternalNode<K,V> parent,
                                                  int parentPointerIndex, int parentKeyIndex)
            throws IOException {
        BPlusTreeInternalNode<K,V> leftBrother = (BPlusTreeInternalNode<K,V>)readNodeFromFile(parent.ptrList.get(parentPointerIndex-1));
        BPlusTreeInternalNode<K,V> rightBrother = (BPlusTreeInternalNode<K,V>)readNodeFromFile(parent.ptrList.get(parentPointerIndex+1));
        boolean canRedistributeCurrent = canRedistribute(node);
        boolean canRedistributeLeftBrother = canRedistribute(leftBrother);
        boolean canRedistributeRightBrother = canRedistribute(rightBrother);

        boolean currentNodeAtLeftOfKey = parentKeyIndex == parentPointerIndex;
        if(canRedistributeLeftBrother) {
            // borrow one from left brother
            if(currentNodeAtLeftOfKey)
                redistributeInternalNodes(node,leftBrother,true,parent,parentKeyIndex-1);
            else
                redistributeInternalNodes(node,leftBrother,true,parent,parentKeyIndex);
        }
        else if(canRedistributeRightBrother) {
            // borrow one from right brother
            if(currentNodeAtLeftOfKey)
                redistributeInternalNodes(node,rightBrother,false,parent,parentKeyIndex);
            else
                redistributeInternalNodes(node,rightBrother,false,parent,parentKeyIndex+1);
        }
        else if(canRedistributeCurrent) {
            assert leftBrother != null || rightBrother != null;
            if(leftBrother != null) {
                // send one to left brother
                if(currentNodeAtLeftOfKey)
                    redistributeInternalNodes(leftBrother,node,false,parent,parentKeyIndex-1);
                else
                    redistributeInternalNodes(leftBrother,node,false,parent,parentKeyIndex);
            }
            else {
                // send one to right brother
                if(currentNodeAtLeftOfKey)
                    redistributeInternalNodes(rightBrother,node,true,parent,parentKeyIndex);
                else
                    redistributeInternalNodes(rightBrother,node,true,parent,parentKeyIndex+1);
            }
        }
        else { // cannot redistribute, have to merge nodes
            boolean isLeftOfNext = (parentPointerIndex > parentKeyIndex);
            if(leftBrother != null && leftBrother.isSparse(internalNodeDegree, leafNodeDegree)) {
                node = mergeInternalNodes(leftBrother,node,rightBrother,parent,parentPointerIndex,parentKeyIndex,isLeftOfNext,false);
            }
            else if(rightBrother != null && rightBrother.isSparse(internalNodeDegree,leafNodeDegree)) {
                node = mergeInternalNodes(node,rightBrother,leftBrother,parent,parentPointerIndex,parentKeyIndex,isLeftOfNext,true);
            }
            else {
                // should not reach here!!
            }
        }
        return node;
    }

    /**
     * adjust internal node during deletion
     *
     * @param node internal node to be adjusted
     * @param parent parent of node
     * @param parentPointerIndex index in parent.ptrList
     * @param parentKeyIndex index in parent.keyList
     * @return adjusted node
     * @throws IOException
     */
    private BPlusTreeNode<K,V> adjustLeafNode(BPlusTreeLeafNode<K,V> node, BPlusTreeInternalNode<K,V> parent,
                                                  int parentPointerIndex, int parentKeyIndex)
            throws IOException {
    	
        BPlusTreeLeafNode<K,V> leftBrother = null;
        BPlusTreeLeafNode<K,V> rightBrother = null;
        if(0 <= parentPointerIndex-1 && parentPointerIndex-1 < parent.ptrList.size()) {
        	leftBrother = (BPlusTreeLeafNode<K,V>)readNodeFromFile(parent.ptrList.get(parentPointerIndex-1));
        }
        if(0 <= parentPointerIndex+1 && parentPointerIndex+1 < parent.ptrList.size()) {
        	rightBrother = (BPlusTreeLeafNode<K,V>)readNodeFromFile(parent.ptrList.get(parentPointerIndex+1));
        }
        boolean canRedistributeCurrent = canRedistribute(node);
        boolean canRedistributeLeftBrother = canRedistribute(leftBrother);
        boolean canRedistributeRightBrother = canRedistribute(rightBrother);

        boolean currentNodeAtLeftOfKey = parentKeyIndex == parentPointerIndex;
        if(canRedistributeLeftBrother) {
            // borrow one from left brother
            if(currentNodeAtLeftOfKey)
                redistributeLeafNodes(node,leftBrother,true,parent,parentKeyIndex-1);
            else
                redistributeLeafNodes(node,leftBrother,true,parent,parentKeyIndex);
        }
        else if(canRedistributeRightBrother) {
            // borrow one from right brother
            if(currentNodeAtLeftOfKey)
                redistributeLeafNodes(node,rightBrother,false,parent,parentKeyIndex);
            else
                redistributeLeafNodes(node,rightBrother,false,parent,parentKeyIndex+1);
        }
        else if(canRedistributeCurrent) {
            assert leftBrother != null || rightBrother != null;
            if(leftBrother != null) {
                // send one to left brother
                if(currentNodeAtLeftOfKey)
                    redistributeLeafNodes(leftBrother,node,false,parent,parentKeyIndex-1);
                else
                    redistributeLeafNodes(leftBrother,node,false,parent,parentKeyIndex);
            }
            else {
                // send one to right brother
                if(currentNodeAtLeftOfKey)
                    redistributeLeafNodes(rightBrother,node,true,parent,parentKeyIndex);
                else
                    redistributeLeafNodes(rightBrother,node,true,parent,parentKeyIndex+1);
            }
        }
        else { // cannot redistribute, have to merge nodes
            boolean isLeftOfNext = (parentPointerIndex > parentKeyIndex);
            if(leftBrother != null && leftBrother.isSparse(internalNodeDegree, leafNodeDegree)) {
                node = mergeLeafNodes(leftBrother,node,rightBrother,parent,parentPointerIndex,parentKeyIndex,isLeftOfNext,false);
            }
            else if(rightBrother != null && rightBrother.isSparse(internalNodeDegree,leafNodeDegree)) {
                node = mergeLeafNodes(node,rightBrother,leftBrother,parent,parentPointerIndex,parentKeyIndex,isLeftOfNext,true);
            }
            else {
                // should not reach here!!
            }
        }
        return node;
    }

    /**
     * read in a row from tree file
     *
     * @param fa file access
     * @param valueSize size of row
     * @return a row
     * @throws IOException
     */
    private Row readRowFromFile(RandomAccessFile fa, int valueSize) throws IOException {
        byte[] tmp = new byte[valueSize];
        fa.read(tmp, 0, valueSize);
        return new Row(tmp);
    }

    /**
     * read in a primary key from tree file
     *
     * @param fa file access
     * @param valueSize size of key
     * @return a value
     * @throws IOException
     */
    private PrimaryKeyValue readPKValueFromFile(RandomAccessFile fa, int valueSize) throws IOException {
        byte[] tmp = new byte[valueSize];
        fa.read(tmp, 0, valueSize);
        return new PrimaryKeyValue(tmp, PKType);
    }

}
