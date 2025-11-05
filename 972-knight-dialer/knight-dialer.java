class Solution {
    static int[] row = {-2, -2, 2, 2, -1, -1, 1, 1};
    static int[] col = {-1, 1, -1, 1, -2, 2, -2, 2};
    public int knightDialer(int n) {
        int[][][] dp = new int[4][3][n+1];
        for(int[][] dp1: dp) {
            for(int[] d: dp1) {
                Arrays.fill(d, -1);
            }
        }
        char[][] grid = {{'1', '2', '3'},{'4', '5', '6'},{'7', '8', '9'}, {'*', '0', '#'}};
        int ans = 0;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 3; j++) {
                if(grid[i][j] != '*' && grid[i][j] != '#') {
                    ans = (ans + Dialer(grid, i, j, n-1, dp)) % 1000000007;
                }
            }
        }
        return ans;
    }
    public int Dialer(char[][] grid, int r, int c, int n, int[][][] dp) {
        if(r < 0 || c < 0 || r >= 4 || c >= 3 || grid[r][c] == '*' || grid[r][c] == '#') {
            return 0;
        }
        if(n == 0) {
            return 1;
        }
        if(dp[r][c][n] != -1) {
            return dp[r][c][n];
        }
        int ans = 0;
        for(int i = 0; i < 8; i++) {
            ans = (ans + Dialer(grid, r+row[i], c+col[i], n-1, dp)) % 1000000007;
        }
        return dp[r][c][n] = ans % 1000000007;
    }
}