class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()][p.length()];
        return match(s, p, 0, 0, dp);
    }
    public boolean match(String s, String p, int i, int j, Boolean[][] dp) {
        if(i == s.length() && j == p.length()) {
            return true;
        }
        if(j == p.length()) {
            return false;
        }
        if(i == s.length()) {
            for(int k = j; k < p.length(); k++) {
                if(p.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }
        if(dp[i][j] != null) {
            return dp[i][j];
        }
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            if(match(s, p, i+1, j+1, dp)) {
                return dp[i][j] = true;
            }
        }
        else if(p.charAt(j) == '*') {
            boolean a = match(s, p, i+1, j, dp);//it can match multiple character consecutively
            boolean b = match(s, p, i+1, j+1, dp);
            boolean c = match(s, p, i, j+1, dp);
            if(a || b || c) {
                return dp[i][j] = true;
            }
        }
        return dp[i][j] = false;
    }
}