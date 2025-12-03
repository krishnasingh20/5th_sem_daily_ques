class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<Integer>[] adj = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] edge: edges) {
            if(bfs(edge[0], edge[1], adj)) {
                return edge;
            }
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        return new int[]{}; 
    }
    public boolean bfs(int src, int des, List<Integer>[] adj) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[adj.length];
        q.add(src);
        while(!q.isEmpty()) {
            int rv = q.poll();
            if(visited[rv]) {
                continue;
            }
            visited[rv] = true;
            if(rv == des) {
                return true;
            }
            for(int nbrs: adj[rv]) {
                if(!visited[nbrs]) {
                    q.add(nbrs);
                }
            }
        }
        return false;
    }
}