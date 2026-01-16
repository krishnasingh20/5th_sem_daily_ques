class Solution {
    Integer[][][] dp;
    static int mod = 1000000007;
    public int countHousePlacements(int n) {
        dp = new Integer[n][2][2];
        return count(n, 0, 0, 0);
    }
    public int count(int n, int i, int state1, int state2) {
        if(i == n) {
            return 1;
        }
        if(dp[i][state1][state2] != null) {
            return dp[i][state1][state2];
        }
        int ans = 0;
        if(state1 == 0 && state2 == 0) {
            int a = count(n, i+1, 1, 1);
            ans = (ans + a)%mod;
        }
        if(state1 == 0) {
            int a = count(n, i+1, 1, 0);
            ans = (ans + a)%mod;
        }
        if(state2 == 0) {
            int a = count(n, i+1, 0, 1);
            ans = (ans + a) % mod;
        }
        int skip = count(n, i+1, 0, 0);
        return  dp[i][state1][state2] = (ans+skip)%mod;
    }
}