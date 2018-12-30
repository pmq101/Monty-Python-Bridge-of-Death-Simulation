package mp.display;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import mp.tokens.ClearableTokenHistory;
import mp.tokens.Minus;
import mp.tokens.Move;
import mp.tokens.Plus;
import mp.tokens.Quote;
import mp.tokens.Say;
import mp.tokens.ScannerBean;
import mp.tokens.ValueIntFace;
import mp.tokens.Word;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;

@Tags({"CommandInterpreter", "SignedMoveCommandInterpreter", "ObservableCommandInterpreter"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Command"})
@EditablePropertyNames({"Command"})

public class ACommandInterpreter implements CommandInterpreter {
	final static int THREE = 3;
	final static int FOUR = 4;
	final static int FIVE = 5;
	
	
	BridgeScene bridgeScene;
	ScannerBean scanner;
	String command;
	Table avatarTable;
	List<PropertyChangeListener> propertyChangeListeners;
	
	public ACommandInterpreter() {
		scanner = SingletonsCreator.getOrCreateScannerBean();
		bridgeScene = SingletonsCreator.getOrCreateBridgeScene();
		propertyChangeListeners = new ArrayList<PropertyChangeListener>();
	}
	
	public ACommandInterpreter(ScannerBean initScanner, BridgeScene initBridgeScene) {
		scanner = initScanner;
		bridgeScene = initBridgeScene;
	}
	
	@Visible(false)
	public BridgeScene getBridgeScene() {
		return bridgeScene;
	}
	
	@Visible(false)
	public ScannerBean getScannerBean() {
		return scanner;
	}
	
	public String getCommand() {
		return command;
	}
	public void setCommand(String newCommand) {
		String oldCommand = command;
		command = newCommand;
		notifyAllListeners(new PropertyChangeEvent(this, "Command", oldCommand, command));
		
		scanner.setScannedString(command);
		ClearableTokenHistory tokenList = scanner.getTokenList();
		
		if (avatarTable == null) {
			avatarTable = SingletonsCreator.getOrCreateAvatarTable();
			avatarTable.put("arthur", bridgeScene.getArthur());
			avatarTable.put("lancelot", bridgeScene.getLancelot());
			avatarTable.put("robin", bridgeScene.getRobin());
			avatarTable.put("galahad", bridgeScene.getGalahad());
			avatarTable.put("guard", bridgeScene.getGuard());
		}
		
		if (tokenList.elementAt(0) instanceof Move) {
			String name = ((Word) tokenList.elementAt(1)).getValue();
			Avatar avatar = (Avatar) avatarTable.get(name);
			int x = 0;
			int y = 0;
			
			if ((tokenList.elementAt(2) instanceof Plus || tokenList.elementAt(2) instanceof Minus) && (tokenList.elementAt(FOUR) instanceof Plus || tokenList.elementAt(FOUR) instanceof Minus)) {
				if (tokenList.elementAt(2) instanceof Plus) {
					x = ((ValueIntFace) tokenList.elementAt(THREE)).getValue();
				} else {
					x = ((ValueIntFace) tokenList.elementAt(THREE)).getValue() * -1;
				}
				if (tokenList.elementAt(FOUR) instanceof Plus) {
					y = ((ValueIntFace) tokenList.elementAt(FIVE)).getValue();
				} else {
					y = ((ValueIntFace) tokenList.elementAt(FIVE)).getValue() * -1;
				}
			} else if (tokenList.elementAt(2) instanceof Plus || tokenList.elementAt(2) instanceof Minus) {
				if (tokenList.elementAt(2) instanceof Plus) {
					x = ((ValueIntFace) tokenList.elementAt(THREE)).getValue();
				} else {
					x = ((ValueIntFace) tokenList.elementAt(THREE)).getValue() * -1;
				}
			} else if (tokenList.elementAt(THREE) instanceof Plus || tokenList.elementAt(THREE) instanceof Minus) {
				if (tokenList.elementAt(THREE) instanceof Plus) {
					y = ((ValueIntFace) tokenList.elementAt(FOUR)).getValue();
				} else {
					y = ((ValueIntFace) tokenList.elementAt(FOUR)).getValue() * -1;
				}
			} else {
				x = ((ValueIntFace) tokenList.elementAt(2)).getValue();
				y = ((ValueIntFace) tokenList.elementAt(THREE)).getValue();
			}
			
			avatar.move(x, y);
		} else if (tokenList.elementAt(0) instanceof Say) {
			bridgeScene.say(((Quote) tokenList.elementAt(1)).getInput());
		}
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
