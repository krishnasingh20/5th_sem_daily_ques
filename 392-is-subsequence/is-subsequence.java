class Solution {
    public boolean isSubsequence(String s, String t) {
        return isSub(s, t, 0, 0);
    }
    public boolean isSub(String s, String t, int i, int j) {
        if(i == s.length()) {
            return true;
        }
        if(j == t.length()) {
            return false;
        }
        if(s.charAt(i) == t.charAt(j)) {
            if(isSub(s, t, i+1, j+1)) {
                return true;
            }
        }
        else {
            if(isSub(s, t, i, j+1)) {
                return true;
            }
        }
        return false;
    }
}