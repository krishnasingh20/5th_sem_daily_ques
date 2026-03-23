class Solution {
    int m;
    int n;
    public int maxProductPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        dp = new Long[m][n][m+n+1];

        int ans = (int)(maxPro(grid, 0, 0, 0) % 1000000007);
        return ans < 0?-1:ans;
    }

    Long[][][] dp;
    private long maxPro(int[][] grid, int r, int c, int neg) {
        if(r == m-1 && c == n-1) {
            return grid[r][c];
        }

        if(dp[r][c][neg] != null) {
            return dp[r][c][neg];
        }

        int newNeg = ((grid[r][c] < 0)?1:0) + neg;
        long ans = 0;

        if(r+1 < m && c+1 < n) {
            long down = grid[r][c] * maxPro(grid, r+1, c, newNeg);
            long right = grid[r][c] * maxPro(grid, r, c+1, newNeg);
            if((neg & 1) == 1) {
                if(down < 0 && right >= 0) {
                    ans = down;
                }
                else if(down >= 0 && right < 0) {
                    ans = right;
                }
                else {
                    ans = Math.min(down, right);
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
                    ans = Math.max(down, right);
                }
            }
        }
        else if(r+1 < m) {
            long down = grid[r][c] * maxPro(grid, r+1, c, newNeg);
            ans = down;
        }
        else {
            long right = grid[r][c] * maxPro(grid, r, c+1, newNeg);
            ans = right;
        }

        return dp[r][c][neg] = ans;
    }
}