class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if(n == 1) {
            return "";
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 25; j++) {
                if((n & 1) == 1 && i == (n/2)) {
                    continue;
                }
                if(j < palindrome.charAt(i)-'a') {
                    return palindrome.substring(0,i)+((char)(j+'a'))+palindrome.substring(i+1);
                }
            }
        }
        return palindrome.substring(0, palindrome.length()-1)+((char)(palindrome.charAt(palindrome.length() - 1) + 1)); 
    }
}