package Hangman;

public class GenerateDashes {

	public String dashes;
	
	public String GenerateDashes(String word) {
		dashes ="";
		for (int i = 0; i<word.length();i++) {
			dashes += "-";
		} return dashes;
	} 

}
