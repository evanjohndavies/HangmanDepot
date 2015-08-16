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
	
	
	
	public void run() {
		
		System.out.println("hello world");
		initializeGame();	
		
		System.out.println("goodbye world");

	}
	
	
	
	
	private ConsoleView consoleView = new ConsoleView();
	private HangmanModel hangmanModel = new HangmanModel();
	private SecretWord secretWord = new SecretWord();;
	private String str;
	

}
