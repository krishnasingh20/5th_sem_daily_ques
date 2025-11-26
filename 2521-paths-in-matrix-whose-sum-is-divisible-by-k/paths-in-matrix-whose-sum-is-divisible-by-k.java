class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int[][][] dp = new int[grid.length][grid[0].length][k];
        for(int[][] d: dp) {
            for(int[] a: d) {
                Arrays.fill(a, -1);
            }
        }
        return path(grid, 0, 0, 0, k, dp);
    }
    public int path(int[][] grid, int i, int j, int rem, int k, int[][][] dp) {
        if(i == grid.length - 1 && j == grid[0].length - 1) {
            rem = (rem + (grid[i][j] % k)) % k;
            if(rem == 0) {
                return 1;
            }
            return 0;
        }
        if(i >= grid.length || j >= grid[0].length) {
            return 0;
        }
        rem = (rem + (grid[i][j] % k)) % k;
        if(dp[i][j][rem] != -1) {
            return dp[i][j][rem];
        }
        int down = path(grid, i+1, j, rem, k, dp) % 1000000007;
        int right = path(grid, i, j+1, rem, k, dp) % 1000000007;
        return dp[i][j][rem] = (down + right) % 1000000007;
    }
}