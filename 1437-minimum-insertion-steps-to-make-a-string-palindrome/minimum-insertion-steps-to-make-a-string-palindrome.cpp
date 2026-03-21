class Solution {
public:
    int minInsertions(string s) {
        vector<vector<int>> dp(s.length(), vector<int>(s.length(), -1));

        return minInsert(s, 0, s.length()-1, dp);
    }

    int minInsert(string &s, int i, int j, vector<vector<int>>& dp) {
        if(i >= j) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = 0;

        if(s[i] == s[j]) {
            ans = minInsert(s, i+1, j-1, dp);
        }
        else {
            int a = 1 + minInsert(s, i, j-1, dp);
            int b = 1 + minInsert(s, i+1, j, dp);
            ans = min(a, b);
        }
        
        return dp[i][j] = ans;
    }
};