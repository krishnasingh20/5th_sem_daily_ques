class Solution {
    public int appendCharacters(String s, String t) {
        return makeSub(s, t, 0, 0);
    }
    public int makeSub(String s, String t, int i, int j) {
        if(j == t.length()) {
            return 0;
        }
        if(i == s.length()) {
            return t.length() - j;
        }
        int count = 0;
        if(s.charAt(i) == t.charAt(j)) {
            count = makeSub(s, t, i+1, j+1);
        }
        else{
            // int a = 1 + makeSub(s, t, i+1, j+1);
            count = makeSub(s, t, i+1, j);
        }
        return count;
    }
}