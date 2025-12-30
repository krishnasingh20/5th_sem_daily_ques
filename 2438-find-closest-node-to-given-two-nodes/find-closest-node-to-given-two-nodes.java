class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node1, 0));
        while(!q.isEmpty()) {
            Pair rv = q.poll();
            if(dist1[rv.vtx] != Integer.MAX_VALUE) {
                dist1[rv.vtx] = Math.min(dist1[rv.vtx], rv.dis);
                continue;
            }
            dist1[rv.vtx] = rv.dis;
            if(edges[rv.vtx] != -1) {
                q.add(new Pair(edges[rv.vtx], rv.dis+1));
            }
        }
        q.add(new Pair(node2, 0));
        while(!q.isEmpty()) {
            Pair rv = q.poll();
            if(dist2[rv.vtx] != Integer.MAX_VALUE) {
                dist2[rv.vtx] = Math.min(dist2[rv.vtx], rv.dis);
                continue;
            }
            dist2[rv.vtx] = rv.dis;
            if(edges[rv.vtx] != -1) {
                q.add(new Pair(edges[rv.vtx], rv.dis+1));
            }
        }
        int ans = Integer.MAX_VALUE;
        int idx = -1;
        for(int i = 0; i < n; i++) {
            if(dist1[i] != Integer.MAX_VALUE && dist2[i] != Integer.MAX_VALUE) {
                int max = Math.max(dist1[i], dist2[i]);
                if(ans > max) {
                    idx = i;
                    ans = max;
                }
            }
        }
        return ans==Integer.MAX_VALUE?-1:idx;
    }
    class Pair{
        int vtx;
        int dis;
        public Pair(int vtx, int dis) {
            this.vtx = vtx;
            this.dis = dis;
        }
    }
}