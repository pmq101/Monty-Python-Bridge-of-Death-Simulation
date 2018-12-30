package main;
import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import mp.display.Line;
import mp.display.SingletonsCreator;
import mp.display.Table;
import mp.display.BridgeScene;
import mp.display.CommandInterpreter;
import mp.display.ABridgeScene;
import mp.display.ALine;
import mp.tokens.ScannerBean;
import mp.tokens.AScannerBean;
import util.annotations.Tags;
import util.misc.ThreadSupport;

@Tags({"ProgressBarCreator"})

public class Assignment9 {
	
	static Scanner scanner;
	final static int SLEEP = 2000;
	final static int SMALL_SLEEP = 1000;
	final static int MOVE_LENGTH = 15;
	final static int ROTATE_LENGTH = 20;
	final static int START = 50;
	final static int FRAMESIZE_X = 1500;
	final static int FRAMESIZE_Y = 1000;
	final static int FRAMESIZE_Y_ALT = 775;
	final static int SCROLL_TEST = 200;
	final static int TEST_MOVE_X = 350;
	final static int TEST_MOVE_Y = -50;
	final static int PROGRESS_X = 200;
	final static int PROGRESS_Y = 100;
	final static int BAR_MIN = 0;
	final static int BAR_MAX = 100;
	final static int THREE = 3;
	
	final static int ROTATE_TEST = 6;
	
	public static void main(String[] args) {
//		scanner = new Scanner(System.in);
//		processInput();
		
//		animateBridgeScene();
//		animateScanner();
//		animateCommandInterpreter();
//		animateConsoleSceneView();
		
		animateMVC();
	}
	
	public static void animateMVC() {
		BridgeScene bridgeScene = SingletonsCreator.getOrCreateBridgeScene();
		
		SingletonsCreator.getOrCreateDelegatingBridgeSceneView();
		SingletonsCreator.getOrCreateObservableBridgeScenePainter();
		SingletonsCreator.getOrCreateBridgeSceneController();
		
		OEFrame editor = ObjectEditor.edit(bridgeScene);
		editor.hideMainPanel();
		editor.setSize(FRAMESIZE_X, FRAMESIZE_Y_ALT);
		ThreadSupport.sleep(SLEEP);
		
		SingletonsCreator.getOrCreateCommandInterpreterView();
		SingletonsCreator.getOrCreateCommandInterpreterController();
		
		JProgressBar progressBar = getProgressBar();
		ThreadSupport.sleep(SLEEP);
		
		bridgeScene.getArthur().move(TEST_MOVE_X, TEST_MOVE_Y);
		progressBar.setValue(BAR_MAX / THREE);
		ThreadSupport.sleep(SLEEP);
		
		bridgeScene.getArthur().getStringShape().setText("'Tis I, King Arthur of COMP401!");
		progressBar.setValue((BAR_MAX / THREE) * 2);
		ThreadSupport.sleep(SLEEP);
		
		bridgeScene.getArthur().move(-TEST_MOVE_Y, -SCROLL_TEST);
		progressBar.setValue(BAR_MAX);
		ThreadSupport.sleep(SLEEP);
	}
	
	public static void animateConsoleSceneView() {
		BridgeScene bridgeScene = SingletonsCreator.getOrCreateBridgeScene();
		SingletonsCreator.getOrCreateConsoleSceneView();
		
		OEFrame editor = ObjectEditor.edit(bridgeScene);
		editor.hideMainPanel();
		editor.setSize(FRAMESIZE_X, FRAMESIZE_Y_ALT);
		ThreadSupport.sleep(SLEEP);
		
		bridgeScene.getArthur().move(TEST_MOVE_X, TEST_MOVE_Y);
		ThreadSupport.sleep(SLEEP);
		
		bridgeScene.getArthur().getStringShape().setText("I dub thee knight");
		ThreadSupport.sleep(SLEEP);
		
		bridgeScene.getArthur().getArms().getLeftLine().rotate(ROTATE_TEST);
		ThreadSupport.sleep(SLEEP);
		
		bridgeScene.getArthur().getArms().getRightLine().rotate(-ROTATE_TEST);
		ThreadSupport.sleep(SLEEP);
		
		bridgeScene.getArthur().getLegs().getLeftLine().rotate(ROTATE_TEST);
		ThreadSupport.sleep(SLEEP);
		
		bridgeScene.getArthur().getLegs().getRightLine().rotate(-ROTATE_TEST);
		ThreadSupport.sleep(SLEEP);
	}
	
