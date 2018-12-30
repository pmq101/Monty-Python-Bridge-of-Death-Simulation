package mp.display;

import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;

@Tags({"BridgeScene"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Arthur", "Lancelot", "Robin", "Galahad", "Guard", "Gorge", "KnightArea", "GuardArea", "Occupied", "KnightTurn"})

public class ABridgeScene implements BridgeScene {
	final static int GORGE_X = 1000;
	final static int GORGE_Y = 600;
	final static int KNIGHT_AREA_X = 650;
	final static int KNIGHT_AREA_Y = 575;
	final static int GUARD_AREA_X = 850;
	final static int GUARD_AREA_Y = 575;
	final static int AREA_DIAM = 125;
	final static int FAILED_GORGE_Y = 200;
	
	final static int ARTHUR_X = 400;
	final static int ARTHUR_Y = 500;
	final static int LANCELOT_X = 200;
	final static int LANCELOT_Y = 200;
	final static int ROBIN_X = 200;
	final static int ROBIN_Y = 450;
	final static int GALAHAD_X = 350;
	final static int GALAHAD_Y = 250;
	
	Gorge gorge;
	StandingArea knightArea;
	StandingArea guardArea;
	Avatar arthur;
	Avatar lancelot;
	Avatar robin;
	Avatar galahad;
	Avatar guard;
	
	boolean occupied;
	boolean knightTurn;
	Avatar interactingKnight;
	
	public ABridgeScene() {
		gorge = new AGorge(GORGE_X, GORGE_Y);
		knightArea = new AStandingArea(KNIGHT_AREA_X, KNIGHT_AREA_Y, AREA_DIAM, AREA_DIAM);
		guardArea = new AStandingArea(GUARD_AREA_X, GUARD_AREA_Y, AREA_DIAM, AREA_DIAM);
		arthur = new AnAvatar(new AnImage("arthur.jpg", ARTHUR_X, ARTHUR_Y));
		lancelot = new AnAvatar(new AnImage("lancelot.jpg", LANCELOT_X, LANCELOT_Y));
		robin = new AnAvatar(new AnImage("robin.jpg", ROBIN_X, ROBIN_Y));
		galahad = new AnAvatar(new AnImage("galahad.jpg", GALAHAD_X, GALAHAD_Y));
		guard = new AnAvatar(new AnImage("guard.jpg", 0, 0));
		guard.move(guardArea.getX() - guard.getLegs().getLeftLine().getX() + guardArea.getWidth() / 2, guardArea.getY() - guard.getLegs().getLeftLine().getY());
		
		occupied = false;
		knightTurn = false;
		interactingKnight = null;
	}
	
	public Gorge getGorge() {
		return gorge;
	}
	public StandingArea getKnightArea() {
		return knightArea;
	}
	public StandingArea getGuardArea() {
		return guardArea;
	}
	public void approach(Avatar avatar) {
		if (!occupied) {
			avatar.move(knightArea.getX() - avatar.getLegs().getLeftLine().getX() + knightArea.getWidth() / 2, knightArea.getY() - avatar.getLegs().getLeftLine().getY());
			occupied = true;
			interactingKnight = avatar;
		}
	}
	public void say(String speech) {
		if (occupied) {
			if (!knightTurn) {
				interactingKnight.getStringShape().setText("");
				guard.getStringShape().setText(speech);
				knightTurn = true;
			} else {
				guard.getStringShape().setText("");
				interactingKnight.getStringShape().setText(speech);
				knightTurn = false;
			}
		}
	}
	public void passed() {
		if (occupied && !knightTurn) {
			interactingKnight.move(gorge.getBridge().getX() - interactingKnight.getLegs().getLeftLine().getX(), gorge.getBridge().getY() - interactingKnight.getLegs().getLeftLine().getY());
			interactingKnight.move(gorge.getBridge().getWidth() + gorge.getBridge().getWidth() / 2, 0);
			occupied = false;
			interactingKnight = null;
		}
	}
	public void failed() {
		if (occupied) {
			if (!knightTurn) {
				interactingKnight.move(gorge.getBridge().getX() - interactingKnight.getLegs().getLeftLine().getX() + gorge.getBridge().getWidth() / 2, gorge.getBridge().getY() - interactingKnight.getLegs().getLeftLine().getY() - FAILED_GORGE_Y);
			} else {
				guard.move(gorge.getBridge().getX() - guard.getLegs().getLeftLine().getX() + gorge.getBridge().getWidth() / 2, gorge.getBridge().getY() - guard.getLegs().getLeftLine().getY() - FAILED_GORGE_Y);
				knightTurn = false;
			}
			occupied = false;
			interactingKnight = null;
		}
	}
	
	@Tags({"Occupied"})
	public boolean getOccupied() {
		return occupied;
	}
	
	@Tags({"KnightTurn"})
	public boolean getKnightTurn() {
		return knightTurn;
	}
	
	@Tags({"InteractingKnight"})
	@Visible(false)
	public Avatar getInteractingKnight() {
		return interactingKnight;
	}
	
	@Tags({"scroll"})
	public void scroll(int x, int y) {
		gorge.getBridge().setX(gorge.getBridge().getX() - x);
		gorge.getBridge().setY(gorge.getBridge().getY() - y);
		gorge.getLeftGorgeLine().setX(gorge.getLeftGorgeLine().getX() - x);
		gorge.getLeftGorgeLine().setY(gorge.getLeftGorgeLine().getY() - y);
		gorge.getRightGorgeLine().setX(gorge.getRightGorgeLine().getX() - x);
		gorge.getRightGorgeLine().setY(gorge.getRightGorgeLine().getY() - y);
		knightArea.setX(knightArea.getX() - x);
		knightArea.setY(knightArea.getY() - y);
		guardArea.setX(guardArea.getX() - x);
		guardArea.setY(guardArea.getY() - y);
		arthur.move(-x, -y);
		lancelot.move(-x, -y);
		robin.move(-x, -y);
		galahad.move(-x, -y);
		guard.move(-x, -y);
	}
	
	public Avatar getArthur() {
		return arthur;
	}
	public Avatar getLancelot() {
		return lancelot;
	}
	public Avatar getRobin() {
		return robin;
	}
	public Avatar getGalahad() {
		return galahad;
	}
	public Avatar getGuard() {
		return guard;
	}
}
