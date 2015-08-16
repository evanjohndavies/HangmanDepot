package View;


import Control.HangmanController;

public class ConsoleView {
	
	
	
	public String getInputString (String textString, HangmanController console ){
		
		return(console.readLine(textString + "\n"));
	
	}
	
	
	public void printMsg(String str, HangmanController console){
		console.println(str+"\n");
	}
	
}
