class Solution {
    int[] dp;
    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return decode(s.toCharArray(), 0);
    }
    public int decode(char[] ch, int i) {
        if(i == ch.length) {
            return 1;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        int ans = 0;
        if(ch[i] != '0') {
            ans += decode(ch, i+1);
        }
        if(i+1 < ch.length) {
            int num = (ch[i]-'0')*10 + (ch[i+1]-'0');
            if(num >= 10 && num <= 26) {
                ans += decode(ch, i+2);
            }
        }
        return dp[i] = ans;
    }
}