class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int ei = 0;
        int si = 0;
        int n = s.length();
        int ans = 0;
        int max = 0;
        while(ei < n) {
            freq[s.charAt(ei)-'A']++;
            max = Math.max(max, freq[s.charAt(ei)-'A']);
            while((ei-si+1)-max > k) {
                freq[s.charAt(si)-'A']--;
                si++;
            }
            ans = Math.max(ans, (ei-si+1));
            ei++;
        }
        return ans;
    }
}

