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
	
	
	public void openBufferedReader(String fileName){
		
		File f = new File(fileName);
		
		
		
		try {
			
			
			if (f.exists() && !f.isDirectory()){
				System.out.println("file exists again " + f.getName());
				
			}
				
			
			
			System.out.println("before open file reader" + fileName);
			fileReader = new FileReader(fileName);
			
			System.out.println("before open buffer reader" + fileName);

			bufferReader = new BufferedReader(fileReader);
			
			
			System.out.println("after open buffer reader");
		} 
		catch (FileNotFoundException ex){
			System.out.println("can't open file: " +fileName);
			ex.printStackTrace();
		}
		
		catch (IOException e){
			System.out.println("error reading file: " + fileName);
			e.printStackTrace();
			
		} finally{
			try{
				if (bufferReader!=null) bufferReader.close();
			} catch (IOException ex){
				ex.printStackTrace();
			}
		}
		
	}
	
	public void readLexiconList(){
		
		String line = null;
		
		try{
			System.out.println("before reading inputs from lex");
			while((line = bufferReader.readLine()) != null){
				System.out.println("in reading lex file");
				line = line.trim();
				line = line.toUpperCase();
				lexiconList.add(line);
				System.out.println(line);
			}
			
			bufferReader.close();
		}
		catch (IOException ex){
			System.out.println("can read buffer");
		}
		
	}
	
	
	public String getRandomWord (){
		
		int randomNumber = 0;
		
		randomNumber = randomObject.nextInt(lexiconList.size());
		return(lexiconList.get(randomNumber));
		
	}
	
	   
	   
	private	Random randomObject;
	private BufferedReader bufferReader = null;
	private FileReader fileReader = null;
	private ArrayList<String> lexiconList;
	

	
	
}
