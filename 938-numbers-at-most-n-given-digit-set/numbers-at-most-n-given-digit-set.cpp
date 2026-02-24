class Solution {
public:
    int atMostNGivenDigitSet(vector<string>& digits, int n) {
        reverse(digits.begin(), digits.end());
        digits.push_back("0");
        reverse(digits.begin(), digits.end());
        string s = to_string(n);
        vector<vector<vector<int>>> dp(s.length()+1, vector<vector<int>> (2, vector<int> (2, -1)));
        return count(s, 0, 1, 1, digits, dp)-1;
    }
    int count(string s, int i, int t, int lz, vector<string>& digit, vector<vector<vector<int>>>& dp) {
        if(i == s.length()) {
            return 1;
        }
        if(dp[i][t][lz] != -1) {
            return dp[i][t][lz];
        }
        int j = 1;
        if(lz) {
            j = 0;
        }
        int ub = s[i]-'0';
        int ans = 0;
        for(;j < digit.size(); j++) {
            int d = digit[j][0]-'0';
            if(d > ub && t==1) {
                break;
            }
            int newT = (t==1 && d==ub)?1:0;
            int newLz = (lz==1 && d==0)?1:0;
            ans += count(s, i+1, newT, newLz, digit, dp);
        }
        return  dp[i][t][lz] = ans;
    }
};