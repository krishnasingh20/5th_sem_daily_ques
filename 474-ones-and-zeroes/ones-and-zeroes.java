class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i < strs.length; i++) {
            int[] c = count(strs[i]);
            for(int j = m; j >= c[0]; j --) {
                for(int k = n; k >= c[1]; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j-c[0]][k-c[1]] + 1);
                }
            }
        }
        int ans = 0;
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
    public int[] count(String s) {
        int one = 0;
        int zero = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                one++;
            }
            else {
                zero++;
            }
        }
        return new int[]{zero, one};
    }
}