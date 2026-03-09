class Solution {
    public int minCost(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return cost(n);
    }
    int[] dp;
    private int cost(int n) {
        if(n <= 2) {
            return n-1;
        }
        if(dp[n] != -1) {
            return dp[n];
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= n/2; i++) {
            int curr = (i*(n-i)) + cost(i) + cost(n-i);
            ans = Math.min(ans, curr);
        }
        return dp[n] = ans;
    }
}