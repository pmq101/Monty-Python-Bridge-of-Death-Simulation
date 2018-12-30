package mp.display;

import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import util.annotations.Tags;

@Tags({"CommandInterpreterView"})

public class ACommandInterpreterView implements CommandInterpreterView {
	final static int FRAME_X = 500;
	final static int FRAME_Y = 200;
	final static int THREE = 3;
	
	CommandInterpreter commandInterpreter;
	JFrame frame;
	JTextField textField;
	JLabel textLabel;
	JPanel textPanel;
	JMenuItem menu;
	JButton button;
	

	public ACommandInterpreterView() {
		commandInterpreter = SingletonsCreator.getOrCreateCommandInterpreter();
		frame = new JFrame("Command Interpreter");
		textField = new JTextField();
		textLabel = new JLabel("Command: ");
		textPanel = new JPanel();
		menu = new JMenuItem("Move Avatars' X by 1");
		button = new JButton("Move Avatars' Y by 1");
		composeFrame();
		frame.setVisible(true);
		
		commandInterpreter.addPropertyChangeListener(this);
	}
	
	public void composeLabelledField(JPanel panel, JLabel label, JTextField textField) {
		panel.setLayout(new GridLayout(1, 2));
		panel.add(label);
		panel.add(textField);
	}
	
	public JFrame composeFrame() {
		composeLabelledField(textPanel, textLabel, textField);
		frame.setLayout(new GridLayout(THREE, 1));
		frame.add(textPanel);
		frame.add(menu);
		frame.add(button);
		frame.setSize(FRAME_X, FRAME_Y);
		return frame;
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public JTextField getTextField() {
		return textField;
	}

	public JLabel getTextLabel() {
		return textLabel;
	}

	public JPanel getTextPanel() {
		return textPanel;
	}
	
	public JMenuItem getMenuItem() {
		return menu;
	}

	public JButton getButton() {
		return button;
	}

	public void propertyChange(PropertyChangeEvent event) {
		String propertyName = event.getPropertyName();
		String newValue = (String) event.getNewValue();
		
		if ("command".equalsIgnoreCase(propertyName)) {
			textField.setText(newValue);
		}
	}
}
