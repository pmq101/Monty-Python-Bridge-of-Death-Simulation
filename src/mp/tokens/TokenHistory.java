package mp.tokens;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.VECTOR_PATTERN)

public interface TokenHistory {
	public int size();
	public boolean isFull();
	public Tokens elementAt(int index);
	public void addElement(Tokens element);
}
