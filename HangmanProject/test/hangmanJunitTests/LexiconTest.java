package hangmanJunitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Model.Lexicon;

public class LexiconTest {
	
	@Before
	public void setUp(){
		testLex = new Lexicon();
		pathName = "/Users/evandavies/git/HangmanDepot/HangmanProject/bin/";
		fileName = "lex.txt";
		
	}
	
	@After
	public void tearDown(){
		
	}


	@Test
	public void testCheckFileExists() {
		assertTrue("Test file exists from String Valiable", testLex.checkFileExists(fileName));
		fileName= "testlex.txt";
		assertTrue("Test file exists for testing", testLex.checkFileExists(fileName));
		assertFalse("Test file not exists", testLex.checkFileExists("InvalidFile"));
	}

	@Test
	public void testOpenAndReadBufferedReader() {
		
		testLex.openAndReadBufferedReader(fileName);
		assertNotNull("test reading lex",testLex.getRandomWord());
		fileName= "testlex.txt";
		testLex.openAndReadBufferedReader(fileName);
		assertNotNull("test reading lex",testLex.getRandomWord());
	}

	@Test
	public void testGetRandomWord() {
		
		testLex.openAndReadBufferedReader(fileName);
		assertNotNull("test reading lex",testLex.getRandomWord());
		fileName= "testlex.txt";
		testLex.openAndReadBufferedReader(fileName);
		assertNotNull("test reading lex",testLex.getRandomWord());		
	}
	
	Lexicon testLex;
	String fileName;
	String pathName;

}
