class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        Arrays.fill(dp, -1);
        return maxPoint(questions, 0, dp);
    }
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
}