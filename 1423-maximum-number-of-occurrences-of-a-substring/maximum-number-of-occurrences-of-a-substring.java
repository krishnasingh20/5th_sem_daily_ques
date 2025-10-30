class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String, Integer> map = new HashMap<>();
        int[] freq = new int[26];
        int max = 0;
        for(int i = minSize; i <= maxSize; i++) {
            for(int j = 0; j <= s.length()-i; j++) {
                String s1 = s.substring(j, j+i);
                int dist = 0;
                for(int k = 0; k < s1.length(); k++) {
                    if(freq[s1.charAt(k)-'a']++ == 0) {
                        dist++;
                    }
                }
                if(dist <= maxLetters) {
                    map.put(s1, map.getOrDefault(s1, 0)+1);
                    max = Math.max(max, map.get(s1));
                }
                Arrays.fill(freq, 0);
            }
        }
        return max;
    }
}