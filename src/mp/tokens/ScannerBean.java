package mp.tokens;
import util.annotations.Tags;

@Tags ({"ScannerBean"})

public interface ScannerBean {

	public int indexOf(String s, char ch, int fromIndex);
	public int indexOfNot(String s, char ch, int fromIndex);
	public String getScannedString();
	public void setScannedString(String newString);
	public Tokens[] getTokens();
	public ClearableTokenHistory getTokenList();
}
