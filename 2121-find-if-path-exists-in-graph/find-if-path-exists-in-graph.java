class Solution {
    public boolean validPath(int n, int[][] edges, int src, int des) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge: edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
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
            for(int nbrs: graph[rv]) {
                if(!visited[nbrs]) {
                    q.add(nbrs);
                }
            }
        }
        return false;
    }
}