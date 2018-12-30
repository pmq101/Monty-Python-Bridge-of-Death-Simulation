package mp.display;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Image"})
@StructurePattern(StructurePatternNames.IMAGE_PATTERN)

public interface Images extends BoundedShape {
	public String getImageFileName();
	public void setImageFileName(String newImageFileName);
}
