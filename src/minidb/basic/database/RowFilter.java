package minidb.basic.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public interface RowFilter {

	Boolean method(LinkedHashMap<String,Object> objs);	
	
}
