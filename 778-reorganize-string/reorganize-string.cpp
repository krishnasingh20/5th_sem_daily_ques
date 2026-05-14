struct cmp {
    static bool operator()(const pair<int, int>& a, const pair<int, int>& b) {
        return a.second < b.second;
    }
};

class Solution {
public:
    string reorganizeString(string s) {
        int n = s.length();
        priority_queue<pair<int, int>, vector<pair<int, int>>, cmp> pq;
        vector<int> freq(26, 0);
        for(int i = 0; i < n; i++) {
            int x = s[i]-'a';
            freq[x]++;
        }

        for(int i = 0; i < 26; i++) {
            if(freq[i] > 0) {
                pq.push({i, freq[i]});
            }
        }

        string ans = "";
        while(!pq.empty()) {
            pair<int, int> rv = pq.top();
            pq.pop();
            if(ans.length() > 0 && ans[ans.length()-1]-'a' == rv.first) {
                if(pq.empty()) {
                    return "";
                }
                pair<int, int> rv1 = pq.top();
                pq.pop();
                ans = ans + (char)(rv1.first+'a');
                if(rv1.second > 1) {
                    rv1.second = rv1.second - 1;
                    pq.push(rv1);
                }
                pq.push(rv);
            }
            else {
                ans = ans + (char)(rv.first+'a');
                if(rv.second > 1) {
                    rv.second = rv.second - 1;
                    pq.push(rv);
                }
            }
        }

        return ans;
    }
};