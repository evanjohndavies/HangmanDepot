/**
 * 
 */
package Model;

/**
 * @author evandavies
 *
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Random;


public class Lexicon {
	
	public Lexicon(){
		
		// hardcoded shit that will need to create better implementation 
		pathName = "/Users/evandavies/git/HangmanDepot/HangmanProject/bin/";
		//System.out.println(System.getProperty("user.dir"));
	}
	
	public boolean checkFileExists(String fileName){
		
		File f = new File( pathName+fileName);
		return(f.exists() && !f.isDirectory());
	}
	
	
	public void openAndReadBufferedReader(String fileName){
		
		String line = null;		
		try {
			
			fileReader = new FileReader(pathName+fileName);
			bufferReader = new BufferedReader(fileReader);
			
			while((line = bufferReader.readLine()) != null) {
				line = line.trim();
				line = line.toUpperCase();
				if (SecretWord.validWord(line)){
					lexiconList.add(line);
				}
			}


		} 
		catch (FileNotFoundException ex){
			System.out.println("can't open file: " +fileName);
			ex.printStackTrace();
		}
		
		catch (IOException e){
			System.out.println("error reading file: " + fileName);
			e.printStackTrace();
			
		}
		finally {
			try {
				if (bufferReader != null){
					bufferReader.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	
	
	public String getRandomWord (){
		
		int randomNumber = 0;
		
		randomNumber = randomObject.nextInt(lexiconList.size());
		return(lexiconList.get(randomNumber));
		
	}
	   
	   
	private	Random randomObject = new Random();
	private BufferedReader bufferReader = null;
	private FileReader fileReader = null;
	private ArrayList<String> lexiconList = new ArrayList<String>();
	String pathName;
}
