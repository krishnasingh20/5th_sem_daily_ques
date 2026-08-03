class Solution {
    int[] dp;
    public String stoneGameIII(int[] stoneValue) {

        int stoneA = bottomUp(stoneValue);

        int totalSum = 0;
        for(int s: stoneValue) {
            totalSum += s;
        }

        if(stoneA == totalSum - stoneA) {
            return "Tie";
        }

        return stoneA > (totalSum - stoneA) ? "Alice" : "Bob";
    }

    public int bottomUp(int[] stone) {
        int n = stone.length;
        dp = new int[n];

        for(int i = n-1; i >= 0; i--) {
            int a = stone[i] + Math.min((i+2 < n ? dp[i+2] : 0), Math.min((i+3 < n ? dp[i+3] : 0), (i+4 < n ? dp[i+4] : 0)));

            int b = Integer.MIN_VALUE;
            int c = Integer.MIN_VALUE;

            if(i+1 < n) {
                b = stone[i] + stone[i+1] + Math.min((i+3 < n ? dp[i+3] : 0), Math.min((i+4 < n ? dp[i+4] : 0), (i+5 < n ? dp[i+5] : 0)));
            }

            if(i+2 < n) {
                c = stone[i] + stone[i+1] + stone[i+2] + Math.min((i+4 < n ? dp[i+4] : 0), Math.min((i+5 < n ? dp[i+5] : 0), (i+6 < n ? dp[i+6] : 0)));
            }

            dp[i] = Math.max(a, Math.max(b, c));
        }

        return dp[0];
    }
}