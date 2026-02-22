class Solution {
public:
    string maximumXor(string s, string t) {
        int one = 0;
        int zero = 0;
        for(int i = 0; i < t.length(); i++) {
            if(t[i] == '0') {
                zero++;
            }
            else {
                one++;
            }
        }
        for(int i = 0; i < s.length(); i++) {
            if(s[i] == '0') {
                if(one > 0) {
                    s[i] = '1';
                    one--;
                }
                else {
                    zero--;
                }
            }
            else {
                if(zero > 0) {
                    zero--;
                }
                else {
                    one--;
                    s[i] = '0';
                }
            }
        }
        return s;
    }
};