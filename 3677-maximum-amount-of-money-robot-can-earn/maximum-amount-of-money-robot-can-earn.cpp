class Solution {
public:
    int maximumAmount(vector<vector<int>>& coins) {
        
        vector<vector<vector<int>>> dp(coins.size(), vector<vector<int>>(coins[0].size(), vector<int>(3, -1)));

        // return maxProfit(coins, 0, 0, 2, dp);

        return bottomUp(coins);
    }

    int maxProfit(vector<vector<int>>& coins, int r, int c, int k, vector<vector<vector<int>>>& dp) {
        if(r == coins.size()-1 && c == coins[0].size()-1) {
            if(coins[r][c] < 0 && k > 0) {
                return 0;
            }
            return coins[r][c];
        }

        if(dp[r][c][k] != -1) {
            return dp[r][c][k];
        }

        int ans = INT_MIN;

        if(r+1 < coins.size()) {
            int down = coins[r][c] + maxProfit(coins, r+1, c, k, dp);
            ans = max(ans, down);

            if(coins[r][c] < 0 && k > 0) {
                down = maxProfit(coins, r+1, c, k-1, dp);
                ans = max(ans, down);
            }
        }

        if(c+1 < coins[0].size()) {
            int right = coins[r][c] + maxProfit(coins, r, c+1, k, dp);
            ans = max(ans, right);

            if(coins[r][c] < 0 && k > 0) {
                right = maxProfit(coins, r, c+1, k-1, dp);
                ans = max(ans, right);
            }
        }

        return dp[r][c][k] = ans;
    }

    int bottomUp(vector<vector<int>>& coins) {
        int m = coins.size();
        int n = coins[0].size();

        vector<vector<vector<int>>> dp(coins.size(), vector<vector<int>>(coins[0].size(), vector<int>(3)));

        dp[m-1][n-1][0] = coins[m-1][n-1];
        dp[m-1][n-1][1] = coins[m-1][n-1];
        dp[m-1][n-1][2] = coins[m-1][n-1];

        if(coins[m-1][n-1] < 0) {
            dp[m-1][n-1][1] = 0;
            dp[m-1][n-1][2] = 0;
        }

        for(int i = m-1; i >= 0; i--) {
            for(int j = n-1; j >= 0; j--) {
                if(i == m-1 && j == n-1) {
                    continue;
                }
                for(int k = 0; k <= 2; k++) {
                    int ans = INT_MIN;

                    if(i+1 < m) {
                        int down = coins[i][j] + dp[i+1][j][k];
                        ans = max(ans, down);
                        if(coins[i][j] < 0 && k > 0) {
                            down = dp[i+1][j][k-1];
                            ans = max(ans, down);
                        }
                    }

                    if(j+1 < n) {
                        int right = coins[i][j] + dp[i][j+1][k];
                        ans = max(ans, right);
                        
                        if(coins[i][j] < 0 && k > 0) {
                            right = dp[i][j+1][k-1];
                            ans = max(ans, right);
                        }
                    }

                    dp[i][j][k] = ans;
                }
            }
        }

        return dp[0][0][2];
    }
};