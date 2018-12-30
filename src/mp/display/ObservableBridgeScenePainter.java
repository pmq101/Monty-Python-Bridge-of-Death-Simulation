package mp.display;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import util.annotations.Tags;

@Tags({"ObservableBridgeScenePainter"})

public interface ObservableBridgeScenePainter {
	public void addPaintListener(PaintListener listener);
	public List<PaintListener> getPaintListeners();
	public void paint(Graphics g);
	public void repaint();
}
