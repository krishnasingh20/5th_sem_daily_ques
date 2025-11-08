class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        char[][] grid = new char[n][n];
        for(int i = 0; i < n; i++) {
            String s = board.get(i);
            for(int j = 0; j < n; j++) {
                grid[i][j] = s.charAt(j);
            }
        }
        grid[0][0] = grid[n - 1][n - 1] = '0';
        int[][] dp1 = new int[n][n];
        for(int[] d: dp1) {
            Arrays.fill(d, -1);
        }
        int max = maxPath(grid, n - 1, n - 1, dp1);
        if(max < 0) {
            return new int[]{0, 0};
        }
        int[][][] dp2 = new int[n][n][max+1];
        for(int[][] d: dp2) {
            for(int[] a: d) {
                Arrays.fill(a, -1);
            }
        }
        int count = countPath(grid, n - 1, n - 1, max, dp2);
        return new int[]{max, count};
    }
    public int maxPath(char[][] grid, int r, int c, int[][] dp) {
        if(r == 0 && c == 0) {
            return 0;
        }
        if(r < 0 || c < 0 || grid[r][c] == 'X') {
            return Integer.MIN_VALUE;
        }
        if(dp[r][c] != -1) {
            return dp[r][c];
        }
        int val = grid[r][c] - '0';
        int up = maxPath(grid, r-1, c, dp);
        int left = maxPath(grid, r, c-1, dp);
        int up_left = maxPath(grid, r-1, c-1, dp);
        return dp[r][c] = val + Math.max(up, Math.max(left, up_left));
    }
    public int countPath(char[][] grid, int r, int c, int max, int[][][] dp) {
        if(r == 0 && c == 0) {
            if(max == 0) {
                return 1;
            }
            return 0;
        }
        if(r < 0 || c < 0 || grid[r][c] == 'X') {
            return 0;
        }
        if(dp[r][c][max] != -1) {
            return dp[r][c][max];
        }
        int val = grid[r][c] - '0';
        int up = countPath(grid, r-1, c, max - val, dp);
        int left = countPath(grid, r, c-1, max - val, dp);
        int up_left = countPath(grid, r-1, c-1, max - val, dp);
        return dp[r][c][max] = (up + left + up_left) % 1000000007;
    }
}