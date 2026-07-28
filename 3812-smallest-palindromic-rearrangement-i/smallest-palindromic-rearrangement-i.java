class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        char[] ch = s.toCharArray();

        int[] freq = new int[26];

        for(int i = 0; i < n; i++) {
            freq[s.charAt(i)-'a']++;
        }

        int j = 0;

        for(int i = 0; i < 26; i++) {
            while(freq[i] > 1) {
                ch[j] = (char)(i+'a');
                ch[n-j-1] = (char)(i+'a');
                j++;
                freq[i] -= 2;
            }

            if(freq[i] == 1) {
                ch[n/2] = (char)(i+'a');
            }
        }

        return new String(ch);
    }
}