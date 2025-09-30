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
        if(compare(freq, freq1)) {
            return true;
        }
        for(int i = k; i < s2.length(); i++) {
            freq1[s2.charAt(i)-'a']++;
            freq1[s2.charAt(i-k)-'a']--;
            if(compare(freq, freq1)) {
                return true;
            }
        }
        return false;
    }
    public boolean compare(int[] a, int[] b) {
        for(int i = 0; i < 26; i++) {
            if(a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}


// in these i had reduce overhead of every time generating string to directly cpmare the freq array using array in built function