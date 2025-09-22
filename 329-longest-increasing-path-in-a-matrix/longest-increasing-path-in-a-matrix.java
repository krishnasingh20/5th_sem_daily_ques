class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        // in these babiaclly i try to find for evry index that maximum length of decreasing path (longest increasing can be equivalent to it) and i used dp to store it so that in future when i go to that index agin the recomputed value get reassign
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        int ans = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                ans = Math.max(ans, longestIncPath(matrix, Long.MAX_VALUE, i, j, dp));
            }
        }
        return ans;
    }
    public int longestIncPath(int[][] matrix, long val, int r, int c, int[][] dp) {
        if(r < 0 || c < 0 || r >= matrix.length || c >= matrix[0].length || matrix[r][c] == -1 || val <= (long)matrix[r][c]) {
            return 0;
        }
        if(dp[r][c] != -1) {
            return dp[r][c];
        }
        int temp = matrix[r][c];
        matrix[r][c] = -1;
        // up
        int up = 1 + longestIncPath(matrix, (long)temp, r-1, c, dp);
        //down
        int down = 1 + longestIncPath(matrix, (long)temp, r+1, c, dp);
        //left
        int left = 1 + longestIncPath(matrix, (long)temp, r, c-1, dp);
        //right
        int right = 1 + longestIncPath(matrix, (long)temp, r, c+1, dp);
        matrix[r][c] = temp;
        return dp[r][c] = Math.max(Math.max(left, right), Math.max(up, down));
    }
}