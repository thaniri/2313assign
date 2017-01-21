/* 
 * @author Marek Slabicki
 * @version 1.0
 */
package Classes;

import java.util.Scanner;

/**
 * This class represents a human player (user) in a game of crazy eights.
 */
public class User extends Player {
	
	/** The input. */
	private Scanner input;
	
	/**
	 * Instantiates a human player with an empty hand.
	 *
	 * @param name, the name of the player
	 */
	public User(String name){
		super(name);
		input = new Scanner(System.in);
	}

	/* This method implements play from Player class  */
    public Card play(Game crazyEight, Card prev) {
    	/* Your code goes here */
    	
    	System.out.println("Select a card from you hand \n or enter 0 to draw a new card");
    	int selection = input.nextInt() - 1;
    	//see comment below for this
    	if(cardMatches(hand.getCard(selection), prev) == true){
    		return hand.popCard(selection);
    	}
    	else{
    		drawForMatch(crazyEight, prev);
    		/*
    		 * TWO mysteries:
    		 * 
    		 * 1) Couldn't figure out a way to make 0 be the input for draw card
    		 * 0 normally selects the first card (in-game 2)
    		 * put input-1 to make 0 into in-game 1
    		 * -1 causes an out of bounds error even if i make the first if statement (if selection == -1)
    		 * picking a random number like 99 for the draw also is out of bounds for some reason
    		 * so instead I copy pasted the code from computer.java to force a move on the player
    		 * 
    		 * 2) when the player executes drawForMatch as soon as a match is found null gets played
    		 * 
    		 * the GOOD news is that you can win if you only use the first 8 cards
    		 */
    	}

    	return null; //remove this line when you complete this method
    }
    
    private Card drawForMatch(Game crazyEight, Card prev) {
        while (true) {
            Card card = crazyEight.draw();
            System.out.println("\n*** " + name + " draws " + card + "\n");
            if (cardMatches(card, prev)) {
            	hand.addCard(card);
            }
            return hand.popCard();
        }
    }
    

}
