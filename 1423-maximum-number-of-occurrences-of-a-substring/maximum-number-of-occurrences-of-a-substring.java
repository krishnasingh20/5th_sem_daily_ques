class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int[] freq = new int[26];
        HashMap<String, Integer> map = new HashMap<>();
        int dist = 0;
        for(int i = 0;i < minSize; i++) {
            if(freq[s.charAt(i)-'a']++ == 0) {
                dist++;
            }
        }
        if(dist <= maxLetters) {
            String s1 = s.substring(0, minSize);
            map.put(s1, map.getOrDefault(s1, 0)+1);
        }
        for(int i = minSize; i < s.length(); i++) {
            if(freq[s.charAt(i)-'a']++ == 0) {
                dist++;
            }
            freq[s.charAt(i - minSize)-'a']--;
            if(freq[s.charAt(i - minSize)-'a'] == 0) {
                dist--;
            }
            if(dist <= maxLetters) {
                String s2 = s.substring(i - minSize+1, i+1);
                map.put(s2, map.getOrDefault(s2, 0)+1);
            }
        }
        int ans = 0;
        for(String key: map.keySet()) {
            ans = Math.max(ans, map.get(key));
        }
        return ans;
    }
}