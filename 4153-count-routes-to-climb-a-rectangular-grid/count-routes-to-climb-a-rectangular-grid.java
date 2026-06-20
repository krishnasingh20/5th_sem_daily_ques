class Solution {
    public int numberOfRoutes(String[] grid, int d) {
        int n = grid.length;
        int m = grid[0].length();
        int MOD = 1000000007;

        long[] dp = new long[m];

        int d1 = (int)Math.floor(Math.sqrt(d*d - 1));

        for(int i = 0; i < m; i++) {
            if(grid[0].charAt(i) == '#') {
                if(i > 0) {
                    dp[i] = dp[i-1];
                }
                continue;
            }
            for(int j = 0; j < m; j++) {
                if((i-j)*(i-j) <= d*d && grid[0].charAt(j) != '#') {
                    dp[i]++;
                }
            }

            if(i > 0) {
                dp[i] += dp[i-1];
            }
        }

        for(int i = 1; i < n; i++) {
            long[] dp1 = new long[m];
            for(int j = 0; j < m; j++) {
                if(grid[i].charAt(j) == '#') {
                    if(j > 0) {
                        dp1[j] = dp1[j-1];
                    }
                    continue;
                }
                int l = Math.max(0, j - d1);
                int r = Math.min(m-1, j+d1);
                dp1[j] = (dp[r] - (l > 0 ? dp[l-1] : 0) + MOD) % MOD;

                if(j > 0) {
                    dp1[j] = (dp1[j] + dp1[j-1]) % MOD;
                }
            }

            for(int j = 0; j < m; j++) {
                if(grid[i].charAt(j) == '#') {
                    dp[j] = 0;
                    if(j > 0) {
                        dp[j] = dp[j-1];
                    }
                    continue;
                }
                int l = Math.max(0, j - d);
                int r = Math.min(m-1, j + d);
                dp[j] = (dp1[r] - (l > 0 ? dp1[l-1] : 0) + MOD) % MOD;

                if(j > 0) {
                    dp[j] = (dp[j] + dp[j-1]) % MOD;
                }
            }
        }

        return (int)dp[m-1];
    }
}