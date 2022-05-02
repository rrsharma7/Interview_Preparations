package LeetCode.DynamicProgramming;

import java.util.Arrays;

public class CoinChange {

	public int coinChange(int[] coins, int amount) {
		int max = amount + 1;
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, max);
		dp[0] = 0;
		for(int coin :coins)
        {
            for(int i=coin;i<=amount;i++)
            dp[i]=Math.min(dp[i],dp[i-coin]+1);
        }
		return dp[amount] > amount ? -1 : dp[amount];
	}

	public static void main(String args[]) {
		CoinChange cc = new CoinChange();
		int arr[] = new int[] { 1, 2, 5 };
		int ans = cc.coinChange(arr, 11);
		System.out.println(ans);
	}
}
