package Model;


public class SecretWord extends Lexicon{
	
	public SecretWord(){
		secretWord = null;
		displayWord = null;
	}
	
	public boolean setSecretWord(String inputWord){
		
		inputWord = cleanInput(inputWord);

		if (validWord(inputWord)){
			secretWord = inputWord;
			displayWord = inputWord.replaceAll("[A-Z]", "-");
			return (true);
			}
			secretWord = null;
			displayWord = null;
			return(false);
		}
		
	public String getSecretWord(){
		return(secretWord);
	}
	
	public static boolean validWord(String inputWord){
		
		char[]  testCharArray;
		Character ch;
		String testString;
		
		
		testString = cleanInput(inputWord);
		
		// validate that the string entered is not null and is greater than 0 characters long 
		if (inputWord != null && inputWord.length() > 0){

			testCharArray = testString.toCharArray();
			System.out.println("Word = " + inputWord);
			for (char c: testCharArray){
				ch = (Character) c;
				if (!Character.isLetter(ch)){
					System.out.println("Invalid Word" + inputWord);
					return(false);
				}
			}
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
			displayWord = replaceTokenWithLetter(secretWord, displayWord, inputLetter);
			return(true);
		}	
		return (false);
	}
	
	
	public String getDisplayWord(){
		
		return(displayWord);
	}
	
	private String replaceTokenWithLetter(String inputStr, String displayStr, Character letter){
		
		char[] newDisplayCharArray = displayStr.toCharArray(); 
		
		for (int i=0; i< inputStr.length() ;i++){
				if(letter.equals(secretWord.charAt(i))){
					newDisplayCharArray[i] = letter;
				}
		}
		return(String.valueOf(newDisplayCharArray));
	}
	
	
	private static String cleanInput (String inputString){
		
		inputString = inputString.trim();
		inputString = inputString.toUpperCase();
		return (inputString);
	}
	
	
	private String secretWord;
	private String displayWord;
	
}