class Solution {
    public int uniquePaths(int m, int n) {
        // int[][] dp = new int[m][n];
        // for(int[] d: dp) {
        //     Arrays.fill(d, -1);
        // }
        // return topDown(m, n, 0, 0, dp);
        return bottomUp(m, n);
    }
    public int topDown(int m, int n, int r, int c, int[][] dp) {
        if(r == m - 1 && c == n - 1) {
            return 1;
        }
        if(r >= m || c >= n) {
            return 0;
        }
        if(dp[r][c] != -1) {
            return dp[r][c];
        }
        int down = topDown(m, n, r+1, c, dp);
        int right = topDown(m, n, r, c+1, dp);
        return dp[r][c] = down + right;
    }
    public int bottomUp(int m, int n) {
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = 1;//base case
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int down = i+1 == m?0:dp[i+1][j];
                int right = j+1 == n?0:dp[i][j+1];
                dp[i][j] = dp[i][j] + down + right;
            }
        }
        return dp[0][0];
    }
}