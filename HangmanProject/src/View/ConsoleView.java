package View;


import Control.HangmanController;

public class ConsoleView {
	
	public ConsoleView(){
		
		inputString = null;
	}
	
	
	public String getInputString (String textString, HangmanController console ){
		
		return(inputString=console.readLine(textString + "\n"));
	}
	
	
	public void printMsg(String str, HangmanController console){
		
		console.println(str+"\n");
	}

	
	public String getLastInput(){
		
		return(inputString);
	}
	
	
	private String inputString;
}
