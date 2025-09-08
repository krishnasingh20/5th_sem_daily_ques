class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        return uniquePath(0, 0, m, n, dp);
    }
    public int uniquePath(int cr, int cc, int m, int n, int[][] dp) {
        if(cr == m-1 && cc == n-1) {
            return 1;
        }
        if(cr >= m || cc >= n) {
            return 0;
        }
        if(dp[cr][cc] != -1) {
            return dp[cr][cc];
        }
        int count = 0;
        count += uniquePath(cr+1, cc, m, n, dp);
        count += uniquePath(cr, cc+1, m, n, dp);
        return dp[cr][cc] = count;
    }
}