package mp.display;

import java.awt.Component;

import mp.tokens.AScannerBean;
import mp.tokens.ScannerBean;
import util.annotations.Tags;

@Tags({"SingletonsCreator"})

public class SingletonsCreator {
	static ScannerBean scanner;
	static BridgeScene bridgeScene;
	static Table avatarTable;
	static CommandInterpreter commandInterpreter;
	static ConsoleSceneView consoleSceneView;
	static ObservableBridgeScenePainter observableBridgeScenePainter;
	static DelegatingBridgeSceneView delegatingBridgeSceneView;
	static BridgeSceneController bridgeSceneController;
	static CommandInterpreterController commandInterpreterController;
	static CommandInterpreterView commandInterpreterView;
	
	@Tags({"scannerFactoryMethod"})
	public static ScannerBean getOrCreateScannerBean() {
		if (scanner == null) {
			scanner = new AScannerBean();
		}
		return scanner;
	}
	
	@Tags({"bridgeSceneFactoryMethod"})
	public static BridgeScene getOrCreateBridgeScene() {
		if (bridgeScene == null) {
			bridgeScene = new ABridgeScene();
		}
		return bridgeScene;
	}
	
	@Tags({"avatarTableFactoryMethod"})
	public static Table getOrCreateAvatarTable() {
		if (avatarTable == null) {
			avatarTable = new ATable();
		}
		return avatarTable;
	}
	
	@Tags({"commandInterpreterFactoryMethod"})
	public static CommandInterpreter getOrCreateCommandInterpreter() {
		if (commandInterpreter == null) {
			commandInterpreter = new ACommandInterpreter();
		}
		return commandInterpreter;
	}
	
	@Tags({"consoleSceneViewFactoryMethod"})
	public static ConsoleSceneView getOrCreateConsoleSceneView() {
		if (consoleSceneView == null) {
			consoleSceneView = new AConsoleSceneView();
		}
		return consoleSceneView;
	}
	
	@Tags({"observableBridgeScenePainterFactoryMethod"})
	public static ObservableBridgeScenePainter getOrCreateObservableBridgeScenePainter() {
		if (observableBridgeScenePainter == null) {
			observableBridgeScenePainter = new AnObservableBridgeScenePainter();
		}
		return observableBridgeScenePainter;
	}
	
	@Tags({"delegatingBridgeSceneViewFactoryMethod"})
	public static DelegatingBridgeSceneView getOrCreateDelegatingBridgeSceneView() {
		if (delegatingBridgeSceneView == null) {
			delegatingBridgeSceneView = new ADelegatingBridgeSceneView();
		}
		return delegatingBridgeSceneView;
	}
	
	@Tags({"bridgeSceneControllerFactoryMethod"})
	public static BridgeSceneController getOrCreateBridgeSceneController() {
		if (bridgeSceneController == null) {
			bridgeSceneController = new ABridgeSceneController((Component) SingletonsCreator.getOrCreateObservableBridgeScenePainter());
		}
		return bridgeSceneController;
	}
	
	@Tags({"commandInterpreterControllerFactoryMethod"})
	public static CommandInterpreterController getOrCreateCommandInterpreterController() {
		if (commandInterpreterController == null) {
			commandInterpreterController = new ACommandInterpreterController();
		}
		return commandInterpreterController;
	}
	
	@Tags({"commandInterpreterViewFactoryMethod"})
	public static CommandInterpreterView getOrCreateCommandInterpreterView() {
		if (commandInterpreterView == null) {
			commandInterpreterView = new ACommandInterpreterView();
		}
		return commandInterpreterView;
	}
}
