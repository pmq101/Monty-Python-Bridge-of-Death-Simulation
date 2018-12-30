package mp.display;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import util.annotations.Tags;

@Tags({"PaintListener"})

public class AnAvatarGuardView extends Component implements AvatarView {
	BridgeScene bridgeScene;
	ObservableBridgeScenePainter observablePainter;
	
	public AnAvatarGuardView() {
		bridgeScene = SingletonsCreator.getOrCreateBridgeScene();
		observablePainter = SingletonsCreator.getOrCreateObservableBridgeScenePainter();
		bridgeScene.getGuard().getHead().addPropertyChangeListener(this);
		bridgeScene.getGuard().getStringShape().addPropertyChangeListener(this);
		bridgeScene.getGuard().getArms().getLeftLine().addPropertyChangeListener(this);
		bridgeScene.getGuard().getArms().getRightLine().addPropertyChangeListener(this);
		bridgeScene.getGuard().getTorso().addPropertyChangeListener(this);
		bridgeScene.getGuard().getLegs().getLeftLine().addPropertyChangeListener(this);
		bridgeScene.getGuard().getLegs().getRightLine().addPropertyChangeListener(this);
	}

	public void paint(Graphics2D g) {
		super.paint(g);
		draw(g, bridgeScene.getGuard());
	}
	
	public void draw(Graphics g, Avatar avatar) {
		draw(g, avatar.getHead());
		draw(g, avatar.getStringShape());
		draw(g, avatar.getTorso());
		draw(g, avatar.getArms().getLeftLine());
		draw(g, avatar.getArms().getRightLine());
		draw(g, avatar.getLegs().getLeftLine());
		draw(g, avatar.getLegs().getRightLine());
	}
	public void draw(Graphics g, Images image) {
		Image img = Toolkit.getDefaultToolkit().getImage(image.getImageFileName());
		g.drawImage(img, image.getX(), image.getY(), this);
	}
	public void draw(Graphics g, StringShape string) {
		g.drawString(string.getText(), string.getX(), string.getY());
	}
	public void draw(Graphics g, Line line) {
		g.drawLine(line.getX(), line.getY(), line.getX() + line.getWidth(), line.getY() + line.getHeight());
	}

	public void propertyChange(PropertyChangeEvent event) {
		observablePainter.repaint();
	}
}
