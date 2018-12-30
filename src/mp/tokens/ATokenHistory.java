package mp.tokens;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.VECTOR_PATTERN)

public class ATokenHistory implements TokenHistory {
	final static int MAX_SIZE = 50;
	
	Tokens[] tokenList;
	int size;
	
	public ATokenHistory() {
		tokenList = new Tokens[MAX_SIZE];
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isFull() {
		return size == MAX_SIZE;
	}
	
	public Tokens elementAt(int index) {
		return tokenList[index];
	}
	
	public void addElement(Tokens element) {
		if (!isFull()) {
			tokenList[size] = element;
			size++;
		}
	}
}
