class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[n];
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++) {
            if(edges[i] != -1) {
                adj.get(i).add(edges[i]);
                inDegree[edges[i]]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        while(!q.isEmpty()) {
            int rv = q.poll();
            visited[rv] = true;
            count++;
            for(int nbrs: adj.get(rv)) {
                inDegree[nbrs]--;
                if(inDegree[nbrs] == 0) {
                    q.add(nbrs);
                }
            }
        }
        if(count == n) {
            return -1;
        }
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(visited[i]) {
                continue;
            }
            int cnt = 0;
            q.add(i);
            while(!q.isEmpty()) {
                int rv = q.poll();
                if(visited[rv]) {
                    continue;
                }
                visited[rv] = true;
                cnt++;
                for(int nbrs: adj.get(rv)) {
                    if(!visited[nbrs]) {
                        q.add(nbrs);
                    }
                }
            }
            ans = Math.max(ans, cnt);
        }

        return ans;
    }
}