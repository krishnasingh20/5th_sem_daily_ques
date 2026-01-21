class Solution {
    List<int[]>[] graph;
    Queue<int[]> q;
    int[] dist;
    int threshold;
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge: edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
            graph[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        int ans = 0;
        int city_reachable = Integer.MAX_VALUE;
        threshold = distanceThreshold;
        dist = new int[n];
        q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            int reachable = bfs(i);
            if(reachable < city_reachable) {
                ans = i;
                city_reachable = reachable;
            }
            else if(reachable == city_reachable) {
                ans = Math.max(ans, i);
            }
        }
        return ans;
    }
    public int bfs(int src) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        q.add(new int[]{src, 0});
        dist[src] = 0;
        int cityReachable = 0;
        while(!q.isEmpty()) {
            int[] rv = q.poll();
            for(int[] nbrs: graph[rv[0]]) {
                int newWeight = rv[1] + nbrs[1];
                if(dist[nbrs[0]] > newWeight) {
                    dist[nbrs[0]] = newWeight;
                    q.add(new int[]{nbrs[0], newWeight});
                }
            }
        }
        for(int i = 0; i < dist.length; i++) {
            if(dist[i] <= threshold) {
                cityReachable++;
            }
        }
        return cityReachable-1;
    }
}