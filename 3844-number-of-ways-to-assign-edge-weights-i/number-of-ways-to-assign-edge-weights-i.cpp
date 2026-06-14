class Solution {
public:
    vector<vector<int>> adj;
    int n;
    int depth = 0;
    int MOD = 1000000007;
    int assignEdgeWeights(vector<vector<int>>& edges) {
        n = edges.size() + 1;
        adj.resize(n+1);

        for(vector<int>& edge: edges) {
            adj[edge[0]].push_back(edge[1]);
            adj[edge[1]].push_back(edge[0]);
        }

        dfs(1, 1, 0);

        return (int)power(2, depth-1);//from binomial theorem and parity identity
    }

    void dfs(int node, int parent, int curr) {
        depth = max(depth, curr);

        for(int child: adj[node]) {
            if(child == parent) {
                continue;
            }

            dfs(child, node, curr+1);
        }
    }

    long long power(int a, int b) {
        if(b == 0) {
            return 1LL;
        }

        long long half = power(a, b/2);
        long long  ans = half * half % MOD;

        if((b & 1)) {
            ans = ans * a % MOD;
        }

        return ans;
    }
};