package View;


import java.awt.Font;
import java.util.*;



/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */
import acm.graphics.*;


	public class HangmanCanvas extends GCanvas {
		/** Resets the display so that only the scaffold appears */ 

		
	public void reset() {

		
		for (Iterator<GObject> i =  hangmanArray.iterator(); i.hasNext();){
			i.next().setVisible(false);
		}

		hangmanArrayIndex = 0;
   }
	
	
	
	/**
		    * Updates the display to correspond to an incorrect guess by the
		    * user. Calling this method causes the next body part to appear
		    * on the scaffold and adds the letter to the list of incorrect
		    * guesses that appears at the bottom of the window. */
	public void noteIncorrectGuess(char letter) { 
			   	  	  
			  hangmanArray.get(hangmanArrayIndex++).setVisible(true);
			
			}

	/**
		 * Updates the word on the screen to correspond to the current
		 * state of the game. The argument string shows what letters have
		 * been guessed so far; unguessed letters are indicated by hyphens. */
	public void displayUpdate(String word, ArrayList<Character> letters) {
		   displayWord.setLabel(word);
		   displayLetters.setLabel(letters.toString());
		
	   }
	   
	   
	   
	 /* This method builds the scaffold and hangman pieces for the game.  passed to the method is the 
	 * object itself from the calling class that defined it.  In this context
	 * I don't need to do this and could refer to it with the 'this.' nomenclature
	 * Thought here was to prep this for having potentially multiple canvases to 
	 * work with in the future.  but alas this may all not be necessary depending
	 * on the final implementation.  For building the acual hangman I use the this.
	 * just as another way to do the reference.
	 */
	public void buildUIComponenents(HangmanCanvas canvas){
		
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
		displayWord.setVisible(true);
		displayLetters.setVisible(true);	
		// calculate layout of scaffold in GCompound
		
		scaffold.add(beam,offset,0);
		scaffold.add(pole,offset,0);
		scaffold.add(rope,offset+BEAM_LENGTH,0);
		scaffold.add(base,0,SCAFFOLD_HEIGHT);
				
		canvasWidth= canvas.getWidth();
		canvasHeight = canvas.getHeight();
		scaffoldHeight = SCAFFOLD_HEIGHT + BASE_HEIGHT;
		scaffoldWidth = BASE_WIDTH;
			
		xOffset = (canvasWidth - scaffoldWidth)/2;
		System.out.println("X = " + xOffset);
		
		yOffset = (canvasHeight - scaffoldHeight)/2;
		System.out.println("Y = " + yOffset);

		
		this.add(scaffold,xOffset,yOffset);
		
		// Add Display Fields for Word and Letters Guessed
		
		System.out.println("X = " + xOffset);
		System.out.println("SCAFFOLD_HEIGHT = " + SCAFFOLD_HEIGHT);
		System.out.println("BASE_HEIGHT = " + BASE_HEIGHT);
		System.out.println("BASE_WIDTH = " + BASE_WIDTH);
		System.out.println("canvasWidth = " + canvasWidth);
		System.out.println("canvasHeight = " + canvasHeight);
		System.out.println("scaffold.getHeight() = " + scaffold.getHeight());
		System.out.println("scaffold.getWidth() = " + scaffold.getWidth());
		System.out.println("scaffold.getX = " + scaffold.getX());
		System.out.println("scaffold.getY = " + scaffold.getY());
		System.out.println("scaffoldWidth = " + scaffoldWidth);
		System.out.println("scaffoldHeight = " + scaffoldHeight);
		System.out.println("displayLetters.getHeight() = " + displayLetters.getHeight());
		System.out.println("displayLetters.getWidth() = " + displayLetters.getWidth());
		
	
		
		// build and add hangman components 
		buildMan();
		/* Calculate offset to Scaffold and add object. Each element
		*  of the hangman will not be visible. will set visible with each 
		*	wrong guess
		*/
		xOffset += (BASE_WIDTH/3+ (BEAM_LENGTH - UPPER_ARM_LENGTH));
		yOffset = ((canvasHeight/2) - (scaffoldHeight/2) + ROPE_LENGTH);
		
		canvas.add(hangmanDisplay,xOffset,yOffset);
		
		
		displayWord.setFont(new Font("Courier New", Font.BOLD, 18));
		xOffset = scaffold.getX() + CHAR_INDENT;
		yOffset = scaffold.getY() + SCAFFOLD_HEIGHT + (BASE_HEIGHT/2) + displayWord.getHeight()/2;
		
		System.out.println("Y = " + yOffset);
		
		canvas.add(displayWord, xOffset, yOffset);
		
		yOffset += BASE_HEIGHT;
		canvas.add(displayLetters, xOffset, yOffset);	
		
		

		
		
		


		
		
		
		
		
	}
	
	
	private void drawArms(){
		
		leftArm.add(new GLine(0,0,UPPER_ARM_LENGTH,0));		
		leftArm.add( new GLine(0,0,0,LOWER_ARM_LENGTH));
		
		rightArm.add(new GLine(0,0,UPPER_ARM_LENGTH,0));
		rightArm.add( new GLine(UPPER_ARM_LENGTH,0,UPPER_ARM_LENGTH,LOWER_ARM_LENGTH));		
	}
	
	
	private void drawLegs(){

		leftLeg.add(new GLine(0,0,(.5 * HIP_WIDTH),0));
		leftLeg.add(new GLine(0,0,0,LEG_LENGTH));
		
		rightLeg.add(new GLine(0,0,(.5 * HIP_WIDTH),0));
		rightLeg.add(new GLine((.5 * HIP_WIDTH),0,(.5 * HIP_WIDTH),LEG_LENGTH));
	}
	
	
	
	private void buildMan(){
		
		int yOffset = 0;
		int xOffset = 0;
		drawArms();
		drawLegs();
		
		/*
		 * As noted above, using the 'this.' form instead of passing the reference
		 * into the method.  This works as well just using alternative
		 * approach
		 */
		
		xOffset = UPPER_ARM_LENGTH - HEAD_RADIUS;
		hangmanDisplay.add(head,xOffset, 0);
		
		xOffset = UPPER_ARM_LENGTH;
		yOffset = 2*HEAD_RADIUS;
		hangmanDisplay.add (body,xOffset, yOffset);		

		xOffset = 0;
		yOffset+= ARM_OFFSET_FROM_HEAD;
		hangmanDisplay.add(leftArm,xOffset,yOffset);
		
		xOffset = UPPER_ARM_LENGTH;
		hangmanDisplay.add(rightArm, xOffset, yOffset);
		
		xOffset = (int) (UPPER_ARM_LENGTH - (.5 * HIP_WIDTH));
		yOffset+= BODY_LENGTH-ARM_OFFSET_FROM_HEAD;
		hangmanDisplay.add(leftLeg, xOffset, yOffset);
		
		xOffset = UPPER_ARM_LENGTH;
		hangmanDisplay.add(rightLeg, xOffset, yOffset);
		
		xOffset =(int) (UPPER_ARM_LENGTH - (FOOT_LENGTH + (.5* HIP_WIDTH)));
		yOffset+= LEG_LENGTH;
		hangmanDisplay.add(leftFoot, xOffset, yOffset);
		
		xOffset = (int) (UPPER_ARM_LENGTH + (.5 * HIP_WIDTH));
		hangmanDisplay.add(rightFoot, xOffset, yOffset);		
		
		hangmanArray.add(head);
		hangmanArray.add(body);		
		hangmanArray.add(leftArm);
		hangmanArray.add(rightArm);
		hangmanArray.add(leftLeg);
		hangmanArray.add(rightLeg);
		hangmanArray.add(leftFoot);
		hangmanArray.add(rightFoot);
		
		hangmanDisplay.setVisible(true);
		
		for (Iterator<GObject> i =  hangmanArray.iterator(); i.hasNext();){
			i.next().setVisible(false);
		}
				
	}
	
	
	
	
	// Constants for the simple version of the picture (in pixels)
private static final int SCAFFOLD_HEIGHT = 360; 
private static final int BASE_WIDTH = 250;
private static final int BASE_HEIGHT = 45;
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
private static final int CHAR_INDENT = 20;

private ArrayList<GObject> hangmanArray = new ArrayList<GObject>();
private int hangmanArrayIndex = 0;
private GCompound hangmanDisplay = new GCompound();

private GCompound scaffold = new GCompound();
private GLine pole = new GLine(0, 0, 0, SCAFFOLD_HEIGHT);
private GLine beam = new GLine(0,0,BEAM_LENGTH, 0);
private GLine rope = new GLine(0,0,0,ROPE_LENGTH);
private GRect base = new GRect(BASE_WIDTH, BASE_HEIGHT);
private GOval head = new GOval((2*HEAD_RADIUS), (2*HEAD_RADIUS));
private GLine body = new GLine(0,0,0,BODY_LENGTH);
private GCompound leftArm = new GCompound();
private GCompound rightArm = new GCompound();
private GCompound leftLeg = new GCompound();
private GLine leftFoot = new GLine(0,0,FOOT_LENGTH,0);
private GCompound rightLeg = new GCompound();
private GLine rightFoot = new GLine(0,0,FOOT_LENGTH,0);
private GLabel displayWord = new GLabel("Bite me");
private GLabel  displayLetters = new GLabel("Bite me too");


}