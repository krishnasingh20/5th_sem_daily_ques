class Solution {
public:
    int countBinarySubstrings(string s) {
        vector<int> v;
        int one = 0;
        int zero = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s[i] == '1') {
                if(zero > 0) {
                    v.push_back(zero);
                    zero = 0;
                }
                one++;
            }
            else {
                if(one > 0) {
                    v.push_back(one);
                    one = 0;
                }
                zero++;
            }
        }
        if(one > 0) {
            v.push_back(one);
        }
        if(zero > 0) {
            v.push_back(zero);
        }
        if(v.size() <= 1) {
            return 0;
        }
        int ans = 0;
        for(int i = 0; i < v.size()-1; i++) {
            ans += min(v[i], v[i+1]);
        }
        return ans;
    }
};