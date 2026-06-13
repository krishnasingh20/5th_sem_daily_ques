class Solution {
public:
    string mapWordWeights(vector<string>& words, vector<int>& weights) {
        string ans = "";
        int n = words.size();
        
        for(int i = 0; i < n; i++) {
            int w = 0;
            for(int j = 0; j < words[i].length(); j++) {
                int x = words[i][j] - 'a';
                w += weights[x];
            }
            int x = 25 - (w % 26);
            ans = ans + (char)(x+'a');
        }

        return ans;
    }
};