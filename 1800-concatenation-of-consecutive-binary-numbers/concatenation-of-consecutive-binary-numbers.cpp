class Solution {
public:
    int concatenatedBinary(int n) {
        int ans = 0;
        int mod = 1000000007;
        int pow = 1;
        for(int i = n; i >= 1; i--) {
            int num = i;
            while(num > 0) {
                if((num & 1)) {
                    ans = (ans + pow) % mod;
                }
                num >>= 1;
                pow = (pow * 2) % mod;
            }
        }
        return ans;
    }
};