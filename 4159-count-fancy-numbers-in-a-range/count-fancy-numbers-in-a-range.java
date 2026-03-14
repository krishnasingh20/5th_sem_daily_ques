class Solution {
    public long countFancy(long l, long r) {
        String s1 = String.valueOf(r);
        String s2 = String.valueOf(l-1);
        long[][][][][][] dp = new long[16][2][2][10][136][4];

        for(long[][][][][] d: dp) {
            for(long[][][][] d1: d) {
                for(long[][][] d2: d1) {
                    for(long[][] d3: d2) {
                        for(long[] d4: d3) {
                            Arrays.fill(d4, -1);
                        }
                    }
                }
            }
        }
        long ans1 = count(s1, 0, 1, 1, 0, 0, 0, dp);

        for(long[][][][][] d: dp) {
            for(long[][][][] d1: d) {
                for(long[][][] d2: d1) {
                    for(long[][] d3: d2) {
                        for(long[] d4: d3) {
                            Arrays.fill(d4, -1);
                        }
                    }
                }
            }
        }
        
        long ans2 = count(s2, 0, 1, 1, 0, 0, 0, dp);

        return ans1 - ans2;
    }

    private long count(String s, int i, int t, int lz, int prev, int sum, int state, long[][][][][][] dp) {
        if(i == s.length()) {
            if(state == 0 || state == 1 || state == 2) {
                return 1;
            }
            if(isGood(sum)) {
                return 1;
            }
            return 0;
        }

        if(t == 0 && lz == 0 && dp[i][t][lz][prev][sum][state] != -1) {
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

    private boolean isGood(int n) {
        int prev = 10;
        int num = n;

        while(num > 0) {
            if(num % 10 >= prev) {
                prev = -1;
                break;
            }
            prev = num % 10;
            num /= 10;
        }

        if(prev != -1) {
            return true;
        }

        num = n;
        while(num > 0) {
            if(num % 10 <= prev) {
                return false;
            }
            prev = num % 10;
            num /= 10;
        }

        return true;
    }
}