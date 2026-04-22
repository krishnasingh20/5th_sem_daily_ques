class Solution {
public:
    vector<string> twoEditWords(vector<string>& queries, vector<string>& dictionary) {
        int n = queries.size();
        int m = dictionary.size();
        vector<string> ans;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(isValid(queries[i], dictionary[j])) {
                    ans.push_back(queries[i]);
                    break;
                }
            }
        }

        return ans;
    }

    bool isValid(string &s1, string &s2) {
        int i = 0;
        int c = 0;

        while(i < s1.length()) {
            if(s1[i] != s2[i]) {
                c++;
            }
            if(c > 2) {
                return false;
            }
            i++;
            
        }

        return true;
    }
};