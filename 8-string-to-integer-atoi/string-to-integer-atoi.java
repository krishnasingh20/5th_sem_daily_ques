class Solution {
    static final int negINF = Integer.MIN_VALUE;
    static final int posINF = Integer.MAX_VALUE;
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0) {
            return 0;
        }
        boolean sign = s.charAt(0)=='-'?false:true;
        int i = 1;
        if(s.charAt(0) != '-' && s.charAt(0) != '+') {
            i = 0;
        }
        while(i < s.length() && s.charAt(i) == '0') {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while(i < s.length()) {
            if(!isValid(s.charAt(i))) {
                break;
            }
            sb.append(s.charAt(i));
            if(sb.length() > 10) {
                break;
            }
            i++;
        }
        if(sb.length() == 0) {
            return 0;
        }
        long num = Long.parseLong(sb.toString());
        if(!sign) {
            num *= -1;
            if(num < negINF) {
                return negINF;
            }
            return (int)num;
        }
        else {
            if(num > posINF) {
                return posINF;
            }
            return (int)num;
        }
    }
    private boolean isValid(char c) {
        if(c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }
}