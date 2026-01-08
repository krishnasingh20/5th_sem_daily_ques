class Solution {
    static int mod = 1000000007;
    Integer[][][] dp;
    public int countHousePlacements(int n) {
        dp = new Integer[n][2][2];
        return ways(0, n, 0, 0);
    }
    public int ways(int i, int n, int state1, int state2) {
        if(i == n) {
            return 1;
        }
        if(dp[i][state1][state2] != null) {
            return dp[i][state1][state2];
        }
        int ans = 0;
        if(state1 == 0 && state2 == 0) {
            ans = (ans + ways(i+1, n, 1, 1))%mod;
        }
        if(state1 == 0) {
            ans = (ans + ways(i+1, n, 1, 0))%mod;
        }
        if(state2 == 0) {
            ans = (ans + ways(i+1, n, 0, 1))%mod;
        }
        ans = (ans + ways(i+1, n, 0, 0))%mod;
        return dp[i][state1][state2] = ans;
    }
}