package mp.display;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"String"})
@StructurePattern(StructurePatternNames.STRING_PATTERN)

public interface StringShape extends Locatable {
	public String getText();
	public void setText(String newSpeech);
}
