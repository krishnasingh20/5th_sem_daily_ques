class Solution {
    List<Integer>[] graph;
    int[] dist;
    long ans = Long.MIN_VALUE;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = edges.length+1;
        graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge: edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        dist = new int[n];
        Arrays.fill(dist, -1);
        dist[bob] = 0;
        amount[bob] = 0;
        bobPath(bob, 0, new boolean[n]);
        dfs(0, 0, amount[0], amount, new boolean[n]);
        return (int)ans; 
    }
    public void dfs(int src, int dis, long curr, int[] amount, boolean[] visited) {
        if(graph[src].size() == 1 && src != 0) {
            ans = Math.max(ans, curr);
            return;
        }
        visited[src] = true;
        for(int nbrs: graph[src]) {
            if(!visited[nbrs]) {
                int temp = 0;
                if(dist[nbrs] == -1) {
                    temp = amount[nbrs];
                }
                else if(dist[nbrs] == dis+1) {
                    temp = amount[nbrs]/2;
                }
                else if(dist[nbrs] > dis+1) {
                    temp = amount[nbrs];
                }
                dfs(nbrs, dis+1, curr+temp, amount, visited);
            }
        }
        visited[src] = false;
    }
    public boolean bobPath(int src, int dis, boolean[] visited) {
        if(src == 0) {
            return true;
        }
        visited[src] = true;
        for(int nbrs: graph[src]) {
            if(!visited[nbrs]) {
                dist[nbrs] = dis+1;
                if(bobPath(nbrs, dis+1, visited)) {
                    return true;
                }
                dist[nbrs] = -1;
            }
        }
        return false;
    }
}