	public static JProgressBar getProgressBar() {
		JFrame frame = new JFrame("Animation Progress");
		JPanel barPanel = new JPanel();
		JProgressBar progressBar = new JProgressBar();
		JPanel labelPanel = new JPanel();
		JLabel label = new JLabel("Progress");
		progressBar.setMinimum(BAR_MIN);
		progressBar.setMaximum(BAR_MAX);
		barPanel.add(progressBar);
		labelPanel.add(label);
		frame.setLayout(new GridLayout(2, 1));
		frame.add(barPanel);
		frame.add(labelPanel);
		frame.setSize(PROGRESS_X, PROGRESS_Y);
		frame.setVisible(true);
		return progressBar;
	}
		
	public static void processInput() {
		ScannerBean bean = new AScannerBean();
		
		System.out.println("What do you wish to input?");
		String str = scanner.nextLine();
		if (str.charAt(0) != '.') {
			bean.setScannedString(str);
			processInput();
		} else {
			System.out.println("Have a nice day!");
		}
	}
	
	@Tags ({"animateScanner()"})
	public static void animateScanner() {
		ScannerBean bean = new AScannerBean();
		OEFrame editor = ObjectEditor.edit(bean);
		editor.setSize(FRAMESIZE_X, FRAMESIZE_Y);
		
		bean.setScannedString("MoVe 050 { saY \"hi!\" } ");
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bean.setScannedString("REPeaT aPProaCH pAss FaIL");
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bean.setScannedString("ROTATElefTArM + rotatERIGHTarM - DEfiNe CaLL tHrEaD waIT prOCeeDALL slEEp uNdO rEDo");
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
	}
	
	@Tags ({"animateLine()"})
	public static void animateLine() {
		Line rotateLine = new ALine(50, 50, 200.0, 270.0);
		OEFrame editor = ObjectEditor.edit(rotateLine);
		for (int i = 0; i < ROTATE_LENGTH; i++) {
			rotateLine.setX(START + i);
			rotateLine.setY(START + i);
			rotateLine.rotate(i);
			editor.refresh();
			ThreadSupport.sleep(SMALL_SLEEP);
		}
		ThreadSupport.sleep(SLEEP);
	}
	
	public static void animateBridgeScene() {
		BridgeScene bridge = new ABridgeScene();
		OEFrame editor = ObjectEditor.edit(bridge);
		editor.setSize(FRAMESIZE_X, FRAMESIZE_Y);
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.approach(bridge.getLancelot());
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.say("What is your name?");
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.say("Sir Lancelot of Camelot!");
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.say("What is your quest?");
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.say("To seek the Holy Grail!");
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.say("What is your favorite color?");
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.say("Blue!");
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.getLancelot().getStringShape().setText("");
		bridge.passed();
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.approach(bridge.getRobin());
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.say("What is your name?");
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.say("Sir Robin of Camelot!");
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.say("What is your quest?");
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.say("To seek the Holy Grail!");
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.say("What is the capital of Assyria?");
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.say("I don't know that!");
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.failed();
		bridge.getRobin().getStringShape().setText("Ahh!");
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.getRobin().getStringShape().setText("");
		bridge.approach(bridge.getGalahad());
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.say("What is your name?");
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.say("Sir Galahad of Camelot!");
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.say("What is your quest?");
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.say("To seek the Holy Grail!");
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.say("What is your favorite color?");
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.say("Blue! No, I mean...");
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.failed();
		bridge.getGalahad().getStringShape().setText("Ahh!");
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.getGalahad().getStringShape().setText("");
		bridge.approach(bridge.getArthur());
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.say("What is your name?");
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.say("Arthur, King of the Britons!");
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.say("What is your quest?");
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.say("To seek the Holy Grail!");
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.say("What is the air-speed velocity of an unladen swallow?");
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.say("An African swallow or an European one?");
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.say("Huh? I don't know that!");
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.failed();
		bridge.getGuard().getStringShape().setText("Ahh!");
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.getGuard().getStringShape().setText("");
		bridge.scroll(SCROLL_TEST, SCROLL_TEST);
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridge.scroll(-SCROLL_TEST, -SCROLL_TEST);
		editor.refresh();
		ThreadSupport.sleep(SLEEP);
	}
	
