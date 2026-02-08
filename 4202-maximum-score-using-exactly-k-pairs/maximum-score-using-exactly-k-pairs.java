class Solution {
    static final long INF = -(long)1e18;
    public long maxScore(int[] nums1, int[] nums2, int k) {
        return bottomUp(nums1, nums2, k);
    }
    public long bottomUp(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        long[][][] dp = new long[n+1][m+1][k+1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dp[i][j][0] = 0;
            }
        }
        for(int j = 0; j <= m; j++) {
            for(int k1 = 1; k1 <= k; k1++) {
                dp[n][j][k1] = INF;
            }
        }
        for(int i = 0; i <= n; i++) {
            for(int k1 = 1; k1 <= k; k1++) {
                dp[i][m][k1] = INF;
            }
        }
        for(int i = n-1; i >= 0; i--) {
            for(int j = m-1; j >= 0; j--) {
                for(int k1 = 1; k1 <= k; k1++) {
                    long next = dp[i+1][j+1][k1-1];
                    if(next != INF) {
                        next += (long)nums1[i]*nums2[j];
                    }
                    long a = dp[i+1][j][k1];
                    long b = dp[i][j+1][k1];
                    dp[i][j][k1] = Math.max(next, Math.max(a, b));
                }
            }
        }
        return dp[0][0][k];
    }
}