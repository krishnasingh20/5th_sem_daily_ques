class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        for(char c: s.toCharArray()) {
            freq[c-'a']++;
        }
        int vowel = 0;
        int consonant = 0;
        for(int i = 0; i < 26; i++) {
            if(freq[i] > 0) {
                if(i == 0 || i == 4 || i == 8 || i == 14 || i == 20) {
                    vowel = Math.max(vowel, freq[i]);
                }
                else {
                    consonant = Math.max(consonant, freq[i]);
                }
            }
        }
        return vowel + consonant;
    }
}