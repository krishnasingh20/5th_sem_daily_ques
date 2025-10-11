class Solution {
    static int mod = 1000000007;
    public int numWays(int steps, int arrLen) {
        long[][] dp = new long[501][steps+1];
        for(long[] d: dp) {
            Arrays.fill(d, -1);
        }
        return (int)(numWay(steps, 0, 0, arrLen, dp) % mod);
    }
    public long numWay(int steps, int currStep, int i, int arrLen, long[][] dp) {
        if(currStep == steps) {
            if(i == 0) {
                return 1;
            }
            return 0;
        }
        if(i < 0 || i >= arrLen) {
            return 0;
        }
        if(dp[i][currStep] != -1) {
            return dp[i][currStep];
        }
        long stay = numWay(steps, currStep+1, i, arrLen, dp);
        long left = numWay(steps, currStep+1, i-1, arrLen, dp);
        long right = numWay(steps, currStep+1, i+1, arrLen, dp);
        return dp[i][currStep] = (stay+left+right) % mod;
    }
}