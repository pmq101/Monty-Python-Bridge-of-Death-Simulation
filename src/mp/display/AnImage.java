package mp.display;

import java.beans.PropertyChangeEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Image"})
@StructurePattern(StructurePatternNames.IMAGE_PATTERN)
@PropertyNames({"ImageFileName", "X", "Y", "Width", "Height", "PropertyChangeListeners"})
@EditablePropertyNames({"ImageFileName", "X", "Y", "Width", "Height"})

public class AnImage extends ABoundedShape implements Images {
	String imageFileName;
	
	public AnImage(String initImageFileName, int initX, int initY) {
		super(initX, initY, 0, 0);
		imageFileName = initImageFileName;
		Icon icon = new ImageIcon(imageFileName);
		width = icon.getIconWidth();
		height = icon.getIconHeight();
	}
	
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String newImageFileName) {
		String oldVal = getImageFileName();
		imageFileName = newImageFileName;
		notifyAllListeners(new PropertyChangeEvent(this, "ImageFileName", oldVal, imageFileName));
	}
}