	public static void animateCommandInterpreter() {
		ScannerBean scanner = SingletonsCreator.getOrCreateScannerBean();
		BridgeScene bridgeScene = SingletonsCreator.getOrCreateBridgeScene();
		CommandInterpreter commandInterpreter = SingletonsCreator.getOrCreateCommandInterpreter();
		OEFrame editorScan = ObjectEditor.edit(scanner);
		OEFrame editorBridge = ObjectEditor.edit(bridgeScene);
		OEFrame editorCom = ObjectEditor.edit(commandInterpreter);
		editorBridge.setSize(FRAMESIZE_X, FRAMESIZE_Y);
		editorScan.refresh();
		editorBridge.refresh();
		editorCom.refresh();
		ThreadSupport.sleep(SLEEP);
		
		bridgeScene.approach(bridgeScene.getArthur());
		editorScan.refresh();
		editorBridge.refresh();
		editorCom.refresh();
		ThreadSupport.sleep(SLEEP);
		
		commandInterpreter.setCommand("MoVe Arthur 100 20");
		editorScan.refresh();
		editorBridge.refresh();
		editorCom.refresh();
		ThreadSupport.sleep(SLEEP);
		
		commandInterpreter.setCommand("MoVe Arthur - 100 + 40");
		editorScan.refresh();
		editorBridge.refresh();
		editorCom.refresh();
		ThreadSupport.sleep(SLEEP);
		
		commandInterpreter.setCommand("MoVe Arthur + 75 - 050");
		editorScan.refresh();
		editorBridge.refresh();
		editorCom.refresh();
		ThreadSupport.sleep(SLEEP);
		
		commandInterpreter.setCommand("SaY \"What is your name?\" ");
		editorScan.refresh();
		editorBridge.refresh();
		editorCom.refresh();
		ThreadSupport.sleep(SLEEP);
		
		commandInterpreter.setCommand("saY \"King Arthur lol\" ");
		editorScan.refresh();
		editorBridge.refresh();
		editorCom.refresh();
		ThreadSupport.sleep(SLEEP);
		
		commandInterpreter.setCommand("saY \"Look at my console to see Table outputs\" ");
		editorScan.refresh();
		editorBridge.refresh();
		editorCom.refresh();
		ThreadSupport.sleep(SLEEP);
		
		Table table = SingletonsCreator.getOrCreateAvatarTable();
		table.put("arthur", bridgeScene.getArthur());
		table.put("lancelot", bridgeScene.getLancelot());
		table.put("lol", "ugh");
		
		System.out.println("Key: " + "arthur" + "   Value: " + table.get("arthur"));
		System.out.println("Key: " + "lancelot" + "   Value: " + table.get("lancelot"));
		System.out.println("Key: " + "lol" + "   Value: " + table.get("lol"));
		
		table.put("lol", "orgh");
		System.out.println("Table now used called put method: table.put(\"lol\", \"orgh\")");
		System.out.println("Key: " + "lol" + "   Value: " + table.get("lol"));
	}
}
