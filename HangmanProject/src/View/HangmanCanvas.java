package View;


/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */
import acm.graphics.*;


	public class HangmanCanvas extends GCanvas {
		/** Resets the display so that only the scaffold appears */ 

	
		
	public void reset() {
      /* You fill this in */
   }
	
	/*This method builds the scaffold for the game.  passed to the method is the 
	 * object itself from the calling class that defined it.  In this context
	 * I don't need to do this and could refer to it with the this. nomenclature
	 * Though here was to prep this for having potentially multiple canvases to 
	 * work with in the future.  but alas this may all not be necessary depending
	 * on the final implementation.
	 */
	
	public void buildScaffold(HangmanCanvas canvas){
		
		GCompound scaffold = new GCompound();
		GLine pole = new GLine(0, 0, 0, SCAFFOLD_HEIGHT);
		GLine beam = new GLine(0,0,BEAM_LENGTH, 0);
		GLine rope = new GLine(0,0,0,ROPE_LENGTH);
		GRect base = new GRect(BASE_WIDTH, BASE_HEIGHT);
		int offset = BASE_WIDTH/3;
		int canvasHeight;
		int canvasWidth;
		double scaffoldHeight;
		double scaffoldWidth;
		double xOffset;
		double yOffset;
		
		// set everything to visible //
		scaffold.setVisible(true);
		beam.setVisible(true);
		rope.setVisible(true);;
		pole.setVisible(true);
		base.setVisible(true);
		
		// calculate layout of scaffold in GCompound
		
		scaffold.add(beam,offset,0);
		scaffold.add(pole,offset,0);
		scaffold.add(rope,offset+BEAM_LENGTH,0);
		scaffold.add(base,0,SCAFFOLD_HEIGHT);
		
		
		canvasWidth=canvas.getWidth();
		canvasHeight = canvas.getHeight();
		scaffoldHeight = SCAFFOLD_HEIGHT + BASE_HEIGHT;
		scaffoldWidth = BASE_WIDTH;
		
		System.out.println("canvas width " +canvasWidth); 
		System.out.println("canvas height " + canvasHeight);
		System.out.println("saffold width " + scaffoldWidth);
		System.out.println("scaffold height" + scaffoldHeight);
		
		xOffset = ((canvasWidth/2) - (scaffoldWidth/2));
		yOffset = ((canvasHeight/2) - (scaffoldHeight/2));
		
		
		canvas.add(scaffold,xOffset,yOffset);
	
		
	}
	
	/**
	 * Updates the word on the screen to correspond to the current
	 * state of the game. The argument string shows what letters have
	 * been guessed so far; unguessed letters are indicated by hyphens. */
   public void displayWord(String word) {
      /* You fill this in */
	   
	   
   }
   
   
   
   
   /**
    * Updates the display to correspond to an incorrect guess by the
    * user. Calling this method causes the next body part to appear
    * on the scaffold and adds the letter to the list of incorrect
    * guesses that appears at the bottom of the window. */
   public void noteIncorrectGuess(char letter) { 
	

	}
   
   
   
// Constants for the simple version of the picture (in pixels)
private static final int SCAFFOLD_HEIGHT = 360; 
private static final int BASE_WIDTH = 250;
private static final int BASE_HEIGHT = 50;
private static final int BEAM_LENGTH = 144; 
private static final int ROPE_LENGTH = 18; 
private static final int HEAD_RADIUS = 36; 
private static final int BODY_LENGTH = 144; 
private static final int ARM_OFFSET_FROM_HEAD = 28;
private static final int UPPER_ARM_LENGTH = 72; 
private static final int LOWER_ARM_LENGTH = 44; 
private static final int HIP_WIDTH = 36; 
private static final int LEG_LENGTH = 108; 
private static final int FOOT_LENGTH = 28;

}