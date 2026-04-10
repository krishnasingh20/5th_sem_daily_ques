class Solution {
public:
    int n;
    int minFlipsMonoIncr(string &s) {
        n = s.length();

        // vector<vector<int>> dp(n, vector<int>(2, -1));

        // return minFlip(s, 0, 0, dp);

        return bottomUp(s);
    }

    int minFlip(string &s, int i, int state, vector<vector<int>>& dp) {
        if(i == n) {
            return 0;
        }

        if(dp[i][state] != -1) {
            return dp[i][state];
        }

        int ans = INT_MAX;

        if(state) {
            int curr = minFlip(s, i+1, 1, dp);
            if(s[i] == '0') {
                curr++;
            }
            ans = min(ans, curr);
        }
        else {
            int a = minFlip(s, i+1, 0, dp);
            if(s[i] == '1') {
                a++;
            }

            int b = minFlip(s, i+1, 1, dp);
            if(s[i] == '0') {
                b++;
            }

            ans = min(ans, min(a, b));
        }

        return dp[i][state] = ans;
    }

    int bottomUp(string &s) {

        vector<vector<int>> dp(n+1, vector<int>(2));

        for(int i = n-1; i >= 0; i--) {
            for(int state = 0; state <= 1; state++) {

                int ans = INT_MAX;

                if(state) {
                    int curr = dp[i+1][1];
                    if(s[i] == '0') {
                        curr++;
                    }

                    ans = min(ans, curr);
                }
                else {
                    int a = dp[i+1][0];
                    if(s[i] == '1') {
                        a++;
                    }

                    int b = dp[i+1][1];
                    if(s[i] == '0') {
                        b++;
                    }

                    ans = min(ans, min(a, b));
                }

                dp[i][state] = ans;
            }
        }

        return dp[0][0];
    }
};