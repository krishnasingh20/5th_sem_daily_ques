class Solution {
public:
    int minOperations(string s) {
        return  min(alternate(s, true), alternate(s, false));
    }
    int alternate(string s, bool flag) {
        int opr = 0;
        for(int i = 0; i < s.length(); i++) {
            if(flag) {
                if(s[i] == '0') {
                    opr++;
                }
            }
            else {
                if(s[i] == '1') {
                    opr++;
                }
            }
            flag = !flag;
        }
        return opr;
    }
};