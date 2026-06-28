class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] adj = new ArrayList[n];
        
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for(int[] edge: edges) {
            adj[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        int[][] dist = new int[n][k+1];
        for(int[] d: dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dist[0][1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.add(new int[]{0, 1, 0});

        while(!pq.isEmpty()) {
            int[] rv = pq.poll();

            if(dist[rv[0]][rv[1]] < rv[2]) {
                continue;
            }

            if(rv[0] == n - 1) {
                return rv[2];
            }

            for(int[] nbrs: adj[rv[0]]) {
                int newD = dist[rv[0]][rv[1]] + nbrs[1];
                int c = (labels.charAt(rv[0]) == labels.charAt(nbrs[0])) ? 1+rv[1] : 1;
                if(c > k || dist[nbrs[0]][c] <= newD) {
                    continue;
                }
                dist[nbrs[0]][c] = newD;
                pq.add(new int[]{nbrs[0], c, newD});
            }
        }

        return -1;
    }
}