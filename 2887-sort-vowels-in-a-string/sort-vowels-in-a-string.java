class Solution {
    public String sortVowels(String s) {
        char[] ch = s.toCharArray();
        int[] freq = new int[123];
        for(int i = 0; i < ch.length; i++) {
            if(isVowel(Character.toLowerCase(ch[i]))) {
                freq[ch[i]]++;
            }
        }
        for(int i = 0; i < ch.length; i++) {
            if(isVowel(Character.toLowerCase(ch[i]))) {
                for(int j = 0; j < 123; j++) {
                    if(freq[j] > 0) {
                        ch[i] = (char)(j);
                        freq[j]--;
                        break;
                    }
                }
            }
        }
        return new String(ch);
    }
    public boolean isVowel(char ch) {
        return ch =='a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}