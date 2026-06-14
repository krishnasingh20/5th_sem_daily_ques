class Solution {
public:
    vector<vector<int>> adj;
    vector<vector<int>> ancestor;
    vector<int> depth;
    int row;
    int col;
    int n;
    int MOD = 1000000007;
    vector<int> assignEdgeWeights(vector<vector<int>>& edges, vector<vector<int>>& queries) {
        n = edges.size()+1;
        adj.resize(n+1);
        depth.resize(n+1, 0);
        row = n;
        col = 0;

        while((1 << col) <= n) {
            col++;
        }

        ancestor.resize(row+1, vector<int>(col, -1));

        for(vector<int>& edge: edges) {
            adj[edge[0]].push_back(edge[1]);
            adj[edge[1]].push_back(edge[0]);
        }

        // depth
        dfs(1, -1);

        //ancestor table
        for(int j = 1; j < col; j++) {
            for(int node = 1; node <= row; node++) {
                if(ancestor[node][j-1] != -1) {
                    ancestor[node][j] = ancestor[ancestor[node][j-1]][j-1];
                }
            }
        }

        vector<int> ans;

        for(vector<int>& query: queries) {
            int u = query[0];
            int v = query[1];

            if(u == v) {
                ans.push_back(0);
                continue;
            }

            int a = LCA(u, v);
            int d = depth[u] + depth[v] - 2 * depth[a];
            int res = power(2, d-1);
            ans.push_back(res);
        }

        return ans;
    }

    void dfs(int node, int parent) {
        ancestor[node][0] = parent;

        for(int child: adj[node]) {
            if(child == parent) {
                continue;
            }

            depth[child] = depth[node] + 1;
            dfs(child, node);
        }
    }

    int LCA(int u, int v) {
        if(depth[u] < depth[v]) {
            swap(u, v);
        }

        int diff = depth[u] - depth[v];

        for(int j = 0; j < col; j++) {
            if((diff & (1 << j))) {
                u = ancestor[u][j];
            }
        }

        if(u == v) {
            return u;
        }

        for(int j = col - 1; j >= 0; j--) {
            if(ancestor[u][j] == -1 || ancestor[v][j] == -1) {
                continue;
            }

            if(ancestor[u][j] != ancestor[v][j]) {
                u = ancestor[u][j];
                v = ancestor[v][j];
            }
        }
        
        return ancestor[u][0];
    }

    long long power(int a, int b) {
        if(b == 0) {
            return 1LL;
        }

        long long half = power(a, b/2);
        long long ans = half * half % MOD;

        if((b & 1)) {
            ans = ans * a % MOD;
        }

        return ans;
    }
};