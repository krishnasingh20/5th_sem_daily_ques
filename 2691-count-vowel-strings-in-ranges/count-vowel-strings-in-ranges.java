class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int m = queries.length;
        int[] prefix = new int[n+1];
        for(int i = 0; i < n; i++) {
            if(isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length()-1))) {
                prefix[i+1] = 1 + prefix[i];
            }
            else {
                prefix[i+1] = prefix[i];
            }
        }
        int[] ans = new int[m];
        for(int i = 0; i < m; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            ans[i] = prefix[r+1] - prefix[l];
        }
        return ans;
    }
    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}