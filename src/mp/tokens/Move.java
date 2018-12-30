package mp.tokens;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags ({"Move"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input", "Value"})
@EditablePropertyNames({"Input"})

public class Move extends Word implements ValueStringFace {

	private String value;
	
	public Move(String initial) {
		super(initial);
		value = input.toLowerCase();
	}
	
	public String getValue() {
		return value;
	}
}
