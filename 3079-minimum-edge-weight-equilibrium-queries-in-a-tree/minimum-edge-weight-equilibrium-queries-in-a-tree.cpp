class LCA {
    int row;
    int col;
    vector<vector<int>> ancestor;
    vector<vector<vector<int>>> adj;
public:
    vector<vector<int>> weight;

    LCA(int n, vector<vector<int>>& edges) {
        this->row = n;
        this->col = 0;
        
        while((1 << col) <= n) col++;

        ancestor.resize(n, vector<int>(col, -1));
        weight.resize(n, vector<int>(27, 0));
        adj.resize(n);

        built(edges);
        dfs(0, -1, 0, 0);
        ancestorTable();
    }

    void built(vector<vector<int>>& edges) {
        for(vector<int>& edge: edges) {
            adj[edge[0]].push_back({edge[1], edge[2]});
            adj[edge[1]].push_back({edge[0], edge[2]});
        }
    }

    void dfs(int node, int parent, int w, int depth) {

        ancestor[node][0] = parent;

        if(parent != -1) {
            for(int j = 1; j <= 26; j++) {
                weight[node][j] = weight[parent][j];
            }
            weight[node][w] += 1;
        }

        weight[node][0] = depth;

        for(vector<int>& child: adj[node]) {
            if(child[0] == parent) {
                continue;
            }
            dfs(child[0], node, child[1], depth+1);
        }
    }

    void ancestorTable() {

        for(int j = 1; j < col; j++) {
            for(int node = 0; node < row; node++) {

                if(ancestor[node][j-1] != -1) {
                    ancestor[node][j] = ancestor[ancestor[node][j-1]][j-1];
                }
            }
        }
    }

    int findAncestor(int u, int v) {
        if(weight[u][0] < weight[v][0]) {
            swap(u, v);
        }

        int diff = weight[u][0] - weight[v][0];

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
};

class Solution {
public:
    vector<int> minOperationsQueries(int n, vector<vector<int>>& edges, vector<vector<int>>& queries) {
        LCA lca(n, edges);

        int q = queries.size();
        vector<int> ans(q);

        for(int j = 0; j < q; j++) {
            int u = queries[j][0];
            int v = queries[j][1];

            int a = lca.findAncestor(u, v);

            int count = lca.weight[u][0] + lca.weight[v][0] - 2 * lca.weight[a][0];
            int maxx = 0;

            for(int i = 1; i <= 26; i++) {
                int temp = lca.weight[u][i] + lca.weight[v][i] - 2 * lca.weight[a][i];
                maxx = max(maxx, temp);
            }

            ans[j] = count - maxx;
        }

        return ans;
    }
};