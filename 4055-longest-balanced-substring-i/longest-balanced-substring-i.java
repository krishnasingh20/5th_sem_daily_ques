class Solution {
    public int longestBalanced(String s) {
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            int[] freq = new int[26];
            for(int j = i; j < s.length(); j++) {
                freq[s.charAt(j)-'a']++;
                if(isValid(freq, freq[s.charAt(j)-'a'])) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
    public boolean isValid(int[] freq, int c) {
        for(int i = 0; i < 26; i++) {
            if(freq[i] > 0 && freq[i] != c) {
                return false;
            }
        }
        return true;
    }
}