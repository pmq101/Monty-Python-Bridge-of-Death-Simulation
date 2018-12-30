package mp.display;

import java.util.ArrayList;
import java.util.List;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Table"})
@StructurePattern(StructurePatternNames.MAP_PATTERN)

public class ATable implements Table {
	List<String> keys;
	List<Object> values;

	public ATable() {
		keys = new ArrayList<String>();
		values = new ArrayList<Object>();
	}
	
	public void put(String key, Object val) {
		if (key == null || val == null) {
			//Does nothing
		} else if (keys.indexOf(key)!= -1 && values.get(keys.indexOf(key)) != null) {
			values.set(keys.indexOf(key), val);
		} else {
			keys.add(key);
			values.add(val);
		}
	}
	
	public Object get(String key) {
		if (keys.contains(key)) {
			return values.get(keys.indexOf(key));
		}
		return null;
	}
}
