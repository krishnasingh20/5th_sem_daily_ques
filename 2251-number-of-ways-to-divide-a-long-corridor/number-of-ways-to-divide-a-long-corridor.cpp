class Solution {
public:
    int MOD = 1000000007;
    int n;
    int numberOfWays(string &corridor) {
        n = corridor.length();

        vector<vector<int>> dp(n, vector<int>(3, -1));

        return ways(corridor, 0, 0, dp);
    }

    int ways(string &corridor, int i, int seat, vector<vector<int>>& dp) {
        if(i == n) {
            if(seat == 2) {
                return 1;
            }
            return 0;
        }

        if(dp[i][seat] != -1) {
            return dp[i][seat];
        }

        int newSeat = ((corridor[i] == 'S')?1:0)+seat;

        if(newSeat == 3) {
            return dp[i][seat] = 0;
        }

        int ans = 0;

        if(newSeat == 2) {
            ans = (ans + ways(corridor, i+1, 0, dp)) % MOD;
        }

        int skip = ways(corridor, i+1, newSeat, dp) % MOD;

        return dp[i][seat] = (ans+skip) % MOD;
    }
};