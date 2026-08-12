class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();

        int[][] freq = new int[n][26];
        int[] index = new int[26];
        int ans = 0;
        
        for(int i = 0; i < n; i++) {
            int x = s.charAt(i)-'a';
            freq[i][x]++;
            index[x] = i;

            for(int j = 0; j < 26; j++) {
                freq[i][j] += (i-1 >= 0 ? freq[i-1][j] : 0);
            }

            int idx = -1;
            int cnt = 0;

            for(int j = 0; j < 26; j++) {
                if(freq[i][j] > 0 && freq[i][j] < k) {
                    idx = Math.max(idx, index[j]);
                }
                else if(freq[i][j] >= k) {
                    cnt += freq[i][j];
                }
            }

            if(cnt == (i+1)) {
                ans = Math.max(ans, cnt);
                continue;
            }

            int rv = -1;
            if(idx != -1 && idx != i) {
                rv = idx;
            }

            int last = -1;

            while(rv != -1) {
                int max = -1;
                last = Math.max(last, rv);

                for(int j = 0; j < 26; j++) {
                    if(freq[i][j] - freq[rv][j] > 0 && freq[i][j] - freq[rv][j] < k) {
                        max = Math.max(max, index[j]);
                    }
                }

                rv = max;
                if(max == i) {
                    last = -1;
                }
            }

            if(last != -1) {
                ans = Math.max(ans, i - last);
            }
        }

        return ans;
    }
}