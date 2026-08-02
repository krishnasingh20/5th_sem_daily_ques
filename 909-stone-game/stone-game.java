class Solution {
    static int[][] dp;
    public boolean stoneGame(int[] piles) {

        int totalSum = Arrays.stream(piles).sum();

        dp = new int[piles.length][piles.length];
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }

        int stoneA = stone(piles, 0, piles.length - 1);

        return stoneA > totalSum - stoneA;
    }
    public int stone(int[] piles, int i, int j) {
        if(i > j) {
            return 0;
        }
        if(i == j) {
            return piles[i];
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int a = piles[i] + Math.min(stone(piles, i+2, j), stone(piles, i+1, j-1));
        int b = piles[j] + Math.min(stone(piles, i+1, j-1), stone(piles, i, j-2));

        return dp[i][j] = Math.max(a, b);
    }
}