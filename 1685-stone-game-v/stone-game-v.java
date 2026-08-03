class Solution {
    int[] prefix;
    int[][] dp;
    public int stoneGameV(int[] stone) {
        int n = stone.length;
        prefix = new int[n];
        prefix[0] = stone[0];

        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] + stone[i];
        }

        dp = new int[n][n];

        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }

        return maxScore(stone, 0, n-1);
    }
    public int maxScore(int[] stone, int i, int j) {
        if(i == j) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = Integer.MIN_VALUE;

        for(int k = i; k < j; k++) {
            int a = prefix[k] - (i == 0 ? 0 : prefix[i-1]);
            int b = prefix[j] - prefix[k];
            int curr = 0;
            if(a == b) {
                curr = a + Math.max(maxScore(stone, i, k), maxScore(stone, k+1, j));
            }
            else if(a < b) {
                curr = a + maxScore(stone, i, k);
            }
            else {
                curr = b + maxScore(stone, k+1, j);
            }
            ans = Math.max(ans, curr);
        }

        return dp[i][j] = ans;
    }
}