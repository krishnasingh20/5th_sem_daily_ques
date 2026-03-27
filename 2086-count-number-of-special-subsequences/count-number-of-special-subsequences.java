class Solution {
    static final int mod = 1000000007;
    public int countSpecialSubsequences(int[] nums) {
        return countSpecial(nums);
    }
    // state->0 means 0 in continues
    // state->1 means 1 in continues
    // state->2 means 2 in continues
    // state->3 means special subsequence formed
    private  int countSpecial(int[] arr) {
        int n = arr.length;

        int[][] dp = new int[n+1][4];

        dp[n][3] = 1;//base case

        for(int i = n-1; i >= 0; i--) {
            for(int state = 0; state <= 3; state++) {
                int ans = 0;
                if(state == 0 && arr[i] == 0) {
                    ans = (ans + dp[i+1][0]) % mod;
                    ans = (ans + dp[i+1][1]) % mod;
                }
                else if(state == 1 && arr[i] == 1) {
                    ans = (ans + dp[i+1][1]) % mod;
                    ans = (ans + dp[i+1][2]) % mod;
                }
                else if(state == 2 && arr[i] == 2) {
                    ans = (ans + dp[i+1][2]) % mod;
                    ans = (ans + dp[i+1][3]) % mod;
                }

                int skip = dp[i+1][state];

                dp[i][state] = (ans + skip) % mod;
            }
        }

        return dp[0][0];
    }
}