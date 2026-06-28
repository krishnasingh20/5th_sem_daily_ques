class Solution {
    public long[] minTimeMaxPower(int n, int[][] edges, int power, int[] cost, int src, int des) {
        List<int[]>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] edge: edges) {
            adj[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        long[][] time = new long[n][power+1];
        for(long[] t: time) {
            Arrays.fill(t, Long.MAX_VALUE);
        }
        time[src][power] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[2], b[2]));
        pq.add(new long[]{src, power, 0L});

        while(!pq.isEmpty()) {
            long[] rv = pq.poll();

            int vtx = (int)rv[0];
            int p = (int)rv[1];
            long t = rv[2];

            if(t > time[vtx][p]) {
                continue;
            }

            if(p < cost[vtx]) {
                continue;
            }

            for(int[] nbrs: adj[vtx]) {
                long newTime = t + nbrs[1];
                int newPower = p - cost[vtx];
                if(time[nbrs[0]][newPower] <= newTime) {
                    continue;
                }
                time[nbrs[0]][newPower] = newTime;
                pq.add(new long[]{nbrs[0], newPower, newTime});
            }
        }

        long t = Long.MAX_VALUE;
        long p = -1;
        
        for(int i = 0; i <= power; i++) {
            if(time[des][i] < t) {
                t = time[des][i];
                p = i;
            }
            else if(time[des][i] == t) {
                p = i;
            }
        }

        if(t == Long.MAX_VALUE) {
            return new long[]{-1, -1};
        }

        return new long[]{t, p};
    }
}