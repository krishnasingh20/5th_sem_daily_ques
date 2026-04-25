class Solution {
public:
    int countNumbersWithUniqueDigits(int n) {

        int x = pow(10, n) - 1;
        string s = to_string(x);

        return count(s, 0, 1, 0);
    }
    int count(string& s, int idx, int t, int mask) {

        if (idx == s.length()) {
            return 1;
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

        return res;
    }
};