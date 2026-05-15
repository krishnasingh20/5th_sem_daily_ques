class Solution {
public:
    int minFlips(string s) {
        int n = s.length();
        int one = 0;
        int zero = 0;

        for(int i = 0; i < n; i++) {
            if(s[i] == '0') {
                zero++;
            }
            else {
                one++;
            }
        }

        if(one <= 1 || zero == 0) {
            return 0;
        }

        int ans = INT_MAX;

        if(s[0] == '1' && s[n-1] == '1') {
            ans = min(ans, min(zero, one-2));
        }
        else if(s[0] == '1' || s[n-1] == '1') {
            ans = min(ans, min(zero, one-1));
        }
        else {
            ans = min(ans, min(zero, one-1));
        }

        return ans;
    }
};