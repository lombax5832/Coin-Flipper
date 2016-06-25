package lombax.flip;

public class CoinFlipper{
	
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
		while(successful<Constants.ATTEMPTS){
			
			counter = 0;
			
			// Runs as long as we have less than the amount we're looking for
			while(counter<Constants.SAME_IN_A_ROW){
				if(coin.flip()){
					counter++;
					heads++;
				}else{
					counter = 0;
					tails++;
				}
				total++;
			}
			
			if(counter==Constants.SAME_IN_A_ROW){
				successful++;
				if((successful%10000)==0){
					System.out.println(Constants.ATTEMPTS-successful+" successful tries remaining.");
				}
			}
		}
		
		endTime=System.currentTimeMillis();
		//Print out information to the user
		System.out.println(1.0*(endTime-startTime)/1000.0 + " seconds to process " + total + " coin flips.");
		System.out.println("Heads:Tails ("+heads+':'+tails+") ratio = " + 1.0*heads/tails);
		System.out.println(1.0*total/Constants.ATTEMPTS);
	}

}
