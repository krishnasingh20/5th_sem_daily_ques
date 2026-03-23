#define ll long long

class Solution {
public:
    int n;
    int m;
    int maxProductPath(vector<vector<int>>& grid) {
        m = grid.size();
        n = grid[0].size();

        vector<vector<vector<ll>>> dp(m, vector<vector<ll>>(n, vector<ll>((m+n+1), -1)));

        ll ans = maxPro(grid, 0, 0, 0, dp) % 1000000007;

        return ans < 0?-1:(int)ans;
    }

    ll maxPro(vector<vector<int>>& grid, int r, int c, int neg, vector<vector<vector<ll>>>& dp) {
        if(r == m-1 && c == n-1) {
            return grid[r][c];
        }

        if(dp[r][c][neg] != -1) {
            return dp[r][c][neg];
        }

        int newNeg = ((grid[r][c] < 0)?1:0) + neg;

        ll ans = 0;

        if(r+1 < m && c+1 < n) {

            ll down = grid[r][c] * maxPro(grid, r+1, c, newNeg, dp);
            ll right = grid[r][c] * maxPro(grid, r, c+1, newNeg, dp);

            if((neg & 1) == 1) {
                if(down < 0 && right >= 0) {
                    ans = down;
                }
                else if(down >= 0 && right < 0) {
                    ans = right;
                }
                else {
                    ans = min(down, right);
                }
            }
            else {
                if(down < 0 && right >= 0) {
                    ans = right;
                }
                else if(down >= 0 && right < 0) {
                    ans = down;
                }
                else {
                    ans = max(down, right);
                }
            }
        }
        else if(r+1 < m) {
            ans = grid[r][c] * maxPro(grid, r+1, c, newNeg, dp);
        }
        else {
            ans = grid[r][c] * maxPro(grid, r, c+1, newNeg, dp);
        }

        return dp[r][c][neg] = ans;
    }
};