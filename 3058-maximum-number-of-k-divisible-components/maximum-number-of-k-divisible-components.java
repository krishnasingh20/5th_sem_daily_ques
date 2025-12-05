class Solution {
    int ans = 0;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] edge: edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        dfs(adj, 0, new boolean[n], values, k);
        return ans;
    }
    public long dfs(List<Integer>[] adj, int vtx, boolean[] visited, int[] values, int k) {
        visited[vtx] = true;
        long val = 0;
        for(int nbrs: adj[vtx]) {
            if(!visited[nbrs]) {
                val += dfs(adj, nbrs, visited, values, k);
            }
        }
        if((val + values[vtx]) % k == 0) {
            ans++;
            return 0;
        }
        return val+values[vtx];
    }
}