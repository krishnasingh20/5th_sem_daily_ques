class Solution {
    public int maxOperations(String s) {
        boolean zero = false;
        int ans = 0;
        int one = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') {
                zero = true;
            }
            else {
                if(zero) {
                    ans += one;
                    zero = false;
                }
                one++;
            }
        }
        if(zero) {
            ans += one;
        }
        return ans;
    }
}