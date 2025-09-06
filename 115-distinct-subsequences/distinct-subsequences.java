class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return distinct(s, t, 0, 0, dp);
    }
    public int distinct(String s, String t, int i, int j, int[][] dp) {
        if(j == t.length()) {
            return 1;
        }
        if(i == s.length()) {
            return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        int exc = 0;
        int inc = 0;
        if(s.charAt(i) == t.charAt(j)) {
            inc = distinct(s, t, i+1, j+1, dp);
        }
        exc = distinct(s, t, i+1, j, dp);
        return dp[i][j] = inc+exc;
    }
}