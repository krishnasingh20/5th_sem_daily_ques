class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < grid[0].length; i++) {
            ans = Math.min(ans, minPath(grid, 0, i, moveCost, dp));
        }
        return ans;
    }
    public int minPath(int[][] grid, int r, int c, int[][] moveCost, int[][] dp) {
        if(r == grid.length - 1) {
            return grid[r][c];
        }
        if(dp[r][c] != -1) {
            return dp[r][c];
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < grid[0].length; i++) {
            ans = Math.min(ans, minPath(grid, r+1, i, moveCost, dp) +moveCost[grid[r][c]][i]);
        }
        // dp[r][c] = ans;
        return dp[r][c] = ans + grid[r][c];
    }
}