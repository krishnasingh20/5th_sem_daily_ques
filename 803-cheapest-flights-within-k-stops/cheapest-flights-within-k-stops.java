class Solution {
    long[] cost;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] flight: flights) {
            graph[flight[0]].add(new int[]{flight[1], flight[2]});
        }
        Queue<Pair> q = new LinkedList<>();
        cost = new long[n];
        Arrays.fill(cost, Long.MAX_VALUE);
        cost[src] = 0;
        int ans = Integer.MAX_VALUE;
        q.add(new Pair(src, 0, 0));
        while(!q.isEmpty()) {
            Pair rv = q.poll();
            if(rv.vtx == dst) {
                ans = Math.min(ans, rv.cost);
                continue;
            }
            for(int[] nbrs: graph[rv.vtx]) {
                int newStop = rv.stop+1;
                int newCost = rv.cost+nbrs[1];
                if(nbrs[0] != dst && newStop > k || cost[nbrs[0]] <= newCost) {
                    continue;
                }
                cost[nbrs[0]] = newCost;
                q.add(new Pair(nbrs[0], newStop, newCost));
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    class Pair{
        int vtx;
        int stop;
        int cost;
        Pair(int vtx, int stop, int cost) {
            this.vtx = vtx;
            this.stop = stop;
            this.cost = cost;
        }
    }
}