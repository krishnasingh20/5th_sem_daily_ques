class Solution {
    public int longestIdealString(String s, int k) {
        char[] ch = s.toCharArray();
        // int[][] dp = new int[ch.length][27];
        // for(int[] d: dp) {
        //     Arrays.fill(d, -1);
        // }
        // return longestString(ch, 0, 26, k, dp);
        return bottomUp(ch, k);
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
    public int bottomUp(char[] ch, int k) {
        int[] dp = new int[27];
        int ans = 0;
        for(int i = ch.length - 1; i >= 0; i--) {
            int x = ch[i]-'a';
            int s = Math.max(0, x-k);
            int e = Math.min(26, x+k);
            int val = 0;
            for(int j = s; j <= e; j++) {
                val = Math.max(val, dp[j]+1);
            }
            dp[x] = Math.max(val, dp[x]);
            ans = Math.max(ans, val);
        }
        return ans;
    }
}