package mp.display;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import util.annotations.Tags;

@Tags({"BridgeSceneController"})

public class ABridgeSceneController implements BridgeSceneController {
	final static int ARTHUR_X = 400;
	final static int ARTHUR_Y = 500;
	final static int LANCELOT_X = 200;
	final static int LANCELOT_Y = 200;
	final static int ROBIN_X = 200;
	final static int ROBIN_Y = 450;
	final static int GALAHAD_X = 350;
	final static int GALAHAD_Y = 250;
	
	int x;
	int y;
	BridgeScene bridgeScene;
	Component compObservablePainter;
	
	public ABridgeSceneController(Component initObservablePainter) {
		x = 0;
		y = 0;
		compObservablePainter = initObservablePainter;
		bridgeScene = SingletonsCreator.getOrCreateBridgeScene();
		compObservablePainter.addMouseListener(this);
		compObservablePainter.addKeyListener(this);
	}

	public void mouseClicked(MouseEvent e) {
		x = (int) e.getPoint().getX();
		y = (int) e.getPoint().getY();
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
	public void keyPressed(KeyEvent k) {}
	public void keyReleased(KeyEvent k) {}
	public void keyTyped(KeyEvent k) {
		char letter = k.getKeyChar();
		switch (letter) {
		case 'a':
			bridgeScene.getArthur().move(x - bridgeScene.getArthur().getLegs().getLeftLine().getX(), y - bridgeScene.getArthur().getLegs().getLeftLine().getY());
			break;
		case 'l':
			bridgeScene.getLancelot().move(x - bridgeScene.getLancelot().getLegs().getLeftLine().getX(), y - bridgeScene.getLancelot().getLegs().getLeftLine().getY());
			break;
		case 'r':
			bridgeScene.getRobin().move(x - bridgeScene.getRobin().getLegs().getLeftLine().getX(), y - bridgeScene.getRobin().getLegs().getLeftLine().getY());
			break;
		case 'g':
			bridgeScene.getGalahad().move(x - bridgeScene.getGalahad().getLegs().getLeftLine().getX(), y - bridgeScene.getGalahad().getLegs().getLeftLine().getY());
			break;
		case 'o':
			bridgeScene.getArthur().move(ARTHUR_X - bridgeScene.getArthur().getLegs().getLeftLine().getX(), ARTHUR_Y - bridgeScene.getArthur().getLegs().getLeftLine().getY());
			bridgeScene.getLancelot().move(LANCELOT_X - bridgeScene.getLancelot().getLegs().getLeftLine().getX(), LANCELOT_Y - bridgeScene.getLancelot().getLegs().getLeftLine().getY());
			bridgeScene.getRobin().move(ROBIN_X - bridgeScene.getRobin().getLegs().getLeftLine().getX(), ROBIN_Y - bridgeScene.getRobin().getLegs().getLeftLine().getY());
			bridgeScene.getGalahad().move(GALAHAD_X - bridgeScene.getGalahad().getLegs().getLeftLine().getX(), GALAHAD_Y - bridgeScene.getGalahad().getLegs().getLeftLine().getY());
			break;
		}
	}
}
