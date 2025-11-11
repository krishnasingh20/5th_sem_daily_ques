class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length][m+1][n+1];
        for(int[][] d: dp) {
            for(int[] a: d) {
                Arrays.fill(a, -1);
            }
        }
        return maxForm(strs, m, n, 0, dp);
    }
    public int maxForm(String[] str, int m, int n, int i, int[][][] dp) {
        if(i == str.length || (m == 0 && n == 0)) {
            return 0;
        }
        if(dp[i][m][n] != -1) {
            return dp[i][m][n];
        }
        int[] c = count(str[i]);
        int pick = 0;
        if(c[0] <= m && c[1] <= n) {
            pick = 1 + maxForm(str, m-c[0], n-c[1], i+1, dp);
        }
        int notPick = maxForm(str, m, n, i+1, dp);
        return dp[i][m][n] = Math.max(notPick, pick);
    }
    public int[] count(String s) {
        int one = 0;
        int zero = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                one++;
            }
            else {
                zero++;
            }
        }
        return new int[]{zero, one};
    }
}