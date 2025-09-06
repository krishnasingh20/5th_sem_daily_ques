class Solution {
    public int change(int amount, int[] coins) {
        // int[][] dp = new int[amount+1][coins.length];
        // for(int i = 0; i < dp.length; i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        // top down approach
        // return coin_change(coins, amount, 0, dp);
        // bottom up approach 
        return coin_changeBU(coins, amount);
    }
    // topdown approach 
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
    // bottom up approach 
    public int coin_changeBU(int[] coins, int amount) {
        int[][] dp = new int[amount + 1][coins.length + 1];
        Arrays.fill(dp[0], 1);
        for(int am = 1; am < dp.length; am++) {
            for(int i = 1; i < dp[0].length; i++) {
                int inc = 0;
                int exc = 0;
                if(am >= coins[i-1]) {
                    inc = dp[am-coins[i-1]][i];
                    exc = dp[am][i-1];
                }
                else {
                    exc = dp[am][i-1];
                }
                dp[am][i] = inc+exc;
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}