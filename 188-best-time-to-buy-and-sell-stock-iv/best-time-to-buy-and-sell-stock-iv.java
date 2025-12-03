class Solution {
    public int maxProfit(int k, int[] prices) {
        Integer[][][] dp = new Integer[prices.length][2][k+1];
        return profit(prices, 0, 0, k, dp);
    }
    public int profit(int[] prices, int i, int state, int k, Integer[][][] dp) {
        if(i == prices.length || k == 0) {
            return 0;
        }
        if(dp[i][state][k] != null) {
            return dp[i][state][k];
        }
        int a = 0;
        if(state == 0) {
            a = -prices[i] + profit(prices, i+1, 1, k, dp);
        }
        else {
            a = prices[i] + profit(prices, i+1, 0, k-1, dp);
        }
        int b = profit(prices, i+1, state, k, dp);
        return dp[i][state][k] = Math.max(a, b);
    }
}