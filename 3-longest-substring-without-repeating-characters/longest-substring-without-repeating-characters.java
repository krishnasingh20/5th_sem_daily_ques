class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] ch = s.toCharArray();
        int[] freq = new int[128];
        int n = ch.length;
        int ei = 0;
        int si = 0;
        int ans = 0;
        while(ei < n) {
            freq[ch[ei]]++;
            while(freq[ch[ei]] > 1) {
                freq[ch[si]]--;
                si++;
            }
            ans = Math.max(ans, ei-si+1);
            ei++;
        }
        return ans;
    }
}