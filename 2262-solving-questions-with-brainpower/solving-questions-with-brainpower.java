class Solution {
    public long mostPoints(int[][] questions) {
        // long[] dp = new long[questions.length];
        // Arrays.fill(dp, -1);
        // return maxPoint(questions, 0, dp);
        return bottomUp(questions);
    }
    // recursive approach
    public long maxPoint(int[][] questions, int i, long[] dp) {
        if(i >= questions.length) {
            return 0;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        long a = questions[i][0] + maxPoint(questions, i+questions[i][1]+1, dp);
        long b = maxPoint(questions, i+1, dp);
        return dp[i] = Math.max(a, b);
    }
    // iterative approach
    public long bottomUp(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n+1];
        dp[n] = 0;
        for(int i = n - 1; i >= 0; i--) {
            long max = 0;
            if(i+questions[i][1]+1<=n) {
                max= dp[i+questions[i][1]+1];
            }
            dp[i] = Math.max(questions[i][0]+max, dp[i+1]);
        }
        return dp[0];
    }
}