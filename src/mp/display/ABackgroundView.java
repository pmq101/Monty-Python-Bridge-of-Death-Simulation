package mp.display;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;

import util.annotations.Tags;

@Tags({"PaintListener"})

public class ABackgroundView extends Component implements BackgroundView {
	BridgeScene bridgeScene;
	ObservableBridgeScenePainter observablePainter;

	public ABackgroundView() {
		bridgeScene = SingletonsCreator.getOrCreateBridgeScene();
		observablePainter = SingletonsCreator.getOrCreateObservableBridgeScenePainter();
		bridgeScene.getGorge().getBridge().addPropertyChangeListener(this);
		bridgeScene.getGorge().getLeftGorgeLine().addPropertyChangeListener(this);
		bridgeScene.getGorge().getRightGorgeLine().addPropertyChangeListener(this);
		bridgeScene.getKnightArea().addPropertyChangeListener(this);
		bridgeScene.getGuardArea().addPropertyChangeListener(this);
	}

	public void paint(Graphics2D g) {
		super.paint(g);
		draw(g, bridgeScene.getGorge());
		draw(g, bridgeScene.getKnightArea());
		draw(g, bridgeScene.getGuardArea());	}
	
	public void draw(Graphics g, Gorge gorge) {
		g.drawRect(gorge.getBridge().getX(), gorge.getBridge().getY(), gorge.getBridge().getWidth(), gorge.getBridge().getHeight());
		g.drawLine(gorge.getLeftGorgeLine().getX(), gorge.getLeftGorgeLine().getY(), gorge.getLeftGorgeLine().getX() + gorge.getLeftGorgeLine().getWidth(), gorge.getLeftGorgeLine().getY() + gorge.getLeftGorgeLine().getHeight());
		g.drawLine(gorge.getRightGorgeLine().getX(), gorge.getRightGorgeLine().getY(), gorge.getRightGorgeLine().getX() + gorge.getRightGorgeLine().getWidth(), gorge.getRightGorgeLine().getY() + gorge.getRightGorgeLine().getHeight());
	}
	public void draw(Graphics g, StandingArea standingArea) {
		g.drawOval(standingArea.getX(), standingArea.getY(), standingArea.getWidth(), standingArea.getHeight());
	}

	public void propertyChange(PropertyChangeEvent event) {
		observablePainter.repaint();
	}
}
