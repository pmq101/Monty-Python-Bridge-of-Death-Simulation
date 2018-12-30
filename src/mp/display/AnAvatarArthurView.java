package mp.display;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import util.annotations.Tags;

@Tags({"PaintListener"})

public class AnAvatarArthurView extends Component implements AvatarView {
	BridgeScene bridgeScene;
	ObservableBridgeScenePainter observablePainter;
	
	public AnAvatarArthurView() {
		bridgeScene = SingletonsCreator.getOrCreateBridgeScene();
		observablePainter = SingletonsCreator.getOrCreateObservableBridgeScenePainter();
		bridgeScene.getArthur().getHead().addPropertyChangeListener(this);
		bridgeScene.getArthur().getStringShape().addPropertyChangeListener(this);
		bridgeScene.getArthur().getArms().getLeftLine().addPropertyChangeListener(this);
		bridgeScene.getArthur().getArms().getRightLine().addPropertyChangeListener(this);
		bridgeScene.getArthur().getTorso().addPropertyChangeListener(this);
		bridgeScene.getArthur().getLegs().getLeftLine().addPropertyChangeListener(this);
		bridgeScene.getArthur().getLegs().getRightLine().addPropertyChangeListener(this);
	}

	public void paint(Graphics2D g) {
		super.paint(g);
		draw(g, bridgeScene.getArthur());
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
