class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length()/2;
        for(int i = 1; i <= len; i++) {
            if(s.length() % i != 0) {
                continue;
            }
            boolean flag = false;
            String s1 = s.substring(0, i);
            // System.out.println(s1);
            for(int j = i; j <= s.length()-i; j += i) {
                if(s.substring(j, j+i).equals(s1) == false) {
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                return true;
            }
        }
        return false;
    }
}