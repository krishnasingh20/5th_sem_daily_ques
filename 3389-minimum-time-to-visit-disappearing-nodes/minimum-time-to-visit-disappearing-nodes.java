class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<int[]>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge: edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
            graph[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->a.cost-b.cost);
        pq.add(new Pair(0, 0));
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        while(!pq.isEmpty()) {
            Pair rv = pq.poll();
            if(rv.cost >=  disappear[rv.vtx] || ans[rv.vtx] != Integer.MAX_VALUE) {
                if(ans[rv.vtx] == Integer.MAX_VALUE) {
                    ans[rv.vtx] = -1;
                }
                continue;
            }
            ans[rv.vtx] = rv.cost;
            for(int[] nbrs: graph[rv.vtx]) {
                if(ans[nbrs[0]] == Integer.MAX_VALUE) {
                    pq.add(new Pair(nbrs[0], nbrs[1]+rv.cost));
                }
            }
        }
        for(int i = 0; i < n; i++) {
            if(ans[i] == Integer.MAX_VALUE) {
                ans[i] = -1;
            }
        }
        return ans;
    }
    class Pair {
        int vtx;
        int cost;
        Pair(int vtx, int cost) {
            this.vtx = vtx;
            this.cost = cost;
        }
    }
}