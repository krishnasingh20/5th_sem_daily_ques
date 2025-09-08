class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int[] d:dp) {
            Arrays.fill(d, -10000000);
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < matrix.length; i++) {
            ans = Math.min(ans, minFallingPath(matrix, 0, i, dp));
        }
        return ans;
    }
    public int minFallingPath(int[][] matrix, int r, int c, int[][] dp) {
        if(c < 0 || c >= matrix[0].length) {
            return Integer.MAX_VALUE;
        }
        if(r == matrix.length - 1) {
            return matrix[r][c];
        }
        if(dp[r][c] != -10000000) {
            return dp[r][c];
        }
        int leftdiagonal = minFallingPath(matrix, r+1, c-1, dp);
        int rightdiagonal = minFallingPath(matrix, r+1, c+1, dp);
        int down = minFallingPath(matrix, r+1, c, dp);
        return dp[r][c] = Math.min(leftdiagonal, Math.min(rightdiagonal, down))+matrix[r][c];
    }
}