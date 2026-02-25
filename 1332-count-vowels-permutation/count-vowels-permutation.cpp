class Solution {
public:
    inline static const int MOD = 1000000007;
    int countVowelPermutation(int n) {
        vector<vector<int>> dp(n+1, vector<int> (6, -1));
        return count(n, -1, dp);
    }
    int count(int n, int prev, vector<vector<int>>& dp) {
        if(n == 0) {
            return 1;
        }
        if(dp[n][prev+1] != -1) {
            return dp[n][prev+1];
        }
        int ans = 0;
        for(int i = 0; i < 5; i++) {
            if(i == 0) {
                if(prev == -1 || prev == 1) {
                    ans = (ans + count(n-1, i, dp)) % MOD;
                }
            }
            else if(i == 1) {
                if(prev == -1 || prev == 0 || prev == 2) {
                    ans = (ans + count(n-1, i, dp)) % MOD;
                }
            }
            else if(i == 2) {
                if(prev != i) {
                    ans = (ans + count(n-1, i, dp)) % MOD;
                }
            }
            else if(i == 3) {
                if(prev == -1 || prev == 2 || prev == 4) {
                    ans = (ans + count(n-1, i, dp)) % MOD;
                }
            }
            else {
                if(prev == -1 || prev == 0) {
                    ans = (ans + count(n-1, i, dp)) % MOD;
                }
            }
        }
        return dp[n][prev+1] = ans;
    }
};