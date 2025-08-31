class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp, -1);
        int zeroth = climb(cost, 0, dp);
        int oneth = climb(cost, 1, dp);
        return Math.min(zeroth, oneth);
    }
    public int climb(int[] cost, int i, int[] dp) {
        if(i >= cost.length) {
            return 0;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        int onestep = climb(cost, i+1, dp);
        int twostep = climb(cost, i+2, dp);
        return dp[i] = Math.min(onestep, twostep)+cost[i];
    }
}