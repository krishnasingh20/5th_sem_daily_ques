class Solution {
    int n;
    static final int mod = 1000000007;
    long[] dp;
    public int numDecodings(String s) {
        n = s.length();
        dp = new long[n];
        Arrays.fill(dp, -1);
        return (int)(decode(s.toCharArray(), 0) % mod);
    }
    public long decode(char[] ch, int i) {
        if(i == n) {
            return 1;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        long ans = 0;
        if(ch[i] != '0') {
            long c = decode(ch, i+1);
            if(ch[i] == '*') {
                c *= 9;
            }
            ans = (ans + c) % mod;
        }
        if(i+1 < n && ch[i] != '0') {
            if(ch[i] != '*' && ch[i+1] != '*') {
                int num = (ch[i]-'0')*10 + (ch[i+1]-'0');
                if(num >= 10 && num <= 26) {
                    ans = (ans + decode(ch, i+2));
                }
            }
            else if(ch[i] != '*') {
                if(ch[i] <= '2') {
                    long c = decode(ch, i+2);
                    long p = ch[i] == '1'?9:6;
                    c *= p;
                    ans = (ans + c) % mod;
                }
            }
            else if(ch[i+1] != '*' ) {
                int p = 1;
                if(ch[i+1] <= '6') {
                    p++;
                }
                long c = decode(ch, i+2);
                c *= p;
                ans = (ans + c) % mod;
            }
            else {
                long c = decode(ch, i+2);
                c *= 15;
                ans = (ans + c) % mod;
            }
        }
        return dp[i] = ans;
    }
}