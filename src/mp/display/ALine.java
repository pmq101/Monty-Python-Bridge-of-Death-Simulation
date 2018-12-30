package mp.display;

import java.beans.PropertyChangeEvent;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags ({"RotatingLine"})
@StructurePattern(StructurePatternNames.LINE_PATTERN)
@PropertyNames({"X", "Y", "Height", "Width", "Radius", "Angle", "PropertyChangeListeners"})
@EditablePropertyNames({"Radius", "Angle", "X", "Y"})

public class ALine extends ALocatable implements Line {
	
	int height;
	int width;
	double radius;
	double angle;

	public ALine(int initX, int initY, double initRadius, double initAngle) {
		super(initX, initY);
		radius = initRadius;
		angle = initAngle;
	}
	
	public int getHeight() {
		return (int) (radius*Math.sin(angle));
	}

	public int getWidth() {
		return (int) (radius*Math.cos(angle));
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double getAngle() {
		return angle;
	}
	
	public void setRadius(double newRadius) {
		int oldHeight = getHeight();
		int oldWidth = getWidth();
		radius = newRadius;
		notifyAllListeners(new PropertyChangeEvent(this, "Height", oldHeight, getHeight()));
		notifyAllListeners(new PropertyChangeEvent(this, "Width", oldWidth, getWidth()));
		
	}
	
	public void setAngle(double newAngle) {
		int oldHeight = getHeight();
		int oldWidth = getWidth();
		angle = newAngle;
		notifyAllListeners(new PropertyChangeEvent(this, "Height", oldHeight, getHeight()));
		notifyAllListeners(new PropertyChangeEvent(this, "Width", oldWidth, getWidth()));
	}
	
	@Tags ({"rotate"})
	public void rotate(int units) {
		this.setAngle(this.getAngle() + Math.PI/32 * units);
	}
}
