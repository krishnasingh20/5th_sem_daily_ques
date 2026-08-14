class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int ans = 0;
        int ei = 0;
        int si = 0;
        int[] freq = new int[26];

        while(ei < n) {
            freq[s.charAt(ei)-'a']++;
            while(freq[s.charAt(ei)-'a'] == 3) {
                freq[s.charAt(si)-'a']--;
                si++;
            }
            ans = Math.max(ans, (ei - si + 1));
            ei++;
        }

        return ans;
    }
}