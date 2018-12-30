package mp.tokens;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"ScannerBean"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"ScannedString", "Tokens", "TokenList"})
@EditablePropertyNames({"ScannedString"})

public class AScannerBean implements ScannerBean {

	String scannedString;
	Tokens[] tokenArray;
	ClearableTokenHistory tokenList;
	
	public AScannerBean() {
		scannedString = "";
		tokenArray = new Tokens[0];
		tokenList = new AClearableTokenHistory();
	}
	
	public int indexOf(String s, char ch, int fromIndex) {
		for (int i = fromIndex; i < s.length(); i++) {
			if (s.charAt(i) == ch) {
				return i;
			}
		}
		return -1;
	}
	
	public int indexOfNot(String s, char ch, int fromIndex) {
		for (int i = fromIndex; i < s.length(); i++) {
			if (s.charAt(i) != ch) {
				return i;
			}
		}
		return -1;
	}
	
	public void scanString(String s) {
		tokenList.clear();
		
		boolean status = true;
		int start = 0;
		int startBackup;
		int stop = 0;
		int i = 0;
		String token = "";
		Tokens[] largeTokenArray = new Tokens[s.length()];
		

		while (status) {
			startBackup = start;
			start = indexOfNot(s, ' ', stop);
			if (start != -1) {
				stop = indexOf(s, ' ', start);
			}
			if (start != -1 && stop != -1 && stop != s.length() - 1) {
				token = s.substring(start, stop);
			} else if (s.charAt(s.length() - 1) == ' ') {
				if (start != -1) {
					token = s.substring(start, s.length() - 1);
				} else {
					token = s.substring(startBackup, s.length() - 1);
				}
				status = false;
			} else {
				if (start != -1) {
					token = s.substring(start);
				} else {
					token = s.substring(startBackup);
				}
				status = false;
			}
			
			Tokens tokenObj;
			ValueIntFace t1;
			ValueStringFace t2;
			
			if ("move".equalsIgnoreCase(token)) {
				tokenObj = new Move(token);
				t2 = (ValueStringFace) tokenObj;
			} else if ("say".equalsIgnoreCase(token)) {
				tokenObj = new Say(token);
				t2 = (ValueStringFace) tokenObj;
			} else if ("repeat".equalsIgnoreCase(token)) {
				tokenObj = new Repeat(token);
				t2 = (ValueStringFace) tokenObj;
			} else if ("approach".equalsIgnoreCase(token)) {
				tokenObj = new Approach(token);
				t2 = (ValueStringFace) tokenObj;
			} else if ("pass".equalsIgnoreCase(token)) {
				tokenObj = new Pass(token);
				t2 = (ValueStringFace) tokenObj;
			} else if ("fail".equalsIgnoreCase(token)) {
				tokenObj = new Fail(token);
				t2 = (ValueStringFace) tokenObj;
			} else if ("RotateLeftArm".equalsIgnoreCase(token)) {
				tokenObj = new RotateLeftArm(token);
				t2 = (ValueStringFace) tokenObj;
			} else if ("RotateRightArm".equalsIgnoreCase(token)) {
				tokenObj = new RotateRightArm(token);
				t2 = (ValueStringFace) tokenObj;
			} else if ("Define".equalsIgnoreCase(token)) {
				tokenObj = new Define(token);
				t2 = (ValueStringFace) tokenObj;
			} else if ("Call".equalsIgnoreCase(token)) {
				tokenObj = new Call(token);
				t2 = (ValueStringFace) tokenObj;
			} else if ("Thread".equalsIgnoreCase(token)) {
				tokenObj = new Thread(token);
				t2 = (ValueStringFace) tokenObj;
			} else if ("Wait".equalsIgnoreCase(token)) {
				tokenObj = new Wait(token);
				t2 = (ValueStringFace) tokenObj;
			} else if ("ProceedAll".equalsIgnoreCase(token)) {
				tokenObj = new ProceedAll(token);
				t2 = (ValueStringFace) tokenObj;
			} else if ("Sleep".equalsIgnoreCase(token)) {
				tokenObj = new Sleep(token);
				t2 = (ValueStringFace) tokenObj;
			} else if ("Undo".equalsIgnoreCase(token)) {
				tokenObj = new Undo(token);
				t2 = (ValueStringFace) tokenObj;
			} else if ("Redo".equalsIgnoreCase(token)) {
				tokenObj = new Redo(token);
				t2 = (ValueStringFace) tokenObj;
			}
			
			else if (token.charAt(0) == '"') {
				token = s.substring(start + 1, indexOf(s, '"', start + 1));
				stop = indexOf(s, ' ', indexOf(s, '"', start + 1));
				tokenObj = new Quote(token);
			} else if (Character.isLetter(token.charAt(0))) {
				tokenObj = new Word(token);
				t2 = (ValueStringFace) tokenObj;
			} else if(token.charAt(0) == '+') {
				tokenObj = new Plus(token);
			} else if (token.charAt(0) == '-') {
				tokenObj = new Minus(token);
			} else if (token.charAt(0) == '{') {
				tokenObj = new Start(token);
			} else if(token.charAt(0) == '}') {
				tokenObj = new End(token);
			} else {
				tokenObj = new Number(token);
				t1 = (ValueIntFace) tokenObj;
			}
			
			if (start != -1) {
				largeTokenArray[i] = tokenObj;
				i++;
				tokenList.addElement(tokenObj);
			}
		}
		tokenArray = new Tokens[i];
		for (int k = 0; k < tokenArray.length; k++) {
			tokenArray[k] = largeTokenArray[k];
		}
	}
	
	public String getScannedString() {
		return scannedString;
	}
	
	public void setScannedString(String newString) {
		scannedString = newString;
		scanString(scannedString);
	}
	
	public Tokens[] getTokens() {
		return tokenArray;
	}
	
	public ClearableTokenHistory getTokenList() {
		return tokenList;
	}
}
