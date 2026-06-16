class Solution {
    public int maxSubstrings(String s) {
        int n = s.length();

        if(n < 4) {
            return 0;
        }

        int[][] dp = new int[n][27];

        for(int i = 0; i < 3; i++) {
            int x = s.charAt(i)-'a';
            for(int j = 0; j < 26; j++) {
                dp[i][j] = (i-1 >= 0) ? dp[i-1][j] : -1;
            }
            dp[i][x] = i;
        }

        for(int i = 3; i < n; i++) {
            int x = s.charAt(i)-'a';

            if(dp[i-3][x] != -1) {
                int idx = dp[i-3][x];
                int curr = (idx - 1 >= 0 ? dp[idx - 1][26] : 0) + 1;
                dp[i][26] = Math.max(dp[i-1][26], curr);
            }
            else {
                dp[i][26] = dp[i-1][26];
            }

            for(int j = 0; j < 26; j++) {
                dp[i][j] = dp[i-1][j];
            }

            dp[i][x] = i;
        }

        return dp[n-1][26];
    }
}