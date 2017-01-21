/* 
 * @author Marek Slabicki
 * @version 1.0
 */
package Classes;

/**
 * The Class Demo: Run this to see two player (computer) play crazy eights.
 */
public class Demo {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
    	System.out.println("===================================");
        System.out.println("Welcome to Crazy Eights!");
        System.out.println("===================================\n");
        
        try{
        	Game crazyEight = new Game();
        	crazyEight.playGame();
        }
        catch(Exception e){
        	System.out.println(e.toString());
        }
	}

}
