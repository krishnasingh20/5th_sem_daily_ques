class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(String s1: wordDict) {
            set.add(s1);
        }
        Boolean[][] dp = new Boolean[s.length()][s.length()];
        return word(s, set, 0, 0, dp);
    }
    public boolean word(String s, HashSet<String> set, int i, int j, Boolean[][] dp) {
        if(i == s.length() && j == s.length()) {
            return true;
        }
        if(j >= s.length()) {
            return false;
        }
        if(dp[i][j] != null) {
            return dp[i][j];
        }
        String s1 = s.substring(i, j+1);
        if(set.contains(s1)) {
            if(word(s, set, j+1, j+1, dp)) {
                return dp[i][j] = true;
            }
            if(word(s, set, i, j+1, dp)) {
                return dp[i][j] = true;
            }
        }
        else {
            if(word(s, set, i, j+1, dp)) {
                return dp[i][j] = true;
            }
        }
        return dp[i][j] = false;
    }
}