class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        for(int[][] d: dp) {
            for(int[] a: d) {
                Arrays.fill(a, Integer.MIN_VALUE);
            }
        }
        return profit(prices, 0, 0, 2, dp);
    }
    public int profit(int[] prices, int i, int state, int k, int[][][] dp) {
        if(i == prices.length || k == 0) {
            return 0;
        }
        if(dp[i][state][k] != Integer.MIN_VALUE) {
            return dp[i][state][k];
        }
        int a = 0;
        if(state == 1) {
            a = prices[i] + profit(prices, i+1, 0, k-1, dp);
        }
        if(state == 0) {
            a = -prices[i] + profit(prices, i+1, 1, k, dp);
        }
        int b = profit(prices, i+1, state, k, dp);
        return dp[i][state][k] = Math.max(a, b);
    }
}