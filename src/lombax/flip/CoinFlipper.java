package lombax.flip;

public class CoinFlipper{

	public static final int ATTEMPTS = 1000000;
	public static final int SAME_IN_A_ROW = 9;
	
	public static void main(String[] args) {
		int successful = 0;
		long total = 0;
		long startTime = 0;
		long endTime = 0;
		long heads = 0;
		long tails = 0;
		short counter = 0;
		
		FlipCoin coin = new FlipCoin();
		startTime=System.currentTimeMillis();
		while(successful<ATTEMPTS){
			
			counter = 0;
			
			// Runs as long as we have less than the amount we're looking for
			while(counter<SAME_IN_A_ROW){
				if(coin.flip()){
					counter++;
					heads++;
				}else{
					counter = 0;
					tails++;
				}
				total++;
			}
			
			if(counter==SAME_IN_A_ROW){
				successful++;
				if((successful%10000)==0){
					System.out.println(ATTEMPTS-successful+" successful tries remaining.");
				}
			}
		}
		
		endTime=System.currentTimeMillis();
		System.out.println(1.0*(endTime-startTime)/1000.0 + " seconds to process " + total + " coin flips.");
		System.out.println("Heads:Tails ("+heads+':'+tails+") ratio = " + 1.0*heads/tails);
		System.out.println(1.0*total/ATTEMPTS);
	}

}
