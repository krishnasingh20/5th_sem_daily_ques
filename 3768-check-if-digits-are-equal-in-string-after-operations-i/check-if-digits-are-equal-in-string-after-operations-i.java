class Solution {
    public boolean hasSameDigits(String s) {
        while(true) {
            StringBuilder str = new StringBuilder();
            for(int i = 0; i < s.length() - 1; i++) {
                int a = ((s.charAt(i) - '0') + (s.charAt(i+1) - '0')) % 10;
                str.append(a+"");
            }
            s = str.toString();
            if(s.length() == 2) {
                if(s.charAt(0) == s.charAt(1)) {
                    return true;
                }else{
                    return false;
                }
            }
        }
    }
}