package Model;

public class SecretWord {
	
	public SecretWord(){
		secretWord = null;
	}
	
	public boolean setSecretWord(String inputWord){
		
		secretWord = this.cleanInput(inputWord);
		if (this.validWord(this.secretWord)){
			if (this.validWord(inputWord)){
				secretWord = inputWord;
				return (true);
				}
			}
			return(false);
		}
		
	public String getSecretWord(){
		return(secretWord);
	}
	
	public boolean validWord(String inputWord){
		
		// validate that the string entered is not null and is greater than 0 characters long 
		if (inputWord != null && inputWord.length() > 0){
			return (true);
		}
		
		return (false);
	}
	
	
	
	public boolean compareToSecretWord(String testWord){
		
		int test = secretWord.compareTo(testWord);
		
		if (test !=0 ){
			return(false);
		} 
		return(true);
	}
	
	public boolean containsLetter(Character inputLetter){
		
		if (secretWord.contains(inputLetter.toString())){
			return(true);
		}
		return (false);
	}
	
	private String cleanInput (String inputString){
		
		inputString = inputString.trim();
		inputString = inputString.toUpperCase();
		return (inputString);
	}
	
	
	private String secretWord;
	
	
}