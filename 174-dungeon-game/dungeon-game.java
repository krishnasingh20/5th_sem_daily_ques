class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        return calculateMinHP(dungeon, 0, 0, dp);
    }
    public int calculateMinHP(int[][] dungeon, int r, int c, int[][] dp) {
        if(r == dungeon.length - 1 && c == dungeon[0].length - 1) {
            return Math.max(1, 1 - dungeon[r][c]);
        }
        if(r >= dungeon.length || c >= dungeon[0].length) {
            return Integer.MAX_VALUE;
        }
        if(dp[r][c] != -1) {
            return dp[r][c];
        }
        int down = calculateMinHP(dungeon, r+1, c, dp);
        int right = calculateMinHP(dungeon, r, c+1, dp);
        return dp[r][c] = Math.max(Math.min(down, right) - dungeon[r][c], 1);
    }
}