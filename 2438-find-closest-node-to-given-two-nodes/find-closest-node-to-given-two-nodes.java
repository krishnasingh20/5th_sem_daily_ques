class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        dist1[node1] = 0;
        dist2[node2] = 0;
        bfs(node1, dist1, edges, n);
        bfs(node2, dist2, edges, n);
        int ans = Integer.MAX_VALUE;
        int idx = -1;
        for(int i = 0; i < n; i++) {
            if(dist1[i] == Integer.MAX_VALUE || dist2[i] == Integer.MAX_VALUE) {
                continue;
            }
            int max = Math.max(dist1[i], dist2[i]);
            if(ans > max) {
                ans = max;
                idx = i;
            }
        }
        return idx;
    }
    public void bfs(int src, int[] dist, int[] edges, int n) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));
        boolean[] visited = new boolean[n];
        visited[src] = true;
        while(!q.isEmpty()) {
            Pair rv = q.poll();
            dist[rv.vtx] = rv.dis;
            if(edges[rv.vtx] != -1 && !visited[edges[rv.vtx]]) {
                visited[rv.vtx] = true;
                q.add(new Pair(edges[rv.vtx], rv.dis+1));
            }
        }
    }
    class Pair{
        int vtx;
        int dis;
        Pair(int vtx, int dis) {
            this.vtx = vtx;
            this.dis = dis;
        }
    }
}