class Solution {
    int[] prefix;
    int n;
    int[][][] dp;
    public int stoneGameII(int[] piles) {
        n = piles.length;
        prefix = new int[n];
        prefix[0] = piles[0];

        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] + piles[i];
        }

        dp = new int[2][n][n+1];

        for(int[][] d: dp) {
            for(int[] a: d) {
                Arrays.fill(a, -1);
            }
        }

        return maxStone(0, 0, 1);
    }

    public int maxStone(int i, int turn, int M) {
        if(i == n) {
            return 0;
        }

        if(dp[turn][i][M] != -1) {
            return dp[turn][i][M];
        }

        int limit = Math.min(n - i, 2*M);
        if(turn == 0) {
            int ans = Integer.MIN_VALUE;
            for(int X = 1; X <= limit; X++) {
                int newM = Math.max(M, X);
                int curr = (prefix[i+X-1] - (i == 0 ? 0 : prefix[i-1])) + maxStone(i+X, 1, newM);
                ans = Math.max(ans, curr);
            }
            return dp[turn][i][M] = ans;
        }
        else {
            int ans = Integer.MAX_VALUE;
            for(int X = 1; X <= limit; X++) {
                int newM = Math.max(M, X);
                int curr = maxStone(i+X, 0, newM);
                ans = Math.min(ans, curr);
            }
            return dp[turn][i][M] = ans;
        }
    }
}