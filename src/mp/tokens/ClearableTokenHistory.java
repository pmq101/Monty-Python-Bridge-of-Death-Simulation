package mp.tokens;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"ClearableHistory"})
@StructurePattern(StructurePatternNames.VECTOR_PATTERN)

public interface ClearableTokenHistory extends TokenHistory {
	public void clear();
}
