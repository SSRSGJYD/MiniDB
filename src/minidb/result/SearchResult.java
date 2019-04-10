package minidb.result;

import java.util.LinkedList;

import minidb.basic.bplustree.BPlusTreeLeafNode;
import minidb.basic.database.Row;
import minidb.basic.database.RowObject;


public class SearchResult {

    public LinkedList<RowObject> rows;

    public SearchResult() {
        this.rows = new LinkedList<RowObject>();
    }

    public SearchResult(RowObject row) {
        this.rows = new LinkedList<RowObject>();
        rows.push(row);
    }


    public SearchResult(LinkedList<RowObject> rows) {
        this.rows = rows;
    }
}
