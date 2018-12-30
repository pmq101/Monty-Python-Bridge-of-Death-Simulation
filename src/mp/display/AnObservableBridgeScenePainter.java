package mp.display;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import util.annotations.PropertyNames;
import util.annotations.Tags;

@Tags({"ObservableBridgeScenePainter"})
@PropertyNames({"PaintListeners"})

public class AnObservableBridgeScenePainter extends Component implements ObservableBridgeScenePainter {
	final static int FRAME_X = 1400;
	final static int FRAME_Y = 800;
	
	List<PaintListener> paintListeners;
	JFrame frame;
	
	public AnObservableBridgeScenePainter() {
		paintListeners = new ArrayList<PaintListener>();
		frame = new JFrame("BridgeScene UI");
		frame.add(this);
		frame.setSize(FRAME_X, FRAME_Y);
		frame.setVisible(true);
		setFocusable(true);
	}
	
	@Tags({"addPaintListener"})
	public void addPaintListener(PaintListener listener) {
		paintListeners.add(listener);
	}
	
	@Tags({"PaintListeners"})
	public List<PaintListener> getPaintListeners() {
		return paintListeners;
	}
	
	@Override
	public void paint(Graphics g) {
		for (int i = 0; i < paintListeners.size(); i++) {
			paintListeners.get(i).paint((Graphics2D) g);
		}
	}
}
