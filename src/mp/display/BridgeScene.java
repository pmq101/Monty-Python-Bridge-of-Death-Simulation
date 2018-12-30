package mp.display;

import util.annotations.Tags;

@Tags({"BridgeScene"})

public interface BridgeScene {
	public Gorge getGorge();
	public StandingArea getKnightArea();
	public StandingArea getGuardArea();
	public void approach(Avatar avatar);
	public void say(String speech);
	public void passed();
	public void failed();
	public boolean getOccupied();
	public boolean getKnightTurn();
	public Avatar getInteractingKnight();
	public void scroll(int x, int y);
	public Avatar getArthur();
	public Avatar getLancelot();
	public Avatar getRobin();
	public Avatar getGalahad();
	public Avatar getGuard();
}
