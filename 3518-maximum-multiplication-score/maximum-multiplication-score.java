class Solution {
    long[][] dp;
    public long maxScore(int[] a, int[] b) {
        dp = new long[4][b.length];
        for(long[] d: dp) {
            Arrays.fill(d, Long.MIN_VALUE);
        }
        return score(a, b, 0, 0);
    }
    public long score(int[] a, int[] b, int i, int j) {
        if(i == 4) {
            return 0;
        }
        if(j == b.length) {
            return Long.MIN_VALUE;
        }
        if(dp[i][j] != Long.MIN_VALUE) {
            return dp[i][j];
        }
        long a1 = score(a, b, i+1, j+1);
        if(a1 != Long.MIN_VALUE) {
            a1 = a1 + (long)a[i]*b[j];
        }
        long b1 = score(a, b, i, j+1);
        return dp[i][j] = Math.max(a1, b1);
    }
}