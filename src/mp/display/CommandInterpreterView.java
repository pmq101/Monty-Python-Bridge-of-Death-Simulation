package mp.display;

import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import util.annotations.Tags;

@Tags({"CommandInterpreterView"})

public interface CommandInterpreterView extends PropertyChangeListener, FrameGetters {
	public void composeLabelledField(JPanel panel, JLabel label, JTextField textField);
	public JFrame composeFrame();
}
