class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        int k = s1.length();
        int[] freq = new int[26];
        for(char c: s1.toCharArray()) {
            freq[c-'a']++;
        }
        int[] freq1 = new int[26];
        for(int i = 0; i < k; i++) {
            freq1[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(freq, freq1)) {
            return true;
        }
        for(int i = k; i < s2.length(); i++) {
            freq1[s2.charAt(i)-'a']++;
            freq1[s2.charAt(i-k)-'a']--;
            if(Arrays.equals(freq, freq1)) {
                return true;
            }
        }
        return false;
    }
}