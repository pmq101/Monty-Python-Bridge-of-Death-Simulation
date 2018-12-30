package mp.display;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;

@Tags({"Locatable"})

public interface Locatable extends PropertyListenerRegisterer {
	public int getX();
	public void setX(int newX);
	public int getY();
	public void setY(int newY);
	public List<PropertyChangeListener> getPropertyChangeListeners();
	public void notifyAllListeners(PropertyChangeEvent event);
}
