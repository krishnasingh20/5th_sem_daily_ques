class Solution {
    public int minCost(int n, int[][] edges) {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        HashMap<Integer, HashMap<Integer, Integer>> map1 = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());
            map1.put(i, new HashMap<>());
        }
        for(int[] edge: edges) {
            map.get(edge[0]).put(edge[1], edge[2]);
            map1.get(edge[1]).put(edge[0], edge[2]);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->Integer.compare(a.cost, b.cost));
        boolean[] visited = new boolean[n];
        boolean[] on = new boolean[n];
        int ans = Integer.MAX_VALUE;
        pq.add(new Pair(0, 0));
        while(!pq.isEmpty()) {
            Pair rv = pq.poll();
            if(visited[rv.vtx]) {
                continue;
            }
            visited[rv.vtx] = true;
            if(rv.vtx == n-1) {
                ans = Math.min(ans, rv.cost);
                continue;
            }
            for(int nbrs: map.get(rv.vtx).keySet()) {
                if(!visited[nbrs]) {
                    int cost = map.get(rv.vtx).get(nbrs);
                    pq.add(new Pair(nbrs, rv.cost+cost));
                }
            }
            if(!on[rv.vtx]) {
                on[rv.vtx] = true;
                for(int nbrs: map1.get(rv.vtx).keySet()) {
                    if(!visited[nbrs]) {
                        int cost = 2*map1.get(rv.vtx).get(nbrs);
                        pq.add(new Pair(nbrs, rv.cost+cost));
                    }
                }
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    class Pair{
        int vtx;
        int cost;
        public Pair(int vtx, int cost) {
            this.vtx = vtx;
            this.cost = cost;
        }
    }
}