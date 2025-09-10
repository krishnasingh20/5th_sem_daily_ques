class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        long[][] dp = new long[n+1][target+1];
        for(long[] d: dp) {
            Arrays.fill(d, -1);
        }
        return (int)(solve(0, 0, target, n, k, dp) % 1000000007);
    }
    public long solve(int curr, int sum, int target, int n, int k, long[][] dp) {
        if(curr == n) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }
        if(dp[curr][sum] != -1) {
            return dp[curr][sum];
        }
        long count = 0;
        for(int i = 1; i <= k; i++) {
            if(sum+i <= target) {
                count =(count +  solve(curr+1, sum + i, target, n, k, dp)) % 1000000007;
            }
        }
        return dp[curr][sum] = count;
    }
}