class Solution {
    Long[][][] dp;
    boolean[] visited;
    public long countGoodIntegersOnPath(long l, long r, String dir) {
        visited = new boolean[16];
        visited[0] = true;
        int i = 0;
        int j = 0;
        for(int k = 0; k < 6; k++) {
            if(dir.charAt(k) == 'D') {
                i++;
            }
            else {
                j++;
            }
            visited[i*4 + j] = true;
        }
        String s1 = String.valueOf(r);
        String s2 = String.valueOf(l-1);
        int x = 16 - s1.length();
        StringBuilder sb = new StringBuilder();

        while (x-- > 0) {
            sb.append(0);
        }
        sb.append(s1);

        dp = new Long[16][2][10];
        long ans1 = count(sb.toString(), 0, 1, 0);

        sb.setLength(0);
        x = 16 - s2.length();

        while(x-- > 0) {
            sb.append(0);
        }
        sb.append(s2);

        dp = new Long[16][2][10];
        long ans2 = count(sb.toString(), 0, 1, 0);

        return ans1 - ans2;
    }

    private long count(String s, int i, int tight, int prev) {
        if (i == 16) {
            return 1;
        }

        if(dp[i][tight][prev] != null) {
            return dp[i][tight][prev];
        }

        int lb = 0;
        int ub = (tight == 1 ? (s.charAt(i) - '0') : 9);
        long res = 0;

        for (int d = lb; d <= ub; d++) {

            int newT = (tight == 1 && d == ub) ? 1 : 0;

            if(visited[i]) {
                if(d >= prev) {
                    res += count(s, i+1, newT, d);
                }
            }
            else {
                res += count(s, i+1, newT, prev);
            }
        }

        return dp[i][tight][prev] = res;
    }
}