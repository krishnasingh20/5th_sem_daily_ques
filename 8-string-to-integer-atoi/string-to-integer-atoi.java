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
        long ans = 0;
        while(i < s.length()) {
            if(!isValid(s.charAt(i))) {
                if(!sign) {
                    ans *= -1;
                    if(ans < negINF) {
                        return negINF;
                    }
                    return (int)ans;
                }
                else {
                    if(ans > posINF) {
                        return posINF;
                    }
                    return (int)ans;
                }
            }
            ans = ans*10 + (s.charAt(i)-'0');
            long temp = ans;
            if(!sign) {
                temp *= -1;
                if(temp < negINF) {
                    return negINF;
                }
            }
            else {
                if(temp > posINF) {
                    return posINF;
                }
            }
            i++;
        }
        if(!sign) {
            ans *= -1;
            if(ans < negINF) {
                return negINF;
            }
            return (int)ans;
        }
        else {
            if(ans > posINF) {
                return posINF;
            }
            return (int)ans;
        }
    }
    private boolean isValid(char c) {
        if(c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }
}