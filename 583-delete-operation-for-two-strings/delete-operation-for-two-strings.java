class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        return minDel(word1, word2, 0, 0, dp);
    }
    public int minDel(String word1, String word2, int i, int j, int[][] dp) {
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
            ans  = minDel(word1, word2, i+1, j+1, dp);
        }
        else {
            int f = minDel(word1, word2, i+1, j, dp);
            int s = minDel(word1, word2, i, j+1, dp);
            ans = Math.min(f, s) + 1;
        }
        return dp[i][j] = ans;
    }
}