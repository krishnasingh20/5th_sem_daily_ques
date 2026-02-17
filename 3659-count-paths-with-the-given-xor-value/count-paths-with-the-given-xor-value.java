class Solution {
    static final int mod = 1000000007;
    public int countPathsWithXorValue(int[][] grid, int k) {
        dp = new int[grid.length][grid[0].length][32];
        for(int[][] d: dp) {
            for(int[] a: d) {
                Arrays.fill(a, -1);
            }
        }
        return count(grid, 0, 0, k);
    }
    int[][][] dp;
    private int count(int[][] grid, int i, int j, int k) {
        if(i == grid.length-1 && j == grid[0].length-1) {
            if((k^grid[i][j]) == 0) {
                return 1;
            }
            return 0;
        }
        if(dp[i][j][k] != -1) {
            return dp[i][j][k];
        }
        int ans = 0;
        if(i+1 < grid.length) {
            ans = (ans + count(grid, i+1, j, (k^grid[i][j]))) % mod;
        }
        if(j+1 < grid[0].length) {
            ans = (ans + count(grid, i, j+1, (k^grid[i][j]))) % mod;
        }
        return dp[i][j][k] = ans;
    }
}