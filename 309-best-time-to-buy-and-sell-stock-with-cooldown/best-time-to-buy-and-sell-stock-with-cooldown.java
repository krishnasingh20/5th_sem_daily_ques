class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        return profit(prices, 0, 0, dp);
    }
    public int profit(int[] prices, int i, int state, int[][] dp) {
        if(i >= prices.length) {
            return 0;
        }
        if(dp[i][state] != -1) {
            return dp[i][state];
        }
        int a;
        if(state == 0) {
            a = -prices[i] + profit(prices, i+1, 1, dp);
        }
        else {
            a = prices[i] + profit(prices, i+2, 0, dp);
        }
        int b = profit(prices, i+1, state, dp);
        return dp[i][state] = Math.max(a, b);
    }
}