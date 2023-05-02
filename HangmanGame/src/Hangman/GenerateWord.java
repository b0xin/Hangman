package Hangman;

import java.util.Random;

public class GenerateWord {
	
	public String[] wordList; //initialise wordlist
	public char[] chosenWord;

	public String[] getWordList() {
		return wordList;
	}

	public void setWordList(String[] wordList) {
		this.wordList = wordList;
	}

	public char[] getChosenWord() {
		return chosenWord;
	}


	public String GenerateWord() {
		//////////////////////////Choose the word////////////////////////////////		

		Random rand = new Random(); //initialize random
		int randInt = rand.nextInt(wordList.length); //index number of word to choose
		this.chosenWord = wordList[randInt].toCharArray();
		return String.valueOf(chosenWord);
		/////////////////////////////////////////////////////////////////////////
	}

}
