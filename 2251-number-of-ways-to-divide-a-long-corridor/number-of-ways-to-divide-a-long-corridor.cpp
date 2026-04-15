class Solution {
public:
    int MOD = 1000000007;
    int n;
    int numberOfWays(string &corridor) {
        n = corridor.length();

        int seat0 = 0;
        int seat1 = 0;
        int seat2 = 1;

        for(int i = n-1; i >= 0; i--) {
            int curr0 = 0, curr1 = 0, curr2 = 0;
            for(int seat = 0; seat < 3; seat++) {
                int newSeat = (corridor[i]=='S'?1:0)+seat;
                if(newSeat == 3) {
                    continue;
                }

                int ans = 0;

                if(newSeat == 2) {
                    ans = (ans + seat0) % MOD;
                }

                int skip = (newSeat==0?seat0:(newSeat==1?seat1:seat2)) % MOD;

                ans = (ans + skip) % MOD;

                if(seat == 0) {
                    curr0 = ans;
                }
                else if(seat == 1) {
                    curr1 = ans;
                }
                else {
                    curr2 = ans;
                }
            }

            seat0 = curr0;
            seat1 = curr1;
            seat2 = curr2;
        }

        return seat0;
    }
};