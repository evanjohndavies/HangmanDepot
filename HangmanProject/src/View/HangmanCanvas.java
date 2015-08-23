package View;


import java.util.ArrayList;

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
	 * I don't need to do this and could refer to it with the 'this.' nomenclature
	 * Thought here was to prep this for having potentially multiple canvases to 
	 * work with in the future.  but alas this may all not be necessary depending
	 * on the final implementation.  For building the acual hangman I use the this.
	 * just as another way to do the reference.
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
			
		xOffset = ((canvasWidth/2) - (scaffoldWidth/2));
		yOffset = ((canvasHeight/2) - (scaffoldHeight/2));
		
		canvas.add(scaffold,xOffset,yOffset);
		
		buildMan();
		/* Calculate offset to Scaffold and add object. Each element
		*  of the hangman will not be visible. will set visbile with each 
		*	wrong guess
		*/
		xOffset += (BASE_WIDTH/3+ (BEAM_LENGTH - UPPER_ARM_LENGTH));
		yOffset = ((canvasHeight/2) - (scaffoldHeight/2) + ROPE_LENGTH);
		this.add(hangmanDisplay,xOffset,yOffset);
		
		
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
		
		hangmanArray.add(head);
		hangmanArray.add(body);		
		hangmanArray.add(leftArm);
		hangmanArray.add(rightArm);
		hangmanArray.add(leftLeg);
		hangmanArray.add(rightLeg);
		hangmanArray.add(leftFoot);
		hangmanArray.add(rightFoot);
		
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

private ArrayList<GObject> hangmanArray = new ArrayList<GObject>();
private GCompound hangmanDisplay = new GCompound();


private GOval head = new GOval((2*HEAD_RADIUS), (2*HEAD_RADIUS));
private GLine body = new GLine(0,0,0,BODY_LENGTH);
private GCompound leftArm = new GCompound();
private GCompound rightArm = new GCompound();
private GCompound leftLeg = new GCompound();
private GLine leftFoot = new GLine(0,0,FOOT_LENGTH,0);
private GCompound rightLeg = new GCompound();
private GLine rightFoot = new GLine(0,0,FOOT_LENGTH,0);





}