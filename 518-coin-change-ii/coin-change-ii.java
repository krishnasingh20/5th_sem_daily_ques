class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount+1][coins.length];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return coin_change(coins, amount, 0, dp);
    }
    public int coin_change(int[] coins, int amount, int idx, int[][] dp) {
        if(amount == 0) {
            return 1;
        }
        if(idx == coins.length) {
            return 0;
        }
        if(dp[amount][idx] != -1) {
            return dp[amount][idx];
        }
        int inc = 0;
        int exc = 0;
        if(amount >= coins[idx]) {
            inc = coin_change(coins, amount - coins[idx], idx, dp);
        }
        exc = coin_change(coins, amount, idx+1, dp);
        return dp[amount][idx] = inc+exc;
    }
}