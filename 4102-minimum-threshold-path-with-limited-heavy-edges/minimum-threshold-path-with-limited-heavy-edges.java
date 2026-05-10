class Solution {
    public int minimumThreshold(int n, int[][] edges, int src, int des, int k) {
        int high = 0;
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] e: edges) {
            adj.get(e[0]).add(new int[]{e[1], e[2]});
            adj.get(e[1]).add(new int[]{e[0], e[2]});
            high = Math.max(high, e[2]);
        }
        high++;
        if(!pathExist(adj, src, des)) {
            return -1;
        }
        int low = 0;
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n];
        while(low <= high) {
            int mid = low + (high - low)/2;
            q.add(src);
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;
            while(!q.isEmpty()) {
                int rv = q.poll();
                for(int[] nbrs: adj.get(rv)) {
                    int curr = dist[rv];
                    if(nbrs[1] > mid) {
                        curr++;
                    }
                    if(curr > k) {
                        continue;
                    }
                    if(curr < dist[nbrs[0]]) {
                        dist[nbrs[0]] = curr;
                        q.add(nbrs[0]);
                    }
                }
            }
            if(dist[des] != Integer.MAX_VALUE) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public boolean pathExist(List<List<int[]>> adj, int src, int des) {
        int n = adj.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()) {
            int rv = q.poll();
            if(rv == des) {
                return true;
            }
            visited[rv] = true;
            for(int[] nbrs: adj.get(rv)) {
                if(!visited[nbrs[0]]) {
                    q.add(nbrs[0]);
                }
            }
        }
        return false;
    }
}