package mp.display;

import java.awt.Graphics;

//@Tags({"PaintListener"})

public interface BackgroundView extends PaintListener {
	public void draw(Graphics g, Gorge gorge);
	public void draw(Graphics g, StandingArea standingArea);
}
