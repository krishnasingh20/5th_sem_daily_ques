class Solution {
    public String largestOddNumber(String num) {
        int idx = -1;
        for(int i = num.length()-1; i >= 0; i--) {
            char ch = num.charAt(i);
            int x = ch - '0';
            if(x % 2 != 0) {
                idx = i;
                break;
            }
        }
        if(idx == -1) {
            return "";
        }
        return num.substring(0, idx+1);
    }
}