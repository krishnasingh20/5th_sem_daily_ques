class Solution {
    List<Integer>[] graph;
    int ans = Integer.MAX_VALUE;
    int n1;
    public int findShortestCycle(int n, int[][] edges) {
        n1 = n;
        graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge: edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        for(int i = 0; i < n; i++) {
            if(graph[i].size() < 2) {
                continue;
            }
            bfs(i);
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public void bfs(int src) {
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[n1][2];
        q.add(new int[]{src, 0});
        while(!q.isEmpty()) {
            int[] rv = q.poll();
            if(visited[rv[0]][1] == 1) {
                ans = Math.min(ans, visited[rv[0]][0]+rv[1]);
                continue;
            }
            visited[rv[0]][0] = rv[1];
            visited[rv[0]][1] = 1;
            for(int nbrs: graph[rv[0]]) {
                if(visited[nbrs][1] == 0) {
                    q.add(new int[]{nbrs, rv[1]+1});
                }
            }
        }
    }
}