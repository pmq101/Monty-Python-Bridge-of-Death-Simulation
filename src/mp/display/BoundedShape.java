package mp.display;

import util.annotations.Tags;

@Tags({"BoundedShape"})

public interface BoundedShape extends Locatable {
	public int getWidth();
	public void setWidth(int newWidth);
	public int getHeight();
	public void setHeight(int newHeight);
}
