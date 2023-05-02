package Hangman;
import java.util.Scanner;

public class main {

	public main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Hangman!"); //welcome message		
	    GenerateWord generateWord = new GenerateWord();
	    generateWord.setWordList(new String[]{"hello","please","let","me","pass","the","assessment"}); //set the wordlist
	    String chosenWord = generateWord.GenerateWord(); // call the random method in GenerateWord
	    char[] chosenWordArray = chosenWord.toUpperCase().toCharArray();//convert to uppercase and into char array

	    
	    //generate dashes based on length of word
	    GenerateDashes generateDashes = new GenerateDashes();
	    String initDashes = generateDashes.GenerateDashes(chosenWord);//initial dashes
	    System.out.println("The word now looks like this: "+initDashes);//string
	    
	    //end of initialisation/////////////////////////////////////////////////////////////////

	    //game start init //////////////////////////////////////////////////////////////////////
	    String newDashes = initDashes;
	    int guessNumber = 8; // initialise number of guesses
	    boolean gameWon = false; // to end game if true
	    String previousGuesses = ""; //store previous guesses
	    ////////////////////////////////////////////////////////////////////////////////////////
	    while (newDashes.contains(String.valueOf("-"))) { // game is not finished 
		    	if (guessNumber>0) {
		    		
		    		//////////////////////////input function////////////////////////////////////
				    Scanner userInput = new Scanner(System.in); //input function
				    System.out.println("Your guess: ");
				    String newInput = userInput.next().toLowerCase();
				    
				    if (newInput.length()>1){//reject if more than one character
				    	System.out.println("You have inputted more than 1 character, please try again.");
					    System.out.println("The word now looks like this: "+newDashes);
					    continue;
				    }
				    //////////////////////////input function////////////////////////////////////
				    
				    
				    if (previousGuesses.toLowerCase().contains(newInput)) { //check if already guessed
				    	System.out.println("You have already guessed this letter. Please try again.");
				    	System.out.println("You have "+guessNumber+" guesses left.");
					    System.out.println("Previously guessed letters: "+previousGuesses);
				    } 
				    else {
					    
				    	if (chosenWord.contains(newInput)) { //correct guess
					    	System.out.println("That guess is correct.");
						    WordIterator wordIterator = new WordIterator();
						    newDashes = wordIterator.WordIterator(newInput,chosenWord,newDashes); // function to set dashes to uppercase letter if correct
					    	System.out.println("You have "+guessNumber+" guesses left.");
						    System.out.println("The word now looks like this: "+newDashes);
						    previousGuesses+=newInput.toUpperCase()+" ";
						    System.out.println("Previously guessed letters: "+previousGuesses);
					    }
					    else { //wrong guess
					    	
					    	System.out.println("There are no " +newInput.toUpperCase()+"'s "+ "in the word." );
						    System.out.println("The word now looks like this: "+newDashes);
					    	guessNumber--;
					    	System.out.println("You have "+guessNumber+" guesses left.");
						    previousGuesses+=newInput.toUpperCase()+" ";
						    System.out.println("Previously guessed letters: "+previousGuesses);
						    
					    }
				    }	
		    	}
	    
		    	else { 
		    		newDashes = " "; //break out of loop if not will be infinite while loop 
		    		System.out.println("You're completely hung.");
		    		System.out.println("The word was: " + chosenWord.toUpperCase()); //lose game
		    		
		    	}

		    	if (chosenWord.equals(newDashes.toLowerCase())) { //check if word was completed, if yes then let user win
		    	    System.out.println("You guessed the word: " + chosenWord.toUpperCase());
		    	    System.out.println("You win.");
		    	    }
		    	}

		}


	}



