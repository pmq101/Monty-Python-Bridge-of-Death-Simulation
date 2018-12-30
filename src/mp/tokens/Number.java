package mp.tokens;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@Tags ({"Number"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input", "Value"})
@EditablePropertyNames({"Input"})

public class Number extends Token implements ValueIntFace {

	private int value;
	
	public Number(String initial) {
		super(initial);
		value = Integer.parseInt(input);
	}
	
	public int getValue() {
		return value;
	}	
}
