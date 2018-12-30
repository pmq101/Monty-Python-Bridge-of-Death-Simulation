package mp.display;

import java.beans.PropertyChangeEvent;
import util.annotations.Tags;

@Tags({"ConsoleSceneView"})

public class AConsoleSceneView implements ConsoleSceneView {
	BridgeScene bridgeScene;
	
	public AConsoleSceneView() {
		bridgeScene = SingletonsCreator.getOrCreateBridgeScene();
		
		bridgeScene.getArthur().getHead().addPropertyChangeListener(this);
		bridgeScene.getArthur().getStringShape().addPropertyChangeListener(this);
		bridgeScene.getArthur().getArms().getLeftLine().addPropertyChangeListener(this);
		bridgeScene.getArthur().getArms().getRightLine().addPropertyChangeListener(this);
		bridgeScene.getArthur().getTorso().addPropertyChangeListener(this);
		bridgeScene.getArthur().getLegs().getLeftLine().addPropertyChangeListener(this);
		bridgeScene.getArthur().getLegs().getRightLine().addPropertyChangeListener(this);
		
		bridgeScene.getLancelot().getHead().addPropertyChangeListener(this);
		bridgeScene.getLancelot().getStringShape().addPropertyChangeListener(this);
		bridgeScene.getLancelot().getArms().getLeftLine().addPropertyChangeListener(this);
		bridgeScene.getLancelot().getArms().getRightLine().addPropertyChangeListener(this);
		bridgeScene.getLancelot().getTorso().addPropertyChangeListener(this);
		bridgeScene.getLancelot().getLegs().getLeftLine().addPropertyChangeListener(this);
		bridgeScene.getLancelot().getLegs().getRightLine().addPropertyChangeListener(this);
		
		bridgeScene.getRobin().getHead().addPropertyChangeListener(this);
		bridgeScene.getRobin().getStringShape().addPropertyChangeListener(this);
		bridgeScene.getRobin().getArms().getLeftLine().addPropertyChangeListener(this);
		bridgeScene.getRobin().getArms().getRightLine().addPropertyChangeListener(this);
		bridgeScene.getRobin().getTorso().addPropertyChangeListener(this);
		bridgeScene.getRobin().getLegs().getLeftLine().addPropertyChangeListener(this);
		bridgeScene.getRobin().getLegs().getRightLine().addPropertyChangeListener(this);
		
		bridgeScene.getGalahad().getHead().addPropertyChangeListener(this);
		bridgeScene.getGalahad().getStringShape().addPropertyChangeListener(this);
		bridgeScene.getGalahad().getArms().getLeftLine().addPropertyChangeListener(this);
		bridgeScene.getGalahad().getArms().getRightLine().addPropertyChangeListener(this);
		bridgeScene.getGalahad().getTorso().addPropertyChangeListener(this);
		bridgeScene.getGalahad().getLegs().getLeftLine().addPropertyChangeListener(this);
		bridgeScene.getGalahad().getLegs().getRightLine().addPropertyChangeListener(this);
		
		bridgeScene.getGuard().getHead().addPropertyChangeListener(this);
		bridgeScene.getGuard().getStringShape().addPropertyChangeListener(this);
		bridgeScene.getGuard().getArms().getLeftLine().addPropertyChangeListener(this);
		bridgeScene.getGuard().getArms().getRightLine().addPropertyChangeListener(this);
		bridgeScene.getGuard().getTorso().addPropertyChangeListener(this);
		bridgeScene.getGuard().getLegs().getLeftLine().addPropertyChangeListener(this);
		bridgeScene.getGuard().getLegs().getRightLine().addPropertyChangeListener(this);
		
		bridgeScene.getGorge().getBridge().addPropertyChangeListener(this);
		bridgeScene.getGorge().getLeftGorgeLine().addPropertyChangeListener(this);
		bridgeScene.getGorge().getRightGorgeLine().addPropertyChangeListener(this);
		bridgeScene.getGuardArea().addPropertyChangeListener(this);
		bridgeScene.getKnightArea().addPropertyChangeListener(this);
	}

	public void propertyChange(PropertyChangeEvent event) {
		System.out.println(event);
	}

}
