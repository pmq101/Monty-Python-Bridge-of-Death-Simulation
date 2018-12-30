package mp.display;

import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags("Gorge")
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Bridge", "LeftGorgeLine", "RightGorgeLine"})

public class AGorge implements Gorge {
	
	final static int BRIDGE_WIDTH = 300;
	final static int BRIDGE_HEIGHT = 75;
	final static int GORGE_LINE_POSITION = BRIDGE_HEIGHT * 8;
	final static double GORGE_LINE_LENGTH = 1500.0;
	final static int GORGE_INIT_ROTATE = 16;

	Bridge bridge;
	Line leftGorgeLine;
	Line rightGorgeLine;
	
	public AGorge(int initX, int initY) {
		bridge = new ABridge(initX, initY, BRIDGE_WIDTH, BRIDGE_HEIGHT);
		leftGorgeLine = new ALine(bridge.getX(), bridge.getY() - GORGE_LINE_POSITION, GORGE_LINE_LENGTH, 0.0);
		leftGorgeLine.rotate(GORGE_INIT_ROTATE);
		rightGorgeLine = new ALine(bridge.getX() + bridge.getWidth(), bridge.getY() - GORGE_LINE_POSITION, GORGE_LINE_LENGTH, 0.0);
		rightGorgeLine.rotate(GORGE_INIT_ROTATE);
	}
	
	public Bridge getBridge() {
		return bridge;
	}
	public Line getLeftGorgeLine() {
		return leftGorgeLine;
	}
	public Line getRightGorgeLine() {
		return rightGorgeLine;
	}
}
