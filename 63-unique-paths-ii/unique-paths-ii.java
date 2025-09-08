class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        return uniquePath(obstacleGrid, 0, 0, m, n, dp);
    }
    public int uniquePath(int[][] grid, int cr, int cc, int m, int n, int[][] dp) {
        if(cr >= m || cc >= n || grid[cr][cc] == 1) {
            return 0;
        }
        if(cr == m-1 && cc == n-1) {
            return 1;
        }
        if(dp[cr][cc] != -1) {
            return dp[cr][cc];
        }
        int count = 0;
        count += uniquePath(grid, cr+1, cc, m, n, dp);//for down
        count += uniquePath(grid, cr, cc+1, m, n, dp);//for right
        return dp[cr][cc] = count;
    }
}