class Solution {
public:
    int mod = 1000000007;
    int countSpecialSubsequences(vector<int>& arr) {
        vector<vector<int>> dp(arr.size(), vector<int>(4, -1));
        return countSpecial(arr, 0, -1, dp);
    }
    
    int countSpecial(vector<int>& arr, int i, int state, vector<vector<int>>& dp) {
        if(i == arr.size()) {
            if(state == 2) {
                return 1;
            }
            return 0;
        }

        if(dp[i][state+1] != -1) {
            return dp[i][state+1];
        }

        int ans = 0;
        
        if(state == -1 && arr[i] == 0) {
            ans = (ans + countSpecial(arr, i+1, -1, dp)) % mod;
            ans = (ans + countSpecial(arr, i+1, 0, dp)) % mod;
        }
        else if(state == 0 && arr[i] == 1) {
            ans = (ans + countSpecial(arr, i+1, 0, dp)) % mod;
            ans = (ans + countSpecial(arr, i+1, 1, dp)) % mod;
        }
        else if(state == 1 && arr[i] == 2) {
            ans = (ans + countSpecial(arr, i+1, 1, dp)) % mod;
            ans = (ans + countSpecial(arr, i+1, 2, dp)) % mod;
        }

        int skip = countSpecial(arr, i+1, state, dp) % mod;

        return dp[i][state+1] = (ans + skip) % mod;
    }
};