class Solution {
    public int minCostConnectPoints(int[][] points) {
        int ans = 0;
        int n = points.length;
        int[] visited = new int[n];

        Arrays.fill(visited, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->Integer.compare(a[1], b[1]));

        pq.add(new int[]{0, 0});

        while(!pq.isEmpty()) {
            int[] rv = pq.poll();
            if(visited[rv[0]] != Integer.MAX_VALUE) {
                continue;
            }
            visited[rv[0]] = rv[1];
            ans += rv[1];

            for(int i = 0; i < n; i++) {
                if(visited[i] == Integer.MAX_VALUE) {
                    int cost = Math.abs(points[rv[0]][0] - points[i][0]) + Math.abs(points[rv[0]][1] - points[i][1]);
                    pq.add(new int[]{i, cost});
                }
            }
        }

        return ans;
    }
}