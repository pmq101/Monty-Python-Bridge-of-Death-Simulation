package mp.display;

import util.annotations.Tags;

@Tags({"Avatar"})

public interface Avatar {
	public StringShape getStringShape();
	public Images getHead();
	public Angle getArms();
	public Angle getLegs();
	public Line getTorso();
	
	@Tags({"move"})
	public void move(int x, int y);
	
	@Tags({"scale"})
	public void scale(double scaleFactor);
}
