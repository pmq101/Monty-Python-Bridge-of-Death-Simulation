package mp.tokens;

import util.annotations.Tags;

@Tags({"Token"})
public class Token implements Tokens {
	
	String input;

	public Token(String initial) {
		input = initial;
	}
	
	public String getInput() {
		return input;
	}

	public void setInput(String newInput) {
		input = newInput;
	}
}
