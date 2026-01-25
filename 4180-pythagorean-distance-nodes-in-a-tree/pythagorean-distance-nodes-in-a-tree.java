class Solution {
    List<Integer>[] graph;
    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
        graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge: edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        int[] dist3 = new int[n];
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);
        Arrays.fill(dist3, -1);
        dfs(y, 0, dist2);
        dfs(x, 0, dist1);
        dfs(z, 0, dist3);
        int ans = 0;
        for(int i = 0; i < n; i++) {
            long a = dist1[i];
            long b = dist2[i];
            long c = dist3[i];
            if((a*a + b*b == c*c) || (a*a + c*c == b*b) || (b*b + c*c == a*a)) {
                ans++;
            }
        }
        return ans;
    }
    public void dfs(int src, int dis, int[] dist) {
        dist[src] = dis;
        for(int nbrs: graph[src]) {
            if(dist[nbrs] == -1) {
                dfs(nbrs, dis+1, dist);
            }
        }
    }
}