class Solution {
public:
    bool hasAllCodes(string s, int k) {
        int n = s.length();
        unordered_set<int> set;
        for(int i = 0; i <= n-k; i++) {
            int num = 0;
            int p = pow(2, k-1);
            for(int j = i; j < i+k; j++) {
                num += (s[j]-'0')*p;
                p /= 2;
            }
            set.insert(num);
        }
        return set.size() == (1<<k);
    }
};