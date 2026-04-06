class Solution {

    static final int MOD = 1000000007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {

        dp = new Integer[m][n][maxMove+1];

        return path(startRow, startColumn, m, n, maxMove);
    }

    Integer[][][] dp;

    private int path(int r, int c, int m, int n, int maxMove) {
        if(r < 0 || c < 0 || r >= m || c >= n) {
            return 1;
        }

        if(dp[r][c][maxMove] != null) {
            return dp[r][c][maxMove];
        }

        int ans = 0;

        if(maxMove > 0) {
            ans = (ans + path(r+1, c, m, n, maxMove-1)) % MOD;//down direction
            ans = (ans + path(r-1, c, m, n, maxMove-1)) % MOD;//up direction
            ans = (ans + path(r, c-1, m, n, maxMove-1)) % MOD;//left direction
            ans = (ans + path(r, c+1, m, n, maxMove-1)) % MOD;//right direction
        }

        return dp[r][c][maxMove] = ans;
    }
}