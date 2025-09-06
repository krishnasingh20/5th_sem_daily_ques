class Solution {
    public int minDistance(String word1, String word2) {
        // since two parameter is changing so we apply 2DP
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        return minDist(word1, word2, 0, 0, dp);
    }
    public int minDist(String word1, String word2, int i, int j, int[][] dp) {
        if(i == word1.length() && j == word2.length()) {
            return 0;
        }
        if(i == word1.length()) {
            return word2.length()-j;
        }
        if(j == word2.length()) {
            return word1.length()-i;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = 0;
        if(word1.charAt(i) == word2.charAt(j)) {
            ans = minDist(word1, word2, i+1, j+1, dp);
        }
        else {
            int del = minDist(word1, word2, i+1, j, dp);
            int ins = minDist(word1, word2, i, j+1, dp);
            int rep = minDist(word1, word2, i+1, j+1, dp);
            ans = Math.min(del, Math.min(ins, rep)) + 1;
        }
        return dp[i][j] = ans;
    }
}