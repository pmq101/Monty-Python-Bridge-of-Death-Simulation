package mp.display;

import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Avatar"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"StringShape", "Head", "Arms", "Legs", "Torso"})

public class AnAvatar implements Avatar {
	final static int LEFTLINE_INIT_ROTATE = 24;
	final static int RIGHTLINE_INIT_ROTATE = 8;
	final static double TORSO_INIT_RADIUS = 60.0;
	final static int TORSO_INIT_ROTATE = 16;
	
	Images head;
	StringShape stringShape;
	Angle arms;
	Line torso;
	Angle legs;
	
	public AnAvatar(Images initHead) {
		head = initHead;
		stringShape = new AStringShape(head.getX() + head.getWidth(), head.getY(), "");
		arms = new AnAngle();
		arms.getLeftLine().rotate(LEFTLINE_INIT_ROTATE);
		arms.getRightLine().rotate(RIGHTLINE_INIT_ROTATE);
		arms.move(head.getX() + head.getWidth() / 2, head.getY() + head.getHeight());
		torso = new ALine(head.getX() + head.getWidth() / 2, head.getY() + head.getHeight(), TORSO_INIT_RADIUS, 0.0);
		torso.rotate(TORSO_INIT_ROTATE);
		legs = new AnAngle();
		legs.getLeftLine().rotate(LEFTLINE_INIT_ROTATE);
		legs.getRightLine().rotate(RIGHTLINE_INIT_ROTATE);
		legs.move(torso.getX() + torso.getWidth(), torso.getY() + torso.getHeight());
	}
	
	public StringShape getStringShape() {
		return stringShape;
	}
	public Images getHead() {
		return head;
	}
	public Angle getArms() {
		return arms;
	}
	public Angle getLegs() {
		return legs;
	}
	public Line getTorso() {
		return torso;
	}
	
	@Tags({"move"})
	public void move(int x, int y) {
		stringShape.setX(stringShape.getX() + x);
		stringShape.setY(stringShape.getY() + y);
		head.setX(head.getX() + x);
		head.setY(head.getY() + y);
		arms.move(x, y);
		torso.setX(torso.getX() + x);
		torso.setY(torso.getY() + y);
		legs.move(x, y);
	}
	
	@Tags({"scale"})
	public void scale(double scaleFactor) {
		head.setWidth(head.getWidth() * (int) scaleFactor);
		head.setHeight(head.getHeight() * (int) scaleFactor);
		stringShape.setX(head.getX() + head.getWidth());
		stringShape.setY(head.getY());
		arms.getLeftLine().setRadius(arms.getLeftLine().getRadius() * scaleFactor);
		arms.getRightLine().setRadius(arms.getRightLine().getRadius() * scaleFactor);
		arms.getLeftLine().setX(head.getX() + head.getWidth() / 2);
		arms.getLeftLine().setY(head.getY() + head.getHeight());
		arms.getRightLine().setX(head.getX() + head.getWidth() / 2);
		arms.getRightLine().setY(head.getY() + head.getHeight());
		torso.setRadius(torso.getRadius() * scaleFactor);
		torso.setX(head.getX() + head.getWidth() / 2);
		torso.setY(head.getY() + head.getHeight());
		legs.getLeftLine().setRadius(legs.getLeftLine().getRadius() * scaleFactor);
		legs.getRightLine().setRadius(legs.getRightLine().getRadius() * scaleFactor);
		legs.getLeftLine().setX(torso.getX() + torso.getWidth());
		legs.getLeftLine().setY(torso.getY() + torso.getHeight());
		legs.getRightLine().setX(torso.getX() + torso.getWidth());
		legs.getRightLine().setY(torso.getY() + torso.getHeight());
	}
}
