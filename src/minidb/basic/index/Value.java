package minidb.basic.index;

/**
 * value stored in B+ tree
 * can be real row (class Row) or just primary key (class PrimaryKeyValue)
 *
 */
public class Value {

    public byte[] array;

    public Value() {
    }

    public Value(byte[] fileContent) {
        this.array = fileContent;
    }

}
