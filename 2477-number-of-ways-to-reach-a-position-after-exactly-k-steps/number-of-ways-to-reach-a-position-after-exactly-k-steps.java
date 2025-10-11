class Solution {
    int mod = 1000000007;
    public int numberOfWays(int startPos, int endPos, int k) {
        long[][] dp = new long[3001][k+1];
        for(long[] d: dp) {
            Arrays.fill(d, -1);
        }
        return (int)(numWays(startPos, startPos, endPos, k, 0, dp) % mod);
    }
    public long numWays(int currPos, int startPos, int endPos, int k, int currStep, long[][] dp) {
        if(currStep == k) {
            if(currPos == endPos) {
                return 1;
            }
            return 0;
        }
        // adding 1000 to avoid index out of bound in case of negative position because it is a infinite number line
        if(dp[currPos+1000][currStep] != -1) {
            return dp[currPos+1000][currStep];
        }
        long left = numWays(currPos - 1, startPos, endPos, k, currStep + 1, dp) % mod;
        long right = numWays(currPos + 1, startPos, endPos, k, currStep + 1, dp) % mod;
        return dp[currPos+1000][currStep] = (left + right) % mod;
    }
}