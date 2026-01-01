class Solution {
    Long[] dp;
    public int countRestrictedPaths(int n, int[][] edges) {
        dp = new Long[n];
        List<int[]>[] graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge: edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
            graph[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->a.cost-b.cost);
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new Pair(n, 0));
        while(!pq.isEmpty()) {
            Pair rv = pq.poll();
            if(dist[rv.vtx] != Integer.MAX_VALUE) {
                continue;
            }
            dist[rv.vtx] = rv.cost;
            for(int[] nbrs: graph[rv.vtx]) {
                int nbr = nbrs[0];
                if(dist[nbr] == Integer.MAX_VALUE) {
                    pq.add(new Pair(nbr, nbrs[1]+rv.cost));
                }
            }
        }
        long restricted = dfs(graph, new boolean[n+1], 1, dist);
        return (int)(restricted % 1000000007);
    }
    public long dfs(List<int[]>[] graph, boolean[] visited, int src, int[] dist) {
        if(src == graph.length - 1) {
            return 1;
        }
        if(dp[src] != null) {
            return dp[src];
        }
        visited[src] = true;
        long ans = 0;
        for(int[] nbrs: graph[src]) {
            if(!visited[nbrs[0]]&& dist[src] > dist[nbrs[0]]) {
                ans = (ans + dfs(graph, visited, nbrs[0], dist)) % 1000000007;
            }
        }
        visited[src] = false;
        return dp[src] = ans;
    }
    class Pair{
        int vtx;
        int cost;
        public Pair(int vtx, int cost) {
            this.vtx = vtx;
            this.cost = cost;
        }
    }
}