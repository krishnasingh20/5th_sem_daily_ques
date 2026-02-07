class Solution {
    static int mod = 1000000007;
    public int countSteppingNumbers(String low, String high) {
        low = decrement(low);
        dp = new Integer[high.length()][2][2][10];
        int r = count(high, 0, 1, 1, 0);
        dp = new Integer[low.length()][2][2][10];
        int l = count(low, 0, 1, 1, 0);
        return (r - l + mod) % mod;
    }
    Integer[][][][] dp;
    private int count(String s, int i, int t, int lz, int prev) {
        if(i == s.length()) {
            if(lz == 0) {
                return 1;
            }
            return 0;
        }
        if(t == 0 && lz == 0 && dp[i][t][lz][prev] != null) {
            return dp[i][t][lz][prev];
        }
        int lb = 0;
        int ub = (t==1)?(s.charAt(i)-'0'):9;
        int ans = 0;
        for(int digit = lb; digit <= ub; digit++) {
            if(lz == 0 && Math.abs(prev-digit) != 1) {
                continue;
            }
            int newT = (t==1 && digit==ub)?1:0;
            int newLz = (lz==1 && digit==0)?1:0;
            ans = (ans + count(s, i+1, newT, newLz, digit)) % mod;
        }
        if(t == 0 && lz == 0) {
            dp[i][t][lz][prev] = ans;
        }
        return ans;
    }
    private String decrement(String s) {
        char[] ch = s.toCharArray();
        int i = ch.length - 1;
        while(i >= 0) {
            if(ch[i] > '0') {
                ch[i]--;
                break;
            }
            ch[i] = '9';
            i--;
        }
        i = ch[0]=='0'?1:0;
        StringBuilder sb = new StringBuilder();
        while(i < ch.length) {
            sb.append(ch[i]);
            i++;
        }
        return sb.toString();
    }
}