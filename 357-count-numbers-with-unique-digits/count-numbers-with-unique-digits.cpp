class Solution {
public:
    
    int dp[8][1 << 10][2];

    int countNumbersWithUniqueDigits(int n) {

        int x = pow(10, n) - 1;
        string s = to_string(x);
        memset(dp, -1, sizeof(dp));

        return count(s, 0, 1, 0);
    }
    int count(string& s, int idx, int t, int mask) {

        if (idx == s.length()) {
            return 1;
        }

        if(t == 0 && dp[idx][mask][t] != -1) {
            return dp[idx][mask][t];
        }

        int lb = 0;
        int ub = t == 1 ? (s[idx] - '0') : 9;
        int res = 0;

        for (int d = lb; d <= ub; d++) {

            if ((mask & (1 << d)) != 0) {
                continue;
            }

            int newMask = 0;
            int newT = (t == 1 && d == ub) ? 1 : 0;

            if (mask != 0 || d != 0) {
                newMask = (mask | (1 << d));
            }

            res += count(s, idx + 1, newT, newMask);
        }

        if(t == 0) {
            dp[idx][mask][t] = res;
        }

        return res;
    }
};