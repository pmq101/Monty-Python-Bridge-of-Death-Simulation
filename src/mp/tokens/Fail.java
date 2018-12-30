package mp.tokens;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags ({"Fail"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input", "Value"})
@EditablePropertyNames({"Input"})

public class Fail extends Word implements ValueStringFace {

	private String value;
	
	public Fail(String initial) {
		super(initial);
		value = input.toLowerCase();
	}
	
	public String getValue() {
		return value;
	}
}
