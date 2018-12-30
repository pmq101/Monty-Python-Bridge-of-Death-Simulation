package mp.display;

import util.annotations.Tags;

@Tags({"Angle"})

public interface Angle {
	public Line getLeftLine();
	public Line getRightLine();
	
	@Tags({"move"})
	public void move(int x, int y);
}
