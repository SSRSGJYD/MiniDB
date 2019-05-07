package minidb.basic.index;

/**
 * a wrapper class for primary key as Value; stored in B+ tree leaf of secondary index
 *
 */
public class PrimaryKeyValue extends Value {

    public int PKType;

    public PrimaryKeyValue(byte[] fileContent, int PKType) {
        super(fileContent);
        this.PKType = PKType;
    }
}
