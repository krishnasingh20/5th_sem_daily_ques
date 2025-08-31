class Solution {
    public int minimumLength(String s) {
        if(s.charAt(0) != s.charAt(s.length()-1) || s.length() == 1) {
            return s.length();
        }
        int i = 0;
        int j = s.length()-1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                break;
            }
            else {
                int idx = i+1;
                while(idx < j && s.charAt(idx) == s.charAt(i)) {
                    idx++;
                }
                i = idx;
                idx = j - 1;
                while(idx > i && s.charAt(j) == s.charAt(idx)) {
                    idx--;
                }
                j = idx;
            }
        }
        return j-i+1;
    }
}