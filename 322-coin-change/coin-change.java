class Solution {
    public int coinChange(int[] coins, int amount) {
        long[][] dp = new long[coins.length][amount+1];
        for(long[] d: dp) {
            Arrays.fill(d, -1);
        }
        long ans = coin(coins, amount, 0, dp);
        if(ans == Integer.MAX_VALUE) {
            return -1;
        }
        return (int)ans;
    }
    public long coin(int[] coins, int amount, int i, long[][] dp) {
        if(amount == 0) {
            return 0;
        }
        if(i == coins.length || amount < 0) {
            return Integer.MAX_VALUE;
        }
        if(dp[i][amount] != -1) {
            return dp[i][amount];
        }
        long inc = 1 + coin(coins, amount - coins[i], i, dp);
        long exc = coin(coins, amount, i+1, dp);
        return dp[i][amount] = Math.min(inc, exc);
    }
}