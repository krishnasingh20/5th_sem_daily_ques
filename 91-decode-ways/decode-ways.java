class Solution {
    public int numDecodings(String s) {
        return bottomUp(s.toCharArray());
    }
    public int bottomUp(char[] ch) {
        int n = ch.length;
        int[] dp = new int[n+2];
        dp[n] = 1;
        for(int i = n-1; i >= 0; i--) {
            int ans = 0;
            if(ch[i] != '0') {
                ans += dp[i+1];
            }
            if(i+1 < ch.length) {
                int num = (ch[i]-'0')*10 + (ch[i+1]-'0');
                if(num >= 10 && num <= 26) {
                    ans += dp[i+2];
                }
            }
            dp[i] = ans;
        }
        return dp[0];
    }
}