package mp.display;

import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;

@Tags({"CommandInterpreter", "SignedMoveCommandInterpreter"})

public interface CommandInterpreter extends PropertyListenerRegisterer {
	public String getCommand();
	public void setCommand(String newCommand);
}
