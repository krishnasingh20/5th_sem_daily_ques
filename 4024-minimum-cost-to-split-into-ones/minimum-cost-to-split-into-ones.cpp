class Solution {
public:
    int minCost(int n) {
        vector<int> dp(n+1, -1);
        return cost(n, dp);
    }
    int cost(int n, vector<int>& dp) {
        if(n <= 2) {
            return n-1;
        }
        if(dp[n] != -1) {
            return dp[n];
        }
        int ans = INT_MAX;
        for(int i = 1; i <= n/2; i++) {
            int curr = (i*(n-i)) + cost(i, dp) + cost(n-i, dp);
            ans = min(ans, curr);
        }
        return dp[n] = ans;
    }
};