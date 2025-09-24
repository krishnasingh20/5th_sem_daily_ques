class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        return longestPalindrome(s, 0, n-1, dp);
    }
    public int longestPalindrome(String s, int i, int j, int[][] dp) {
        if(i > j) {
            return 0;
        }
        if(i == j) {
            return 1;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = 0;
        if (s.charAt(i) == s.charAt(j)) {
            ans = 2 + longestPalindrome(s, i+1, j-1, dp);
        }
        else {
            int a = longestPalindrome(s, i+1, j, dp);
            int b = longestPalindrome(s, i, j-1, dp);
            ans = Math.max(a, b);
        }
        return dp[i][j] = ans;
    }
}