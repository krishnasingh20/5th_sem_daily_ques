class Solution {
    static final int mod = 1000000007;
    Integer[][][] dp;
    public int countKReducibleNumbers(String s, int k) {
        dp = new Integer[s.length()][2][s.length()];
        int ans = count(s, 0, 1, 0, k);
        if(reducible(s, k)) {
            ans--;
        }
        return ans % mod;
    }
    public int count(String s, int i, int t, int c, int k) {
        if(i == s.length()) {
            int c1 = 1;
            while(c > 1) {
                c1++;
                c = Integer.bitCount(c);
            }
            if(c == 1 && c1 <= k) {
                return 1;
            }
            return 0;
        }
        if(t == 0 && dp[i][t][c] != null) {
            return dp[i][t][c];
        }
        int lb = 0;
        int ub = (t==1)?(s.charAt(i)-'0'):1;
        long ans = 0;
        for(int d = lb; d <= ub; d++) {
            int newT = (t==1 && d==ub)?1:0;
            ans += count(s, i+1, newT, c+d, k) % mod;
        }
        if(t == 0) {
            dp[i][t][c] = (int)ans;
        }
        return (int)ans;
    }
    private boolean reducible(String s, int k) {
        int c = 0;
        for(char ch: s.toCharArray()) {
            c += (ch-'0');
        }
        int c1 = 1;
        while(c > 1) {
            c1++;
            c = Integer.bitCount(c);
        }
        return c1 <= k;
    }
}