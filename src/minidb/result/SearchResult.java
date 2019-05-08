package minidb.result;

import java.util.LinkedList;

import minidb.basic.index.Value;


public class SearchResult<V extends Value> {

    public LinkedList<V> rows;

    public SearchResult() {
        this.rows = new LinkedList<V>();
    }

    public SearchResult(V row) {
        this.rows = new LinkedList<V>();
        rows.push(row);
    }


    public SearchResult(LinkedList<V> rows) {
        this.rows = rows;
    }
}
