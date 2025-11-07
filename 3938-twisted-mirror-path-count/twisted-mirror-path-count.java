class Solution {
    public int uniquePaths(int[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][2];
        for(int[][] d: dp) {
            for(int[] a: d) {
                Arrays.fill(a, -1);
            }
        }
        return uniquePath(grid, 0, 0, 0, dp) % 1000000007;
    }
    // right -> 0, down-> 1
    public int uniquePath(int[][] grid, int r, int c, int prev, int[][][] dp) {
        if(r == grid.length - 1 && c == grid[0].length - 1) {
            return 1;
        }
        if(r >= grid.length || c >= grid[0].length) {
            return 0;
        }
        if(dp[r][c][prev] != -1) {
            return dp[r][c][prev];
        }
        int ans = 0;
        if(grid[r][c] == 1) {
            if(prev == 1) {
                int right = uniquePath(grid, r, c+1, 0, dp);
                ans = right;
            }
            else {
                int down = uniquePath(grid, r+1, c, 1, dp);
                ans = down;
            }
        }
        else {
            int down = uniquePath(grid, r+1, c, 1, dp) % 1000000007;
            int right = uniquePath(grid, r, c+1, 0, dp) % 1000000007;
            ans = down + right;
        }
        return dp[r][c][prev] = ans % 1000000007;
    }
}