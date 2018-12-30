package mp.display;

import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Angle"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"LeftLine", "RightLine"})

public class AnAngle implements Angle {
	final static double INIT_LENGTH = 80.0;
	
	Line leftLine;
	Line rightLine;
	
	public AnAngle() {
		leftLine = new ALine(0, 0, INIT_LENGTH, 0.0);
		rightLine = new ALine(0, 0, INIT_LENGTH, 0.0);
	}
	
	public AnAngle(Line initLeftLine, Line initRightLine) {
		leftLine = initLeftLine;
		rightLine = initRightLine;
	}
	
	public Line getLeftLine() {
		return leftLine;
	}
	public Line getRightLine() {
		return rightLine;
	}
	
	@Tags({"move"})
	public void move(int x, int y) {
		leftLine.setX(leftLine.getX() + x);
		leftLine.setY(leftLine.getY() + y);
		rightLine.setX(rightLine.getX() + x);
		rightLine.setY(rightLine.getY() + y);
	}
}
