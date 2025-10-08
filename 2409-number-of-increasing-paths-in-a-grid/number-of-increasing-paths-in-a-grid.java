class Solution {
    static int mod = 1000000007;
    public int countPaths(int[][] grid) {
        int ans = 0;
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                ans = (ans+path(grid, i, j, 0, dp)) % mod;
            }
        }
        return ans;
    }
    public int path(int[][] grid, int r, int c, int curr, int[][] dp) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == -1 || grid[r][c] <= curr) {
            return 0;
        }
        if(dp[r][c] != -1) {
            return dp[r][c];
        }
        int ans = 0;
        ans += (path(grid, r+1, c, grid[r][c], dp)) ;
        ans += (path(grid, r-1, c, grid[r][c], dp)) ;
        ans += (path(grid, r, c+1, grid[r][c], dp)) ;
        ans += (path(grid, r, c-1, grid[r][c], dp)) ;
        return dp[r][c] = (ans+1) % mod;
    }
}