class Solution {
public:
    int MOD = 1000000007;
    int n;
    int numberOfWays(string &corridor) {
        n = corridor.length();

        return bottomUp(corridor);
    }

    int bottomUp(string &corridor) {
        vector<vector<int>> dp(n+1, vector<int>(3, 0));

        dp[n][2] = 1;//base case

        for(int i = n-1; i >= 0; i--) {
            for(int seat = 0; seat < 3; seat++) {

                int newSeat = ((corridor[i] == 'S')?1:0)+seat;

                if(newSeat == 3) {
                    dp[i][seat] = 0;
                    continue;
                }

                int ans = 0;

                if(newSeat == 2) {
                    ans = (ans + dp[i+1][0]) % MOD;
                }

                int skip = dp[i+1][newSeat] % MOD;

                dp[i][seat] = (ans+skip) % MOD;
            }
        }

        return dp[0][0];
    }
};