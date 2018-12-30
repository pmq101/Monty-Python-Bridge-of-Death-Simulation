package mp.display;

import java.beans.PropertyChangeEvent;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"String"})
@StructurePattern(StructurePatternNames.STRING_PATTERN)
@PropertyNames({"X", "Y", "Text", "PropertyChangeListeners"})
@EditablePropertyNames({"X", "Y", "Text"})


public class AStringShape extends ALocatable implements StringShape {
	String text;
	
	public AStringShape (int initX, int initY, String initSpeech) {
		super(initX, initY);
		text = initSpeech;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String newSpeech) {
		String oldVal = getText();
		text = newSpeech;
		notifyAllListeners(new PropertyChangeEvent(this, "Text", oldVal, text));
	}
}
