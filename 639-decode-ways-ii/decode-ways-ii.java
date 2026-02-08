class Solution {
    static final int mod = 1000000007;
    public int numDecodings(String s) {
        return bottomUp(s.toCharArray());
    }
    public int bottomUp(char[] ch) {
        int n = ch.length;
        long[] dp = new long[n+2];
        dp[n] = 1;
        for(int i = n-1; i >= 0; i--) {
            long ans = 0;
            if(ch[i] != '0') {
                long c = dp[i+1];
                if(ch[i] == '*') {
                    c *= 9 % mod;
                }
                ans += c % mod;
            }
            if(i+1 < n && ch[i] != '0') {
                if(ch[i] != '*' && ch[i+1] != '*') {
                    int num = (ch[i]-'0')*10 + (ch[i+1]-'0');
                    if(num >= 10 && num <= 26) {
                        ans += dp[i+2] % mod;
                    }
                }
                else if(ch[i] != '*') {
                    if(ch[i] <= '2') {
                        long c = dp[i+2];
                        int p = ch[i] == '1'?9:6;
                        c *= p % mod;
                        ans += c % mod;
                    }
                }
                else if(ch[i+1] != '*' ) {
                    int p = 1;
                    if(ch[i+1] <= '6') {
                        p++;
                    }
                    long c = dp[i+2];
                    c *= p % mod;
                    ans += c % mod;
                }
                else {
                    long c = dp[i+2];
                    c *= 15 % mod;
                    ans += c % mod;
                }
            }
            dp[i] = ans % mod;
        }
        return (int)dp[0];
    }
}