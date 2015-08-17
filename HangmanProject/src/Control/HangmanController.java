package Control;

import Model.HangmanModel;
import Model.SecretWord;
import View.ConsoleView;
import acm.program.*;


public class HangmanController extends ConsoleProgram{
	
	
	
	public HangmanController(){
		
	}
	
	private void initializeGame(){
		

		
		while (!hangmanModel.openLexicon(
					consoleView.getInputString("Enter Lexicon File Name", this))){
						consoleView.printMsg("invalid file", this);
			}
		System.out.println("before game reset");
		hangmanModel.resetGame();

	}
	
	
	private Character getValidCharGuess(){
		
		boolean cont = true;
		Character inputChar;
		
		while(cont){
			
			inputChar = hangmanModel.getValidInput(
					consoleView.getInputString("Enter a Character, hit return", this));
				
			if(inputChar != null){
				consoleView.printMsg("valid entry from " + consoleView.getLastInput() + " " + inputChar, this);
				return(inputChar);
			}
			consoleView.printMsg(("Invalid Entry " + consoleView.getLastInput()), this);
		
		}
		// not needed as should never get here but eclipse complained
		return (null);
	}
	
	
	private void playTurn(){
				
		hangmanModel.processGuessEntry(getValidCharGuess());
		
	}
	
	private void updateDisplayStatus(){
		consoleView.printMsg("Guess Count " + hangmanModel.getGuessCount(),  this);
		consoleView.printMsg("Display Word " + hangmanModel.getDisplayWord(),  this);
		consoleView.printMsg("Letters Guessed " + hangmanModel.getLettersEntered(),  this);
		if (hangmanModel.wonGame()){
			consoleView.printMsg("Won Game " + hangmanModel.getDisplayWord(),  this);
		}
		if (hangmanModel.lostGame()){
				consoleView.printMsg("Lost Game " + hangmanModel.getDisplayWord(),  this);
		}

		
	}
	
	public void run() {
		
		System.out.println("hello world");
		initializeGame();	
		
		

		while (hangmanModel.getContinueGame()){
	
			playTurn();
			updateDisplayStatus();
			
		}
		
		System.out.println("goodbye world");

	}
	
	
	
	
	private ConsoleView consoleView = new ConsoleView();
	private HangmanModel hangmanModel = new HangmanModel();
	private SecretWord secretWord = new SecretWord();;
	

}
