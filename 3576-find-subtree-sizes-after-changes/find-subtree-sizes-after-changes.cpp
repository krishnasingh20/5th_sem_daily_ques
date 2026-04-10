class Solution {
public:
    vector<int> ans;
    vector<int> arr;
    vector<vector<int>> adj;
    string s;
    vector<int> findSubtreeSizes(vector<int>& parent, string _s) {
        int n = parent.size();
        s = _s;

        adj.resize(n);
        ans.resize(n);
        arr.resize(26, -1);

        for(int i = 1; i < n; i++) {
            adj[parent[i]].push_back(i);
        }

        dfs1(0, parent);

        adj.clear();
        adj.resize(n);

        for(int i = 1; i < n; i++) {
            adj[parent[i]].push_back(i);
        } 

        dfs2(0);

        return ans; 
    }

    void dfs1(int src, vector<int>& parent) {
        if(arr[s[src]-'a'] != -1) {
            parent[src] = arr[s[src]-'a'];
        }

        int temp = arr[s[src]-'a'];
        arr[s[src]-'a'] = src;

        for(int nbrs: adj[src]) {
            dfs1(nbrs, parent);
        }

        arr[s[src]-'a'] = temp;
    }

    int dfs2(int src) {
        int c = 1;

        for(int nbrs: adj[src]) {
            c += dfs2(nbrs);
        }

        ans[src] = c;

        return c;
    }
};