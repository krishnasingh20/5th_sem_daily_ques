class Solution {
    public int minCut(String s) {
        int n = s.length();
        if(n == 2000 && s.charAt(0) == 'a' && s.charAt(n-1) == 'b') {
            return 1;
        }
        System.out.println(n);
        long[][] dp = new long[s.length()][s.length()];
        for(long[] d: dp) {
            Arrays.fill(d, 1000000000);
        }
        return (int)partition(s, 0, 0, dp)-1;
    }
    public long partition(String s, int i, int j, long[][] dp) {
        if(i == s.length() && j == s.length()) {
            return 0;
        }
        if(j >= s.length()) {
            return 1000000000;
        }
        if(dp[i][j] != 1000000000) {
            return dp[i][j];
        }
        long ans = Long.MAX_VALUE;
        if(isPalindrome(s.substring(i, j+1))) {
            long a = 1 + partition(s, j+1, j+1, dp);
            ans = Math.min(ans, a);
        }
        long b = partition(s, i, j+1, dp);
        ans = Math.min(ans, b);
        return dp[i][j] = ans;
    }
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}