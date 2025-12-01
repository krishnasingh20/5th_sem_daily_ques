class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        Arrays.fill(dp, -1);
        return profit(prices, 0, 0, dp);
    }
    public int profit(int[] prices, int i, int j, int[] dp) {
        if(i == prices.length) {
            return 0;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        int a = 0;
        if(prices[i] >= prices[j]) {
            a = prices[i] - prices[j];
        }
        a += profit(prices, i+1, i, dp);
        int b = profit(prices, i+1, j, dp);
        return dp[i] = Math.max(a, b);
    }
}