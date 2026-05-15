class Solution {
    int[] ans;
    List<int[]>[] adj;
    Queue<Integer> q = new LinkedList<>();
    public int[] minCost(int n, int[] prices, int[][] roads) {
        ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        adj = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] r: roads) {
            adj[r[0]].add(new int[]{r[1], r[2], r[3]});
            adj[r[1]].add(new int[]{r[0], r[2], r[3]});
        }
        for(int i = 0; i < n; i++) {
            find(i, n, prices);
        }
        return ans;
    }
    private void find(int src, int n, int[] prices) {
        long[] dist1 = new long[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        dist1[src] = 0;
        q.add(src);
        while(!q.isEmpty()) {
            int rv = q.poll();
            for(int[] nbrs: adj[rv]) {
                long dis = dist1[rv] + nbrs[1];
                if(dis < dist1[nbrs[0]]) {
                    dist1[nbrs[0]] = dis;
                    q.add(nbrs[0]);
                } 
            }
        }

        long[] dist2 = new long[n];
        Arrays.fill(dist2, Integer.MAX_VALUE);
        dist2[src] = prices[src];
        q.add(src);
        while(!q.isEmpty()) {
            int rv = q.poll();
            for(int[] nbrs: adj[rv]) {
                long dis = dist2[rv] + (long)nbrs[1]*nbrs[2];
                if(dis < dist2[nbrs[0]]) {
                    dist2[nbrs[0]] = dis;
                    q.add(nbrs[0]);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            ans[i] = (int)Math.min(ans[i], dist1[i]+dist2[i]);
        }
    }
}