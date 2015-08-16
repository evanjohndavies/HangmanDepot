package Control;

import Model.HangmanModel;
import Model.SecretWord;
import View.ConsoleView;
import acm.program.*;


public class HangmanController extends ConsoleProgram{
	
	
	
	public HangmanController(){
		
	}
	
	private void initializeGame(){
		
		while (true){
			if(hangmanModel.setUpLexicon(
					consoleView.getInputString("Enter Lexicon File Name", this))){
			break;
			}
			consoleView.printMsg("invalid file", this);
		}
		
		hangmanModel.resetWordToGuess();
		
		consoleView.printMsg(hangmanModel.getWordToGuess(), this);

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
		
		Character inputChar;
		
		inputChar= getValidCharGuess();
		
	}
	
	public void run() {
		
		boolean continueGame = true;
		
		
		System.out.println("hello world");
		initializeGame();	
		
		

		while (continueGame){
			
			playTurn();
			
			
		}
		
		System.out.println("goodbye world");

	}
	
	
	
	
	private ConsoleView consoleView = new ConsoleView();
	private HangmanModel hangmanModel = new HangmanModel();
	private SecretWord secretWord = new SecretWord();;
	private String str;
	

}
