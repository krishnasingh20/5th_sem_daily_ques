struct Pair {
    int val;
    int count;
    int maxPath;
    Pair(int v, int c, int m) {
        val = v;
        count = c;
        maxPath = m;
    }
};

class Solution {
public:
    int longestPath(vector<int>& parent, string s) {
        int n = parent.size();
        vector<vector<int>> tree(n);
        for(int i = 1; i < n; i++) {
            tree[parent[i]].push_back(i);
        }
        return path(tree, s, 0).maxPath;
    }
    Pair path(vector<vector<int>>& tree, string& s, int src) {
        int maxPath = 1;
        int sc = -1;
        int fc = -1;
        for(int child: tree[src]) {
            Pair curr = path(tree, s, child);
            if(curr.val != s[src]) {
                if(curr.count > fc) {
                    sc = fc;
                    fc = curr.count;
                }
                else if(curr.count > sc) {
                    sc = curr.count;
                }
            }
            maxPath = max(maxPath, curr.maxPath);
        }
        Pair sp(s[src], 1, maxPath);
        if(fc != -1 && sc != -1) {
            sp.count = fc+1;
            sp.maxPath = max(sp.maxPath, fc+sc+1);
        }
        else if(fc != -1) {
            sp.count = fc+1;
            sp.maxPath = max(sp.maxPath, fc+1);
        }
        return sp;
    }
};