class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge: edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        for(int res: restricted) {
            visited[res] = true;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        int node = 0;
        while(!q.isEmpty()) {
            int rv = q.poll();
            node++;
            for(int nbrs: graph[rv]) {
                if(!visited[nbrs]) {
                    visited[nbrs] = true;
                    q.add(nbrs);
                }
            }
        }
        return node;
    }
}