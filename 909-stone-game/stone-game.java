class Solution {
    public boolean stoneGame(int[] piles) {
        int sum = 0;
        for(int pile: piles) {
            sum += pile;
        }
        int alice = 0;
        int l = 0;
        int m = piles.length - 1;
        while(l < m) {
            alice += Math.max(piles[l], piles[m]);
            l++;
            m--;
        }
        // int[][] dp = new int[piles.length][piles.length];
        // for(int[] d: dp) {
        //     Arrays.fill(d, -1);
        // }
        // int alice = maxPoint(piles, 0, piles.length - 1, dp);
        return alice > sum - alice;
    }
    public int maxPoint(int[] piles, int i, int j, int[][] dp) {
        if(i > j) {
            return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        int a = piles[i] + maxPoint(piles, i+1, j-1, dp);
        int b = piles[j] + maxPoint(piles, i+1, j-1, dp);
        return dp[i][j] = Math.max(a, b);
    } 
}