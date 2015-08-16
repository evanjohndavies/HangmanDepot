package Model;

import java.util.*;

public class HangmanModel {

	
	public HangmanModel(){
		 
	}
	
	
	public boolean setUpLexicon(String fileName){
		
		// return(wordList.initializeLexiconFile(fileName));
		return(true);
		
	}
	
	public void resetWordToGuess(){
		
		wordToGuess.setSecretWord(wordList.getSecretWord());
		resetGuessCount();
		setEndGame(false);
		
	}
	
	public String getWordToGuess (){
		return(this.wordToGuess.getSecretWord());
		
	}
	
	private void resetGuessCount(){
		this.guessCount = 0;
		
	}
	
	public boolean wordContainsLetter (Character letter){
		

		// add the letter guessed to the guessed letter string 
		lettersEntered.add(letter);
		
		// if letter is in word update display string
		if(wordToGuess.containsLetter(letter))
		{
			return(true);
		}
		guessCount++;
		return (false);
	}
	
	public boolean wonGame(String testWord){
		
		if (wordToGuess.compareToSecretWord(testWord)){
		setEndGame(true);
		return(true);
		}
		return(false);
	}
	
	public boolean lostGame(){
		
		if (guessCount >= maxMisses){
			setEndGame(true);
			return(true);
		} else
			return(false);
	}
	
	
	public boolean getContinueGame (){
		
		return(!continueGameCondition);
	}
	
	private void setEndGame(boolean cond ){
		continueGameCondition = cond;
	}
	
	
	private Lexicon wordList = new Lexicon();
	private SecretWord wordToGuess = new SecretWord();
	public ArrayList <Character> lettersEntered = new ArrayList<Character>();
	private int guessCount;
	private static int maxMisses = 8;
	private boolean continueGameCondition; 


}
