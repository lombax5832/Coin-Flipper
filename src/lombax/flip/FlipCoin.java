package lombax.flip;

import java.util.Random;

/**
 * @author Alexei
 *
 * returns a random boolean value to simulate flipping a coin
 */
public class FlipCoin {
	
	private static Random rand = new Random();
	
	public FlipCoin(){}
	
	public boolean flip(){
		return rand.nextBoolean();
	}
}
