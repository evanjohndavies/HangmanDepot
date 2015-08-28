package hangmanJunitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Model.SecretWord;

public class SecretWordTest {
	
	@Before
	public void setUp(){
		testWord.setSecretWord(testString);
	}
	
	@After
	public void tearDown(){
		
	}


	@Test
	public void testSetSecretWord() {
		assertTrue("Test valid parameter pass", testWord.setSecretWord(testString));
		assertTrue(testWord.getSecretWord().equals(testString));
		
		assertTrue("test lower to upper",testWord.setSecretWord("test"));
		assertTrue(testWord.getSecretWord().equals("TEST"));

		assertTrue("test leading spaces",testWord.setSecretWord(" test"));
		assertTrue(testWord.getSecretWord().equals("TEST"));
		
		assertTrue(testWord.setSecretWord("test "));
		assertTrue(testWord.getSecretWord().equals("TEST"));
		
		assertTrue(testWord.setSecretWord("TeSt"));
		assertTrue(testWord.getSecretWord().equals("TEST"));	
		
		assertFalse(testWord.setSecretWord("test test"));
		assertNull("Test Null Return", testWord.getSecretWord());

		assertFalse(testWord.setSecretWord("test-test"));
		assertNull("Test Null Return", testWord.getSecretWord());
		
		assertFalse(testWord.setSecretWord("te(escape)test"));
		assertNull("Test Null Return", testWord.getSecretWord());
		
		assertFalse(testWord.setSecretWord("&test"));
		assertNull("Test Null Return", testWord.getSecretWord());
		
		assertFalse(testWord.setSecretWord("test2test"));
		assertNull("Test Null Return", testWord.getSecretWord());		
	}

	@Test
	public void testGetSecretWord() {
		assertTrue(testWord.getSecretWord().equals(testString));
	}

	@Test
	public void testValidWord() {
		assertTrue("standard valid word",testWord.validWord("test"));
		assertTrue("leading space",testWord.validWord(" test"));
		assertTrue("trailing space ",testWord.validWord("test "));
		assertTrue("Mixed case",testWord.validWord("TesT"));
		assertFalse("Multiple words", testWord.validWord("test test"));
		assertFalse("Hyphen in word", testWord.validWord("test-test"));
		assertFalse("Parentheses in word", testWord.validWord("te(escape)"));
		assertFalse("& in word",testWord.validWord("&test"));
		assertFalse("Number in word",testWord.validWord("tes2t"));
		assertFalse("^ in word", testWord.validWord("tes^t"));
		assertFalse("$ in word",testWord.validWord("tes$t"));
		assertFalse(" | Bar in word",testWord.validWord("tes!t"));
		assertFalse(" * in word", testWord.validWord("tes*t"));
	}

	@Test
	public void testCompareToSecretWord() {
		assertTrue(testWord.getSecretWord().equals(testString));
		assertTrue("Get secret work and validate using compare secret word",testWord.compareToSecretWord(testWord.getSecretWord()));
		assertFalse("Validate faiures", testWord.compareToSecretWord("FailTest"));
		assertFalse("Validate display to secret failure", testWord.compareToSecretWord(testWord.getDisplayWord()));	
	}

	@Test
	public void testContainsLetter() {
		assertTrue("test true for letter in word",testWord.containsLetter('V'));
		assertFalse("Test false for lowercase letter in word",testWord.containsLetter('v'));
		assertTrue("test true for letter in word",testWord.containsLetter('L'));
		assertTrue("test true for letter in word",testWord.containsLetter('E'));
		assertFalse("test true for letter not in word",testWord.containsLetter('P'));
	}

	@Test
	public void testGetDisplayWord() {
		
		String displayTest = "--------";
		assertArrayEquals(displayTest.toCharArray(), testWord.getDisplayWord().toCharArray());
	}

	private SecretWord testWord = new SecretWord();
	String testString = "VALIDATE";
	
}
