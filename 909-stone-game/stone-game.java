class Solution {
    static int[][] dp;
    public boolean stoneGame(int[] piles) {

        int totalSum = Arrays.stream(piles).sum();
        
        int stoneA = bottomUp(piles);

        return stoneA > totalSum - stoneA;
    }

    public int bottomUp(int[] piles) {
        int n = piles.length;
        dp = new int[n][n];

        for(int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }

        for(int i = n - 1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                if(i == j) {
                    continue;
                }
                int a = piles[i] + Math.min((i+2 < n ? dp[i+2][j] : 0), (i+1 < n && j-1 >= 0 ? dp[i+1][j-1] : 0));
                int b = piles[j] + Math.min((i+1 < n && j-1 >= 0 ? dp[i+1][j-1] : 0), (j-2 >= 0 ? dp[i][j-2] : 0));

                dp[i][j] = Math.max(a, b);
            }
        }

        return dp[0][n-1];
    }
}