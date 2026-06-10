package dsa_question;

public class BuySellStockI {

	public static int maxProfit(int[] prices) {
		int min = prices[0]; int profit = 0;
		
		for(int i = 1; i < prices.length; i++) {
			profit = Math.max(profit, prices[i] - min);
			min = Math.min(min, prices[i]);
		}
		
		return profit;
	}
	
	public static void main(String[] args) {
		
		System.out.println(maxProfit(new int[] {7,1,3,4,5,2}));
	}
}
