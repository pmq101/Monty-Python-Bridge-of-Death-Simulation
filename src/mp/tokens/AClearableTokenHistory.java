package mp.tokens;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"ClearableHistory"})
@StructurePattern(StructurePatternNames.VECTOR_PATTERN)

public class AClearableTokenHistory extends ATokenHistory implements ClearableTokenHistory {

	public AClearableTokenHistory() {
		super();
	}
	
	@Tags({"clear"})
	public void clear() {
		size = 0;
	}
}
