package minidb.result;

import java.util.LinkedList;

import minidb.basic.bplustree.BPlusTreeLeafNode;
import minidb.basic.database.Row;
import minidb.basic.index.Value;


public class SearchResult {

    public LinkedList<Value> rows;

    public SearchResult() {
        this.rows = new LinkedList<Value>();
    }

    public SearchResult(Value row) {
        this.rows = new LinkedList<Value>();
        rows.push(row);
    }


    public SearchResult(LinkedList<Value> rows) {
        this.rows = rows;
    }
}
