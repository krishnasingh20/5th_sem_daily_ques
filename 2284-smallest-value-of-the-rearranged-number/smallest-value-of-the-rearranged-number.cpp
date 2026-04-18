class Solution {
public:
    long long smallestNumber(long long num) {
        if(num == 0) {
            return 0;
        }

        vector<int> digit(10);
        bool neg = (num < 0)?1:0;
        num = abs(num);
        int mmin = 10;

        while(num > 0) {
            int rem = (int)(num % 10);
            digit[rem]++;
            num /= 10;

            if(rem > 0) {
                mmin = min(mmin, rem);
            }
        }

        long long ans = 0;

        if(neg) {
            for(int i = 9; i >= 0; i--) {
                for(int j = 1; j <= digit[i]; j++) {
                    ans = ans*10 + i;
                }
            }
            ans *= -1;
        }
        else {
            ans = ans*10 + mmin;
            digit[mmin]--;

            for(int i = 0; i < 10; i ++) {
                for(int j = 1; j <= digit[i]; j++) {
                    ans = ans*10 + i;
                }
            }
        }

        return ans;
    }
};