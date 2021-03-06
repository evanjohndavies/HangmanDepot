package Control;



import Model.HangmanModel;
import Model.SecretWord;
import View.ConsoleView;
import View.HangmanCanvas;
import acm.program.*;


public class HangmanController extends ConsoleProgram{
	
	
	
	public HangmanController(){
		
	}
	
	public void init(){
			
		// adding display for hangman
		canvas = new HangmanCanvas ();
		add(canvas);
	}
	
	private void initializeGame(){
		
		while (!hangmanModel.openLexicon(
					consoleView.getInputString("Enter Lexicon File Name", this))){
						consoleView.printMsg("invalid file", this);
			}
		hangmanModel.resetGame();
		
		/* It is not necessary to pass canvas to itself.  I am doing this so that
		 * I can practice catching the object being updated and then refering to it in the 
		 * class and method that updates the object.  Rather another way is to 
		 * have the object update itself by self reference of this. 
		 */
		canvas.buildUIComponenents(canvas);
		canvas.reset();
		canvas.displayUpdate(hangmanModel.getDisplayWord(), hangmanModel.getLettersEntered());
	}
	
	
	private Character getValidCharGuess(){
		
		boolean cont = true;
		Character inputChar;
		
		while(cont){
			
			inputChar = hangmanModel.getValidInput(
					consoleView.getInputString("Enter a Character, hit return", this));
				
			if(inputChar != null){
				return(inputChar);
			}
			consoleView.printMsg(("Invalid Entry " + consoleView.getLastInput()), this);
		}
		// not needed as should never get here but eclipse complained
		return (null);
	}
	

	
	private void updateDisplayStatus(){
		consoleView.printMsg("Guess Count " + hangmanModel.getGuessCount(),  this);
		consoleView.printMsg("Display Word " + hangmanModel.getDisplayWord(),  this);
		consoleView.printMsg("Letters Guessed " + hangmanModel.getLettersEntered(),  this);
		canvas.displayUpdate(hangmanModel.getDisplayWord(), hangmanModel.getLettersEntered());
		if (hangmanModel.wonGame()){
			consoleView.printMsg("Won Game " + hangmanModel.getDisplayWord(),  this);
		}
		if (hangmanModel.lostGame()){
				consoleView.printMsg("Lost Game " + hangmanModel.getDisplayWord(),  this);
		}
	}
	
	private boolean playAgain(){
		
		String str;
		Character c;
		
		while(true){
			str = consoleView.getInputString("Would you like to play again? Enter [Y/N]" , this);
			str = str.trim();
			str = str.toUpperCase();
			c = str.charAt(0);
			if (c == 'Y'){
				hangmanModel.setExitGameCondition(false);
				canvas.reset();
				return(true);
			}
			if (c =='N'){
				hangmanModel.setExitGameCondition(true);
				return(false);
			}
			consoleView.printMsg("Invalid Entry", this);
		}
	}
	
	public void run() {
		
		System.out.println("hello world");
		initializeGame();	
		
		
		while (!hangmanModel.getExitGameCondition()){
			
			while (hangmanModel.getContinueGame()){
				if(!hangmanModel.processGuessEntry(getValidCharGuess())){
					canvas.noteIncorrectGuess();
				}
				updateDisplayStatus();
			}
			
			if(!playAgain()) break;
			
			hangmanModel.resetGame();
			updateDisplayStatus();
		
		}
		System.out.println("goodbye world");

	}
	
	
	private ConsoleView consoleView = new ConsoleView();
	private HangmanCanvas canvas;
	private HangmanModel hangmanModel = new HangmanModel();
	private SecretWord secretWord = new SecretWord();	
	

}
