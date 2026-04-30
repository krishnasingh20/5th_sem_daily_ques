class Solution {
public:
    int m;
    int n;
    int maxPathScore(vector<vector<int>>& grid, int k) {

        m = grid.size();
        n = grid[0].size();
        vector<vector<vector<int>>> dp(
            m, vector<vector<int>>(n, vector<int>(k + 1, -1)));

        int score = maxScore(grid, 0, 0, k, dp);

        return score < 0 ? -1 : score;
    }

    int maxScore(vector<vector<int>>& grid, int r, int c, int k, vector<vector<vector<int>>>& dp) {
        if (r == m - 1 && c == n - 1) {
            int cost = grid[r][c] ? 1 : 0;
            if (k - cost < 0) {
                return INT_MIN;
            }
            return grid[r][c];
        }

        if (k < 0) {
            return INT_MIN;
        }

        if (dp[r][c][k] != -1) {
            return dp[r][c][k];
        }

        int ans = INT_MIN;
        int cost = grid[r][c] ? 1 : 0;

        if (r + 1 < m) {
            int down = grid[r][c] + maxScore(grid, r + 1, c, k - cost, dp);
            ans = max(ans, down);
        }
        if (c + 1 < n) {
            int right = grid[r][c] + maxScore(grid, r, c + 1, k - cost, dp);
            ans = max(ans, right);
        }

        return dp[r][c][k] = ans;
    }
};