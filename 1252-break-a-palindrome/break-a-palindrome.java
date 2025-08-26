class Solution {
    public String breakPalindrome(String palindrome) {
        char[] ch = palindrome.toCharArray();
        int n = palindrome.length();
        if(n == 1) {
            return "";
        }
        for(int i = 0; i < n/2; i++) {
            if(ch[i] != 'a') {
                ch[i] = 'a';
                return new String(ch);
            }
        }
        ch[n-1]++;
        return new String(ch);
    }
}