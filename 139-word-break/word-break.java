class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // HashSet<String> set = new HashSet<>();
        // for(String s1: wordDict) {
        //     set.add(s1);
        // }
        // Boolean[][] dp = new Boolean[s.length()][s.length()];
        // return word(s, set, 0, 0, dp);
        return bottomUp(s, wordDict);
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
        String s1 = s.substring(i, j+1);//due to meoinzation it take O(n^2) because we aleady maintaining i , j
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
    // bottom up
    // think that recursion is working from back
    public boolean bottomUp(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;//for empty string answer will be true
        HashSet<String> set = new HashSet<>(wordDict);
        for(int i = 1; i <= s.length(); i++) {
            for(String s1: wordDict) {
                int t = s1.length();
                if(i-t >= 0 && s.substring(i-t, i).equals(s1) && dp[i-t]) {
                    dp[i] = true;
                    break;
                } 
            }
        }
        return dp[dp.length-1];
    }
}
// below for top down approach
// TC --> O(n²) in worst case
// SC --> O(n²) for dp + O(k) for dictionary + O(n) call stack