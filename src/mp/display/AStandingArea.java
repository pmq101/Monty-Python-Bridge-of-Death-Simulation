package mp.display;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.OVAL_PATTERN)
@PropertyNames({"X", "Y", "Width", "Height", "PropertyChangeListeners"})
@EditablePropertyNames({"X", "Y", "Width", "Height"})

public class AStandingArea extends ABoundedShape implements StandingArea {
	
	public AStandingArea(int initX, int initY, int initWidth, int initHeight) {
		super(initX, initY, initWidth, initHeight);
	}
}
