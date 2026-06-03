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
    public void bfs(int src, int[] dist, int[] arr, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        boolean[] visited = new boolean[n];
        visited[src] = true;
        while(!q.isEmpty()) {
            int rv = q.poll();
            if(arr[rv] != -1 && !visited[arr[rv]]) {
                dist[arr[rv]] = dist[rv] + 1;
                visited[arr[rv]] = true;
                q.add(arr[rv]);
            }
        }
    }
}