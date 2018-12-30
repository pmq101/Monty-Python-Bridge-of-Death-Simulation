package mp.display;

import java.awt.Graphics;

//@Tags({"PaintListener"})

public interface AvatarView extends PaintListener {
	public void draw(Graphics g, Avatar avatar);
	public void draw(Graphics g, Images image);
	public void draw(Graphics g, StringShape string);
	public void draw(Graphics g, Line line);
}
