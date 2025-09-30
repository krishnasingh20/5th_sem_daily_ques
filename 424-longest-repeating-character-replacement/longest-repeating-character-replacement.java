class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int ei = 0;
        int si = 0;
        int n = s.length();
        int ans = 0;
        while(ei < n) {
            freq[s.charAt(ei)-'A']++;
            while((ei-si+1)-max(freq) > k) {
                freq[s.charAt(si)-'A']--;
                si++;
            }
            ans = Math.max(ans, (ei-si+1));
            ei++;
        }
        return ans;
    }
    public int max(int[] freq) {
        int ans = 0;
        for(int i = 0; i < 26; i++) {
            ans = Math.max(ans, freq[i]);
        }
        return ans;
    }
}