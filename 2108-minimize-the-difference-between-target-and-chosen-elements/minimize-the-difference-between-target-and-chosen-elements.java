class Solution {
    Integer[][] dp;
    public int minimizeTheDifference(int[][] mat, int target) {
        int sum = 0;
        for(int i = 0; i < mat.length; i++) {
            int max = 0;
            for(int j = 0; j < mat[0].length; j++) {
                max = Math.max(max, mat[i][j]);
            }
            sum += max;
        }
        dp = new Integer[mat.length][sum+1];
        return minDiff(mat, 0, 0, target);
    }
    public int minDiff(int[][] mat, int r, int sum, int target) {
        if(r == mat.length) {
            return Math.abs(sum-target);
        }
        if(dp[r][sum] != null) {
            return dp[r][sum];
        }
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i < mat[0].length; i++) {
            int min = minDiff(mat, r+1, sum+mat[r][i], target);
            diff = Math.min(min, diff);
            if(min == 0) {
                break;
            }
        }
        return dp[r][sum] = diff;
    }
}