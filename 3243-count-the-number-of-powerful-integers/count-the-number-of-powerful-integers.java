class Solution {
    int n;
    int m;
    Long[][][] dp;
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        if(Long.parseLong(s) > finish) {
            return 0;
        }
        String s1 = String.valueOf(start-1);
        String s2 = String.valueOf(finish);
        n = s1.length();
        m = s.length();
        dp = new Long[n][2][m];
        long ans1 = count(s1, s, 0, 1, 0, limit);
        n = s2.length();
        dp = new Long[n][2][m];
        long ans2 = count(s2, s, 0, 1, 0, limit);
        return ans2 - ans1;
    }
    public long count(String s1, String s2, int i, int t, int k, int limit) {
        if(i == n) {
            if(k == m) {
                return 1;
            }
            return 0;
        }
        if(t == 0 && dp[i][t][k] != null) {
            return dp[i][t][k];
        }
        int lb = 0;
        int ub = (t==1)?Math.min((s1.charAt(i)-'0'), limit):limit;
        long ans = 0;
        for(int d = lb; d <= ub; d++) {
            if(i == (n-m+k) && d != (s2.charAt(k)-'0')) {
                continue;
            }
            int newT = (t==1 && d==(s1.charAt(i)-'0'))?1:0;
            int newK = (i == (n-m+k))?k+1:k;
            ans += count(s1, s2, i+1, newT, newK, limit);
        }
        if(t == 0) {
            dp[i][t][k] = ans;
        }
        return ans;
    }
}