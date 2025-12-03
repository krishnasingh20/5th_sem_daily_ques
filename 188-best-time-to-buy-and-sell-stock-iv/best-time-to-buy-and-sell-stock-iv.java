class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][k+1];
        for(int i = n - 1; i >= 0; i--) {
            for(int j = 1; j <= k; j++) {
                // state - 0
                int a = -prices[i] + dp[i+1][1][j];
                int b = dp[i+1][0][j];
                dp[i][0][j] = Math.max(a, b);
                // state - 1
                a = prices[i] + dp[i+1][0][j-1];
                b = dp[i+1][1][j];
                dp[i][1][j] = Math.max(a, b);
            }
        }
        return dp[0][0][k];
    }
}