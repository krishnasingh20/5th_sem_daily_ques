class Solution {
    public int minInsertions(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        return minInsert(s, 0, s.length()-1, dp);
    }
    public int minInsert(String s, int i, int j, int[][] dp) {
        if(i >= j) {
            return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = 0;
        if(s.charAt(i) == s.charAt(j)) {
            ans = minInsert(s, i+1, j-1, dp);
        }
        else {
            int a = 1 + minInsert(s, i, j-1, dp);
            int b = 1 + minInsert(s, i+1, j, dp);
            int c = 2 + minInsert(s, i+1, j-1, dp);
            ans = Math.min(a, Math.min(b, c));
        }
        return dp[i][j] = ans;
    }
}