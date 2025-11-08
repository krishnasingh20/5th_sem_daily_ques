class Solution {
    static int[] row = {-2,-2,-1,1,2,2,-1,1};
    static int[] col = {-1,1,2,2,-1,1,-2,-2};
    public double knightProbability(int n, int k, int r, int c) {
        double[][][] dp = new double[n][n][k+1];
        for(double[][] d: dp) {
            for(double[] a: d) {
                Arrays.fill(a, -1.0);
            }
        }
        return knightProb(n, k, r, c, dp);
    }
    public double knightProb(int n, int k, int r, int c, double[][][] dp) {
        if(k == 0) {
            if(r >= 0 && r < n && c >= 0 && c < n) {
                return 1.0;
            }
            return 0.0;
        }
        if(r < 0 || c < 0 || r >= n || c >= n) {
            return 0.0;
        }
        if(dp[r][c][k] != -1.0) {
            return dp[r][c][k];
        }
        double count = 0.0;
        for(int i = 0; i < 8; i++) {
            count += knightProb(n, k-1, r+row[i], c+col[i], dp);
        }
        return dp[r][c][k] = count/8.0;
    }
}