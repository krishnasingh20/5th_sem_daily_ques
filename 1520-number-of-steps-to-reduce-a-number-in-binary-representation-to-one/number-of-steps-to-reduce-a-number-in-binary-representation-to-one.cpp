class Solution {
public:
    int numSteps(string s) {
        int one = 0;
        int n = s.length();
        int ans = 0;
        for(int i = n-1; i >= 0; i--) {
            if(s[i] == '0') {
                if(one == 0) {
                    ans++;
                }
                else {
                    ans += one+1;
                    one = 1;
                }
            }
            else {
                one++;
            }
        }
        if(one > 1) {
            ans += one+1;
        }
        return ans;
    }
};