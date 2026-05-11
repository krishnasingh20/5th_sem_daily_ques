class Solution {
    Long[][][][][] dp;
    public long countGoodIntegersOnPath(long l, long r, String dir) {
        String s1 = String.valueOf(r);
        String s2 = String.valueOf(l-1);
        int x = 16 - s1.length();
        StringBuilder sb = new StringBuilder();

        while (x-- > 0) {
            sb.append(0);
        }
        sb.append(s1);

        dp = new Long[16][7][2][10][5];
        long ans1 = count(sb.toString(), dir, 0, 0, 1, 0, 1);

        sb.setLength(0);
        x = 16 - s2.length();

        while(x-- > 0) {
            sb.append(0);
        }
        sb.append(s2);

        dp = new Long[16][7][2][10][5];
        long ans2 = count(sb.toString(), dir, 0, 0, 1, 0, 1);

        return ans1 - ans2;
    }

    private long count(String s, String dir, int i, int j, int tight, int prev, int pos) {
        if (i == 16) {
            return 1;
        }

        if(dp[i][j][tight][prev][pos] != null) {
            return dp[i][j][tight][prev][pos];
        }

        int lb = 0;
        int ub = (tight == 1 ? (s.charAt(i) - '0') : 9);
        long res = 0;

        for (int d = lb; d <= ub; d++) {

            if (pos == 1 && d < prev) {
                continue;
            }
            int newT = ((tight == 1 && d == ub) ? 1 : 0);
            int newPrev = pos == 1 ? d : prev;
            int newPos = (pos == 1 && j != 6? (dir.charAt(j) == 'D' ? 4 : 1) : pos - 1);
            int newJ = pos == 1 ? j + 1 : j;

            res += count(s, dir, i+1, newJ, newT, newPrev, newPos);
        }

        return dp[i][j][tight][prev][pos] = res;
    }
}