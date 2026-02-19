class Solution {
public:
    double myPow(double x, int n) {
        bool neg1 = x < 0.0?true:false;
        bool neg2 = n < 0?true:false;
        if(neg1) {
            x *= -1.0;
        }
        if(neg2) {
            n = abs((long)n);
        }
        double ans = pow(x, n);
        if(neg2) {
            ans = 1/ans;
        }
        if(neg1 && (n&1)) {
            ans *= -1.0;
        }
        return ans;
    }
    double pow(double x, long n) {
        if(n == 0) {
            return 1;
        }
        double ans = pow(x, n/2);
        ans *= ans;
        if((n & 1)) {
            ans *= x;
        }
        return ans;
    }
};