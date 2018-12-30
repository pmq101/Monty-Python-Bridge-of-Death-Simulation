package mp.display;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags ({"RotatingLine"})
@StructurePattern(StructurePatternNames.LINE_PATTERN)

public interface Line extends Locatable {
	public int getHeight();
	public int getWidth();
	public double getRadius();
	public double getAngle();
	public void setRadius(double newRadius);
	public void setAngle(double newAngle);
	
	@Tags ({"rotate"})
	public void rotate(int units);
}
