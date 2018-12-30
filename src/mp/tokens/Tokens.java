package mp.tokens;
import util.annotations.Tags;

@Tags ({"Token", "Number", "Word", "Quote", "Plus", "Minus", "Start", "End", "Move", "Say", "Repeat", "Approach", "Pass", "Fail"})

public interface Tokens {
	
	public String getInput();
	public void setInput(String newInput);
}
