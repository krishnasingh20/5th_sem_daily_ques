class Solution {
    boolean[] good;
    public long countFancy(long l, long r) {
        good = compute();
        
        String s1 = String.valueOf(r);
        String s2 = String.valueOf(l-1);

        Long[][][][][][] dp1 = new Long[s1.length()][2][2][10][136][4];
        Long[][][][][][] dp2 = new Long[s2.length()][2][2][10][136][4];

        return count(s1, 0, 1, 1, 0, 0, 0, dp1) - count(s2, 0, 1, 1, 0, 0, 0, dp2);
    }

    private long count(String s, int i, int t, int lz, int prev, int sum, int state, Long[][][][][][] dp) {
        if(i == s.length()) {
            if(state == 0 || state == 1 || state == 2) {
                return 1;
            }
            if(good[sum]) {
                return 1;
            }
            return 0;
        }

        if(t == 0 && lz == 0 && dp[i][t][lz][prev][sum][state] != null) {
            return dp[i][t][lz][prev][sum][state];
        }

        int lb = 0;
        int ub = (t==1)?(s.charAt(i)-'0'):9;
        long res = 0;

        for(int d = lb; d <= ub; d++) {
            int newT = (t==1 && d==ub)?1:0;
            int newLz = (lz==1 && d==0)?1:0;

            if(lz == 1) {
                if(d == 0) {
                    res += count(s, i+1, newT, newLz, prev, sum, 0, dp);
                }
                else {
                    res += count(s, i+1, newT, newLz, d, sum+d, 0, dp);
                }
            }
            else {
                if((state == 0 || state == 1) && d > prev) {
                    res += count(s, i+1, newT, newLz, d, sum+d, 1, dp);
                    continue;
                }
                else if((state == 0 || state == 2) && d < prev) {
                    res += count(s, i+1, newT, newLz, d, sum+d, 2, dp);
                    continue;
                }
                
                res += count(s, i+1, newT, newLz, d, sum+d, 3, dp);
            }
        }

        if(t == 0 && lz == 0) {
            dp[i][t][lz][prev][sum][state] = res;
        }

        return res;
    }

    private boolean[] compute() {
        boolean[] arr = new boolean[136];
        for(int i = 0; i <= 135; i++) {
            boolean flag1 = true;
            boolean flag2 = true;
            String s = Integer.toString(i);
            for(int j = 1; j < s.length(); j++) {
                if(s.charAt(j) <= s.charAt(j-1)) {
                    flag1 = false;
                }
                if(s.charAt(j) >= s.charAt(j-1)) {
                    flag2 = false;
                }
            }
            arr[i] = flag1 || flag2;
        }
        return arr;
    }
}