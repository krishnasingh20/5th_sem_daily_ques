class Solution {
    List<int[]>[] graph;
    long[] dist;
    int[] path;
    static int mod = 1000000007;
    public int countPaths(int n, int[][] roads) {
        graph = new ArrayList[n];
        dist = new long[n];
        path = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        path[0] = 1;
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] road: roads) {
            graph[road[0]].add(new int[]{road[1], road[2]});
            graph[road[1]].add(new int[]{road[0], road[2]});
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->Long.compare(a.time, b.time));
        pq.add(new Pair(0, 0));
        while(!pq.isEmpty()) {
            Pair rv = pq.poll();
            for(int[] nbrs: graph[rv.vtx]) {
                long newTime = rv.time+nbrs[1];
                if(newTime < dist[nbrs[0]]) {
                    dist[nbrs[0]] = newTime;
                    path[nbrs[0]] = path[rv.vtx];
                    pq.add(new Pair(nbrs[0], newTime));
                }
                else if(newTime == dist[nbrs[0]]) {
                    path[nbrs[0]] = (path[nbrs[0]]+path[rv.vtx])%mod;
                }
            }
        }
        return path[n-1];
    }
    class Pair{
        int vtx;
        long time;
        Pair(int vtx, long time) {
            this.vtx = vtx;
            this.time = time;
        }
    }
}