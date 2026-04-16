class Solution {
public:
    vector<string> ans;
    unordered_set<string> set;
    vector<string> wordBreak(string s, vector<string>& wordDict) {
        
        for(string s1: wordDict) {
            set.insert(s1);
        }

        word(s, 0, 0, "");

        return ans;
    }

    void word(string& s, int i, int j, string s1) {
        if(j == s.length()) {
            if(i == s.length()) {
                ans.push_back(s1);
            }
            return;
        }

        string s2 = s.substr(i, j-i+1);

        if(set.count(s2)) {

            if(s1.length() == 0) {
                word(s, j+1, j+1, s2);
            }
            else {
                word(s, j+1, j+1, s1+" "+s2);
            }
        }

        word(s, i, j+1, s1);
    }
};