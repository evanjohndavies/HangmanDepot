package hangmanJunitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Model.HangmanModel;
import Model.Lexicon;

public class HangmanModelTest {
	
	
	@Before
	public void setUp(){
		testModel = new HangmanModel();
		fileName = "lex.txt";
		
	}
	
	@After
	public void tearDown(){
		
	}
	

	@Test
	public void testOpenLexicon() {
		
		assertTrue(testModel.openLexicon(fileName));

	}

	@Test
	public void testResetGame() {
	}

	@Test
	public void testGetWordToGuess() {
	}

	@Test
	public void testGetValidInput() {
	}

	@Test
	public void testProcessGuessEntry() {
	}

	@Test
	public void testGetLettersEntered() {
	}

	@Test
	public void testGetDisplayWord() {
	}

	@Test
	public void testWonGame() {
	}

	@Test
	public void testLostGame() {
	}

	@Test
	public void testGetGuessCount() {
	}

	@Test
	public void testGetContinueGame() {
	}

	@Test
	public void testGetExitGameCondition() {
	}

	@Test
	public void testSetExitGameCondition() {
	}

	HangmanModel testModel;
	String fileName;
	
}
