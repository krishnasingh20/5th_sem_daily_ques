class Solution {
    public int concatenatedBinary(int n) {
        int pow = 1;
        int mod = 1000000007;
        int ans = 0;
        while(n > 0) {
            int num = n;
            while(num > 0) {
                if((num & 1) == 1) {
                    ans = (ans + pow) % mod;
                }
                pow = (pow * 2) % mod;
                num >>= 1;
            }
            n--;
        }
        return ans;
    }
}