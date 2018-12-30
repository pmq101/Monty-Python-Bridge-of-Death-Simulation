package mp.display;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.Tags;

@Tags({"Locatable"})
@PropertyNames({"X", "Y", "PropertyChangeListeners"})
@EditablePropertyNames({"X", "Y"})

public class ALocatable implements Locatable {
	int x;
	int y;
	List<PropertyChangeListener> propertyChangeListeners;
	
	public ALocatable(int initX, int initY) {
		x = initX;
		y = initY;
		propertyChangeListeners = new ArrayList<PropertyChangeListener>();
	}
	
	public int getX() {
		return x;
	}
	public void setX(int newX) {
		int oldVal = getX();
		x = newX;
		notifyAllListeners(new PropertyChangeEvent(this, "X", oldVal, x));
	}
	public int getY() {
		return y;
	}
	public void setY(int newY) {
		int oldVal = getY();
		y = newY;
		notifyAllListeners(new PropertyChangeEvent(this, "Y", oldVal, y));
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeListeners.add(listener);
	}
	
	public List<PropertyChangeListener> getPropertyChangeListeners() {
		return propertyChangeListeners;
	}
	
	public void notifyAllListeners(PropertyChangeEvent event) {
		for (int i = 0; i < propertyChangeListeners.size(); i++) {
			propertyChangeListeners.get(i).propertyChange(event);
		}
	}
}
