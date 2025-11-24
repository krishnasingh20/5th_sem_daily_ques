class Solution {
    public int longestIdealString(String s, int k) {
        char[] ch = s.toCharArray();
        int[][] dp = new int[ch.length][27];
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        return longestString(ch, 0, 26, k, dp);
    }
    public int longestString(char[] ch, int i, int prev, int k, int[][] dp) {
        if(i == ch.length) {
            return 0;
        }
        if(dp[i][prev] != -1) {
            return dp[i][prev];
        }
        int inc = 0;
        if(prev == 26 || Math.abs(prev - (ch[i]-'a')) <= k) {
            inc = 1 + longestString(ch, i+1, ch[i]-'a', k, dp);
        }
        int exc = longestString(ch, i+1, prev, k, dp);
        return dp[i][prev] =  Math.max(inc, exc);
    }
}