class Solution {
public:
    int rotatedDigits(int n) {

        int ans = 0;

        for (int i = 1; i <= n; i++) {

            if (!isValid(i)) {
                ans++;
            }
        }

        return ans;
    }

    bool isValid(int n) {

        int one = 0;
        int zero = 0;
        int eight = 0;
        int c = 0;

        while (n > 0) {
            c++;
            int rem = n % 10;

            if (rem == 3 || rem == 4 || rem == 7) {
                return true;
            }
            if (rem == 0) {
                zero++;
            }
            if (rem == 1) {
                one++;
            }
            if (rem == 8) {
                eight++;
            }

            n /= 10;
        }

        if (one + zero + eight == c) {
            return true;
        }

        return false;
    }
};