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
	
	
	
	public boolean checkFileExists(String fileName){
		
	File f = new File(fileName);
	return(f.exists() && !f.isDirectory());
	}
	
	
	public void openAndReadBufferedReader(String fileName){
		
		String line = null;
		
		System.out.println("open and read buffer");
		try {
			
			fileReader = new FileReader(fileName);
			bufferReader = new BufferedReader(fileReader);
			
			while((line = bufferReader.readLine()) != null) {
	            System.out.println(line);
				line = line.trim();
				line = line.toUpperCase();
				lexiconList.add(line);
				System.out.println(line);
			}
			bufferReader.close();

		} 
		catch (FileNotFoundException ex){
			System.out.println("can't open file: " +fileName);
			ex.printStackTrace();
		}
		
		catch (IOException e){
			System.out.println("error reading file: " + fileName);
			e.printStackTrace();
			
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
	

	
	
}
