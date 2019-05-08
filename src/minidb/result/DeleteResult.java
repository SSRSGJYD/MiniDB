package minidb.result;

import java.util.LinkedList;

import minidb.basic.bplustree.BPlusTreeLeafNode;
import minidb.basic.database.Row;
import minidb.basic.index.Value;


public class DeleteResult {

    public LinkedList<Value> rows;

    public DeleteResult() {
        this.rows = new LinkedList<Value>();
    }

    public DeleteResult(Value row) {
        this.rows = new LinkedList<Value>();
        rows.push(row);
    }


    public DeleteResult(LinkedList<Value> rows) {
        this.rows = rows;
    }
}
