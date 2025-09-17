class Solution {
    public int maxRepOpt1(String text) {
        int n = text.length();
        char[] ch = text.toCharArray();
        int[] freq1 = new int[26];
        for(char c: ch) {
            freq1[c-'a']++;
        }
        int[] freq = new int[26];
        int ei = 0;
        int si = 0;
        int dist = 0;
        int dist_count = 0;
        int ans = 0;
        while(ei < n) { 
            if(freq[ch[ei]-'a'] == 0) {
                dist++;
            }
            freq[ch[ei]-'a']++;
            if(freq[ch[ei]-'a'] == 2) {
                dist_count++;
            }
            while(dist > 2 || dist_count == 2) {
                freq[ch[si]-'a']--;
                if(freq[ch[si]-'a'] == 1) {
                    dist_count--;
                }
                if(freq[ch[si]-'a'] == 0) {
                    dist--;
                }
                si++;
            }
            int a = -1;
            int b = -1;
            for(int l = 0; l < 26; l++) {
                if(freq[l] != 0) {
                    if(a == -1) {
                        a = l;
                    }
                    else {
                        b = l;
                    }
                }
            }
            if(b == -1) {
                ans = Math.max(ans, (ei-si+1));
            }
            else if(freq[a] == 1 && freq[b] == 1) {
                if(freq1[a] - freq[a] > 0 || freq1[b]-freq[b] > 0) {
                    ans = Math.max(ans, (ei-si+1));
                }
            }
            else if(freq[a] == 1) {
                if(freq1[b]-freq[b] > 0) {
                    ans = Math.max(ans, (ei-si+1));
                }
            }
            else {
                if(freq1[a] - freq[a] > 0) {
                    ans = Math.max(ans, (ei-si+1));
                }
            }
            ans = Math.max(ans, (ei-si));
            ei++;
        }
        return ans;
    }
}