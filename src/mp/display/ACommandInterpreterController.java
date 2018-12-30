package mp.display;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import util.annotations.PropertyNames;
import util.annotations.Tags;

@Tags({"CommandInterpreterController"})
@PropertyNames({"TextField", "MenuItem", "Button"})

public class ACommandInterpreterController implements CommandInterpreterController {
	CommandInterpreter commandInterpreter;
	CommandInterpreterView commandView;
	BridgeScene bridgeScene;
	JTextField textField;
	JMenuItem menu;
	JButton button;

	public ACommandInterpreterController() {
		commandInterpreter = SingletonsCreator.getOrCreateCommandInterpreter();
		commandView = SingletonsCreator.getOrCreateCommandInterpreterView();
		bridgeScene = SingletonsCreator.getOrCreateBridgeScene();
		
		textField = getTextField();
		menu = getMenuItem();
		button = getButton();
		textField.addActionListener(this);
		menu.addActionListener(this);
		button.addActionListener(this);
	}
	
	public JFrame getFrame() {
		return commandView.getFrame();
	}

	public JTextField getTextField() {
		return commandView.getTextField();
	}

	public JLabel getTextLabel() {
		return commandView.getTextLabel();
	}

	public JPanel getTextPanel() {
		return commandView.getTextPanel();
	}
	
	public JMenuItem getMenuItem() {
		return commandView.getMenuItem();
	}
	
	public JButton getButton() {
		return commandView.getButton();
	}
	
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == textField) {
			String text = textField.getText();
			commandInterpreter.setCommand(text);
		} else if (event.getSource() == menu) {
			bridgeScene.getArthur().move(1, 0);
			bridgeScene.getLancelot().move(1, 0);
			bridgeScene.getRobin().move(1, 0);
			bridgeScene.getGalahad().move(1, 0);
			bridgeScene.getGuard().move(1, 0);
		} else if (event.getSource() == button) {
			bridgeScene.getArthur().move(0, 1);
			bridgeScene.getLancelot().move(0, 1);
			bridgeScene.getRobin().move(0, 1);
			bridgeScene.getGalahad().move(0, 1);
			bridgeScene.getGuard().move(0, 1);
		}
	}
}
