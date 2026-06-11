class Solution {
public:
    int depth = 0;
    int assignEdgeWeights(vector<vector<int>>& edges) {
        int n = edges.size()+1;
        vector<vector<int>> adj(n+1);
        vector<long long> fact(n+1);
        vector<long long> invFact(n+1);
        long long MOD = 1000000007;

        fact[0] = (long long)1;
        for(int i = 1; i <= n; i++) {
            fact[i] = fact[i-1] * i % MOD;
        }

        invFact[n] = power(fact[n], MOD-2, MOD);
        for(int i = n - 1; i >= 0; i--) {
            invFact[i] = invFact[i+1] * (i+1) % MOD;
        }

        for(vector<int> &edge: edges) {
            adj[edge[0]].push_back(edge[1]);
            adj[edge[1]].push_back(edge[0]);
        }

        //find maximum depth
        vector<bool> visited(n+1, false);
        maxDepth(1, 0, adj, visited);

        //now we have two option 1 and 2 as edge weight so we will start putting 2 from 0 to depth edge and check for odd weight cost
        long long ans = 0;

        for(int i = 0; i <= depth; i++) {
            int cost = depth + i;
            if((cost & 1)) {
                ans = (ans + (fact[depth] * invFact[i] % MOD * invFact[depth-i] % MOD)) % MOD;
            }
        }

        return (int)(ans % MOD);
    }

    void maxDepth(int src, int curr, vector<vector<int>>& adj, vector<bool>& visited) {
        visited[src] = true;

        if(curr > depth) {
            depth = curr;
        }

        for(int child: adj[src]) {
            if(!visited[child]) {
                maxDepth(child, curr+1, adj, visited);
            }
        }
    }

    long long power(long long a, long long b, long long MOD) {
        if(b == 0) {
            return 1;
        }
        long long half = power(a, b/2, MOD);
        long ans = half * half % MOD;
        if((b & 1)) {
            ans = ans * a % MOD;
        }
        return ans;
    }
};