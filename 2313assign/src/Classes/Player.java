/* 
 * @author Marek Slabicki
 * @version 1.0
 */
package Classes;

/**
 * This class encapsulates a player in a game of crazy eights.
 */
public abstract class Player {

    /** The name of the player */
    protected String name;
    
    /** The hand: the cards held by one player. */
    protected Hand hand;
    
    /**
     * Instantiates a new player with an empty hand.
     *
     * @param name, the name of the player
     */
    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    /**
     * Gets the name.
     *
     * @return the name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the hand.
     *
     * @return the player's hand. */
    public Hand getHand() {
        return hand;
    }

    /**
     * Play: this is an abstract method and must be 
     * implemented in any derived class.
     *
     * @param crazyEight, gives access to the "draw pile".
     * @param prev, the previously played card. 
     * @return a card from the player's hand.
     */
    public abstract Card play(Game crazyEight, Card prev);

    
    /**
     * Score: calculates the player's score (penalty points).
	 * <p>
	 * Note: as soon as a player has no cards, the game ends and 
	 * all other players score penalty points for their remaining cards. 
	 * Eights are worth 20, face cards are worth 10, and all others 
	 * are worth their rank.
	 * </p>
     * @return the score
     */
    public int score() {
    	/* Your code goes here */
    	int scoreHolder = 0;
    	toString();
    	Hand handHolder = getHand();
    	for (int i = 0; i < handHolder.size(); i++){
    		Card rankFinder = handHolder.getCard(i);
    		int cantDoThisInTheIfElse = rankFinder.getRank();
    		//can't figure out why I cant do this as if(rankFinder.getRank() == 8)...
    		
    		if(cantDoThisInTheIfElse == 8){
    			scoreHolder += 20;
    		}
    		else if(cantDoThisInTheIfElse == 11 || cantDoThisInTheIfElse == 12 || cantDoThisInTheIfElse == 13){
    			scoreHolder += 10;
    		}
    		else{
    			scoreHolder += cantDoThisInTheIfElse;
    		}

    	}
    	return scoreHolder; //remove this line when you complete this method
    }

    /**
     * Display the cards in player's hand.
     */
    public void display() {
    	System.out.println(name + "'s hand:");
        System.out.println(hand);
    }

    /**
     * Display the player's name and score.
     */
    public void displayScore() {
        System.out.println(name + " has " + score() + " points");
    }

    /**
     * Card matches: two cards match if their rank or suit is the same. 
	 * <p>
	 * Note: if card1's rank is 8, it is a Wild Card.
	 * A wild card can match any other card
	 * </p>
     * @param card1, the card 1
     * @param card2, the card 2
     * @return true, if card1 matches card2
     */
    public static boolean cardMatches(Card card1, Card card2) {
    	if (card1.getRank() == 8 || card2.getRank() == 8){
    		return true;
    	}
    	else if(card1.getSuit() == card2.getSuit()){
    		return true;
    	}
    	else if(card1.getRank() == card2.getRank()){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
}

