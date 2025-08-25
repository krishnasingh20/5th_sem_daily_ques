class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j <= n; j++) {
                String s1 = s.substring(i,j);
                map.put(s1, map.getOrDefault(s1, 0) + 1);
            }
        }
        int ei = 0;
        int si = 0;
        int cnt = 0;
        int[] freq = new int[26];
        int ans = 0;
        while(ei < n) {
            char ch = s.charAt(ei);
            if(freq[ch-'a'] == 0) {
                cnt++;
            }
            freq[ch-'a']++;
            while(cnt > 1) {
                ch = s.charAt(si);
                freq[ch-'a']--;
                if(freq[ch-'a'] == 0) {
                    cnt--;
                }
                si++;
            }
            String s2 = s.substring(si, ei+1);
            if(map.get(s2) >= 3) {
                ans = Math.max(ans, (ei-si+1));
            }
            ei++;
        }
        return ans == 0?-1:ans;
    }
}