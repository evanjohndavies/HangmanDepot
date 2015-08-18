package Model;

import java.util.*;

public class HangmanModel {

	
	public HangmanModel(){
		 
	}
	
	
	public boolean openLexicon(String fileName){
		
		// return(wordList.initializeLexiconFile(fileName));
		
		if (wordList.checkFileExists(fileName))
		{
			wordList.openAndReadBufferedReader(fileName);
			return(true);
		}
		
		return(false);
		
	}
	
	public void resetGame(){
		
		wordToGuess.setSecretWord(wordList.getRandomWord());
		resetGuessCount();
		setEndGame(false);
		lettersEntered.removeAll(lettersEntered);
		
	}
	
	public String getWordToGuess (){
		return(this.wordToGuess.getSecretWord());
		
	}
	
	
	public Character getValidInput(String str){
		
		Character testChar;
		
		if(str != null  && str.length()>0){
			testChar = str.charAt(0);
			
			if(Character.isAlphabetic(testChar)){
				testChar = Character.toUpperCase(testChar);
				return(testChar);
			};
		}
		
		return(null);
		
	}
	

	
	public void processGuessEntry (Character letter){
				
		// if letter is in word update display string
		if(!wordToGuess.containsLetter(letter)){
			// add the letter guessed to the guessed letter string if not already there
			if (!lettersEntered.contains(letter)){
				lettersEntered.add(letter);
				guessCount++;
				}
		}
	}
	
	
	public ArrayList<Character> getLettersEntered(){
		return(lettersEntered);
	}
	
	public String getDisplayWord(){
		
		return(wordToGuess.getDisplayWord());
	}
	
	
	public boolean wonGame(){
		
		if (wordToGuess.compareToSecretWord(wordToGuess.getDisplayWord())){
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
	
	
	public int getGuessCount(){
		return(guessCount);
	}
	
	public boolean getContinueGame (){
		
		return(!continueGameCondition);
	}
	
	public boolean getExitGameCondition(){
		return(exitGame);
	}
	
	public void setExitGameCondition(boolean val){
		exitGame = val;
	}
	
	private void setEndGame(boolean cond ){
		continueGameCondition = cond;
	}
	
		
	private void resetGuessCount(){
		this.guessCount = 0;
		
	}
	private Lexicon wordList = new Lexicon();
	private SecretWord wordToGuess = new SecretWord();
	public ArrayList <Character> lettersEntered = new ArrayList<Character>();
	private int guessCount;
	private static int maxMisses = 8;
	private boolean continueGameCondition; 
	private boolean exitGame = false;


}
