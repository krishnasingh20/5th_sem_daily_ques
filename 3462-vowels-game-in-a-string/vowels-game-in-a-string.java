class Solution {
    public boolean doesAliceWin(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(isVowel(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}