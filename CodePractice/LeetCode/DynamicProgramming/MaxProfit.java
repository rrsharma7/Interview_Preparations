package LeetCode.DynamicProgramming;

public class MaxProfit {

	public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
	public static void main(String args[]) {
		MaxProfit mxp = new MaxProfit();
		int arr[] = new int[] {7,1,5,3,6,4};
		int ans = mxp.maxProfit(arr);
		System.out.println(ans);
	}
}
