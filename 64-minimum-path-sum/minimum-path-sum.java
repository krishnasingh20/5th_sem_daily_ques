class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        return minPath(grid, 0, 0, dp);
    }
    public int minPath(int[][] grid, int r, int c, int[][] dp) {
        if(r == grid.length - 1 && c == grid[0].length - 1) {
            return grid[r][c];
        }
        if(r >= grid.length || c >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if(dp[r][c] != -1) {
            return dp[r][c];
        }
        int down = minPath(grid, r+1, c, dp);
        int right = minPath(grid, r, c+1, dp);
        return dp[r][c] = Math.min(down, right) + grid[r][c];
    }
}