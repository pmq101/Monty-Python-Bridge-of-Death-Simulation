package mp.display;

import util.annotations.Tags;

@Tags({"DelegatingBridgeSceneView"})

public class ADelegatingBridgeSceneView implements DelegatingBridgeSceneView {
	
	ObservableBridgeScenePainter observablePainter;
	PaintListener arthurView;
	PaintListener lancelotView;
	PaintListener robinView;
	PaintListener galahadView;
	PaintListener guardView;
	PaintListener backgroundView;
	
	public ADelegatingBridgeSceneView() {
		observablePainter = SingletonsCreator.getOrCreateObservableBridgeScenePainter();
		arthurView = new AnAvatarArthurView();
		lancelotView = new AnAvatarLancelotView();
		robinView = new AnAvatarRobinView();
		galahadView = new AnAvatarGalahadView();
		guardView = new AnAvatarGuardView();
		backgroundView = new ABackgroundView();
		
		observablePainter.addPaintListener(arthurView);
		observablePainter.addPaintListener(lancelotView);
		observablePainter.addPaintListener(robinView);
		observablePainter.addPaintListener(galahadView);
		observablePainter.addPaintListener(guardView);
		observablePainter.addPaintListener(backgroundView);
	}
}
