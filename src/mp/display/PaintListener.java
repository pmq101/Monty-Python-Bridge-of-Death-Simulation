package mp.display;

import java.awt.Graphics2D;
import java.beans.PropertyChangeListener;

import util.annotations.Tags;

@Tags({"PaintListener"})

public interface PaintListener extends PropertyChangeListener {
	public void paint(Graphics2D g);
}
