class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        return minDelSum(s1, s2, 0, 0, dp);
    }
    public int minDelSum(String s1, String s2, int i, int j, int[][] dp) {
        if(i == s1.length() && j == s2.length()) {
            return 0;
        }
        if(i == s1.length()) {
            int sum = 0;
            for(int idx = j; idx < s2.length(); idx++) {
                sum += s2.charAt(idx);
            }
            return sum;
        }
        if(j == s2.length()) {
            int sum = 0;
            for(int idx = i; idx < s1.length(); idx++) {
                sum += s1.charAt(idx);
            }
            return sum;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = 0;
        if(s1.charAt(i) == s2.charAt(j)) {
            ans = minDelSum(s1, s2, i+1, j+1, dp);
        }
        else {
            int f = (int)s1.charAt(i) + minDelSum(s1, s2, i+1, j, dp);
            int s = (int)s2.charAt(j) + minDelSum(s1, s2, i, j+1, dp);
            ans = Math.min(f, s);
        }
        return dp[i][j] = ans;
    }
}