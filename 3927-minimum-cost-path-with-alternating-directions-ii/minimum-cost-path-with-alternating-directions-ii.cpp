class Solution {
public:
    int m;
    int n;
    long long minCost(int _m, int _n, vector<vector<int>>& waitCost) {
        m = _m;
        n = _n;

        vector<vector<long long>> dp(m, vector<long long>(n, -1));

        return minCost1(0, 0, waitCost, dp);
    }

    long long minCost1(int r, int c, vector<vector<int>>& waitCost, vector<vector<long long>>& dp) {
        if(r == m-1 && c == n-1) {
            return m*n;
        }

        if(dp[r][c] != -1) {
            return dp[r][c];
        }

        long long ans = LONG_MAX;

        if(r+1 < m) {
            long long curr = (r+1)*(c+1) + minCost1(r+1, c, waitCost, dp);
            if(r != 0 || c != 0) {
                curr += waitCost[r][c];
            }

            ans = min(curr, ans);
        }

        if(c+1 < n) {
            long long curr = (r+1)*(c+1) + minCost1(r, c+1, waitCost, dp);
            if(r != 0 || c != 0) {
                curr += waitCost[r][c];
            }

            ans = min(ans, curr);
        }

        return dp[r][c] = ans;
    }
};