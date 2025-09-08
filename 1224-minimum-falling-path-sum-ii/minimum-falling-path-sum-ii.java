class Solution {
    public int minFallingPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid.length];
        for(int[] d: dp) {
            Arrays.fill(d, -1000000);
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < grid.length; i++) {
            ans = Math.min(ans, minFallingPath(grid, 0, i, dp));
        }
        return ans;
    }
    public int minFallingPath(int[][] grid, int r, int c, int[][] dp) {
        if(r == grid.length - 1) {
            return grid[r][c];
        }
        if(dp[r][c] != -1000000) {
            return dp[r][c];
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < grid.length; i++) {
            if(i != c) {
                ans = Math.min(ans, minFallingPath(grid, r+1, i, dp));
            }
        }
        return dp[r][c] = ans+grid[r][c];
    }
}