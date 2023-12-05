package sentence;

public class ValidSentenceTest {
	
	public static boolean isSentenceValid(String str){
		boolean validity = true;
		
		//checks capital letter
		char firstLetter = str.charAt(0);
		if(Character.isLowerCase(firstLetter)) {
			validity = false;
		}
		
		//checks quotation marks
		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '"') {
				count++;
			}
		}
		if(count % 2 != 1) {
			validity = false;
		}
		
		//checks termination characters
		char lastLetter = str.charAt(str.length()-1);
		if(lastLetter == '.' || lastLetter == '?' || lastLetter == '!') {
			validity = true;
		}
		else {
			validity = false;
		}
		
		//checks for period characters not at the end
		for(int j = 0; j < str.length()-1; j++) {
			if(str.charAt(j) == '.') {
				validity = false;
			}
		}
		
		//checks numbers under 13
		String numString = "";
		for(int x = 0; x < str.length(); x++) {
			char c = str.charAt(x);
			if(Character.isDigit(c)) {
				numString += Character.toString(c);
			}
			if(Character.isSpaceChar(c)) { //indicates the full number is complete
				if(numString.length() > 0) {
					int number = Integer.parseInt(numString);
					if(number < 13) {
						validity = false;
					}
				}
			}
		}
		
		return validity;
	}

	public static void main(String[] args) {
		//declaration of sentences to test
		String sentence1 = "The quick brown fox said “hello Mr lazy dog”.";
		String sentence2 = "Are there 11, 12, or 13 lazy dogs?";
		String sentence3 = "There is no punctuation in this sentence";
		
		//testing sentences
		System.out.print(sentence1 + "\nThe above sentence is ");
		if(isSentenceValid(sentence1)) {
			System.out.println("valid.");
		}
		else {
			System.out.println("invalid.");
		}
		
		System.out.print(sentence2 + "\nThe above sentence is ");
		if(isSentenceValid(sentence2)) {
			System.out.println("valid.");
		}
		else {
			System.out.println("invalid.");
		}
		
		System.out.print(sentence3 + "\nThe above sentence is ");
		if(isSentenceValid(sentence3)) {
			System.out.println("valid.");
		}
		else {
			System.out.println("invalid.");
		}
	}
}
