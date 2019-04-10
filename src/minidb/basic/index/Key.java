package minidb.basic.index;

abstract public class Key implements Comparable<Key> {

    public Key() { }

    abstract public int compareTo(Key k);

    abstract public int compareTo(Key k, boolean useAll);
}
