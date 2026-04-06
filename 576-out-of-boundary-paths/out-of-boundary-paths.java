class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Long[][][] dp = new Long[m][n][maxMove+1];
        return (int)(path(m, n, maxMove, startRow, startColumn, dp) % 1000000007);
    }
    public long path(int m, int n, int maxMove, int r, int c, Long[][][] dp) {
        if(r < 0 || c < 0 || r >= m || c >= n) {
            return 1;
        }
        if(maxMove == 0) {
            return 0;
        }
        if(dp[r][c][maxMove] != null) {
            return dp[r][c][maxMove];
        }
        long down = path(m, n,  maxMove - 1, r+1, c, dp) % 1000000007;
        long up = path(m, n, maxMove - 1, r-1, c, dp) % 1000000007;
        long left = path(m, n, maxMove - 1, r, c-1, dp) % 1000000007;
        long right = path(m, n, maxMove - 1, r, c+1, dp) % 1000000007;
        return dp[r][c][maxMove] = (down + up + left + right) % 1000000007;
    }
}