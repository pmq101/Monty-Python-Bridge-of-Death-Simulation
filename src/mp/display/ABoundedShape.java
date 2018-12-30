package mp.display;

import java.beans.PropertyChangeEvent;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.Tags;

@Tags({"BoundedShape"})
@PropertyNames({"X", "Y", "Width", "Height", "PropertyChangeListeners"})
@EditablePropertyNames({"X", "Y", "Width", "Height"})

public class ABoundedShape extends ALocatable implements BoundedShape {
	int width;
	int height;
	
	public ABoundedShape(int initX, int initY, int initWidth, int initHeight) {
		super(initX, initY);
		width = initWidth;
		height = initHeight;
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int newWidth) {
		int oldVal = getWidth();
		width = newWidth;
		notifyAllListeners(new PropertyChangeEvent(this, "Width", oldVal, width));
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int newHeight) {
		int oldVal = getHeight();
		height = newHeight;
		notifyAllListeners(new PropertyChangeEvent(this, "Height", oldVal, height));
	}
}
