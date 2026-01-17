class Solution {
    List<Integer>[] graph;
    int ans = Integer.MAX_VALUE;
    public int findShortestCycle(int n, int[][] edges) {
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
        Queue<Pair> q = new LinkedList<>();
        HashMap<Integer, Integer> visited = new HashMap<>();
        q.add(new Pair(src, 0));
        while(!q.isEmpty()) {
            Pair rv = q.poll();
            if(visited.containsKey(rv.vtx)) {
                ans = Math.min(ans, rv.dis+visited.get(rv.vtx));
                continue;
            }
            visited.put(rv.vtx, rv.dis);
            for(int nbrs: graph[rv.vtx]) {
                if(!visited.containsKey(nbrs)) {
                    q.add(new Pair(nbrs, rv.dis+1));
                }
            }
        }
    }
    class Pair {
        int vtx;
        int dis;
        Pair(int vtx, int dis) {
            this.vtx = vtx;
            this.dis = dis;
        }
    }
}