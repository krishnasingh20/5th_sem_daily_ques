class Solution {
public:
    int MOD = 1000000007;
    int numberOfWays(string &corridor) {
        return bottomUp(corridor);
    }

    int bottomUp(string &corridor) {
    int n = corridor.size();

    int next0 = 0, next1 = 0, next2 = 1; // dp[n][2] = 1

    for(int i = n - 1; i >= 0; i--) {

        int curr0 = 0, curr1 = 0, curr2 = 0;

        for(int seat = 0; seat < 3; seat++) {

            int newSeat = ((corridor[i] == 'S') ? 1 : 0) + seat;

            if(newSeat == 3) continue;

            int ans = 0;

            if(newSeat == 2) {
                ans = (ans + next0) % MOD;
            }

            int skip = (newSeat == 0 ? next0 : (newSeat == 1 ? next1 : next2)) % MOD;

            int value = (ans + skip) % MOD;

            if(seat == 0) curr0 = value;
            else if(seat == 1) curr1 = value;
            else curr2 = value;
        }

        next0 = curr0;
        next1 = curr1;
        next2 = curr2;
    }

    return next0;
}
};