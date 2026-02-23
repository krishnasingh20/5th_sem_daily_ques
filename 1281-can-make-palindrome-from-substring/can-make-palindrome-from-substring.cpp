class Solution {
public:
    vector<bool> canMakePaliQueries(string s, vector<vector<int>>& queries) {
        int n = s.length();
        vector<vector<int>> prefix(n+1, vector<int> (26));
        for(int i = 0; i < n; i++) {
            int x = s[i]-'a';
            prefix[i+1][x] = 1;
            for(int j = 0; j < 26; j++) {
                prefix[i+1][j] += prefix[i][j];
            }
        }
        int q = queries.size();
        vector<bool> ans(q);
        for(int i = 0; i < q; i++) {
            int odd = 0;
            int l = queries[i][0];
            int r = queries[i][1]+1;
            int k = queries[i][2];
            for(int j = 0; j < 26; j++) {
                int count = prefix[r][j] - prefix[l][j];
                if((count & 1) == 1) {
                    odd++;
                }
            }
            if(odd-1 <= 2*k) {
                ans[i] = true;
            }
        }
        return ans;
    }
};