package Hangman;

public class WordIterator {

	public String WordIterator(String guessLetter, String word, String dashes) {
		char[] dashesArray = dashes.toCharArray();
	    char[] charWord = word.toCharArray();
	    char letter = guessLetter.charAt(0);
	    for (int i = 0; i < charWord.length; i++) {
	        if (letter == charWord[i]) {
	            dashesArray[i] = letter;
	        }
	    }
	    return String.valueOf(dashesArray).toUpperCase();
	}
}

