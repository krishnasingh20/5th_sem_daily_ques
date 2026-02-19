class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int ans = 0;
        int ei = 0;
        int si = 0;
        vector<int> freq(256, 0);
        int n = s.length();
        while(ei < n) {
            freq[s[ei]]++;
            while(freq[s[ei]] > 1) {
                freq[s[si]]--;
                si++;
            }
            ans = max(ans, ei-si+1);
            ei++;
        }
        return ans;
    }
};