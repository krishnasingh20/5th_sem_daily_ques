class Solution {
public:
    int minFlipsMonoIncr(string s) {
        int n = s.length();

        vector<int> suffix(n+1);

        for(int i = n-1; i >= 0; i--) {
            if(s[i] == '0') {
                suffix[i] = 1;
            }

            suffix[i] = suffix[i] + suffix[i+1];
        }

        int ans = INT_MAX;

        int prefix_one = 0;

        for(int i = 0; i < n; i++) {

            ans = min(ans, prefix_one+suffix[i+1]);
            
            if(s[i] == '1') {
                prefix_one++;
            }
        }

        return ans;
    }
};