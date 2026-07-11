class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int[] degree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] e: edges) {
            degree[e[0]]++;
            degree[e[1]]++;
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int ans = 0;

        for(int i = 0; i < n; i++) {
            if(visited[i]) {
                continue;
            }
            int edge = -1;
            boolean flag = false;
            int size = 0;
            q.add(i);
            while(!q.isEmpty()) {
                int rv = q.poll();
                if(visited[rv]) {
                    continue;
                }
                if(edge == -1) {
                    edge = degree[rv];
                }
                else {
                    if(degree[rv] != edge) {
                        flag = true;
                    }
                }
                size++;
                visited[rv] = true;
                for(int nbrs: adj.get(rv)) {
                    if(!visited[nbrs]) {
                        q.add(nbrs);
                    }
                }
            }
            if(!flag && edge == size-1) {
                ans++;
            }
        }

        return ans;
    }
}