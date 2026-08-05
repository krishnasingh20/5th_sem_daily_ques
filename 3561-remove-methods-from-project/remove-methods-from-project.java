class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge: invocations) {
            adj.get(edge[0]).add(edge[1]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.add(k);
        visited[k] = true;

        while(!q.isEmpty()) {
            int rv = q.poll();

            for(int nbrs: adj.get(rv)) {
                if(!visited[nbrs]) {
                    visited[nbrs] = true;
                    q.add(nbrs);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        boolean[] visited1 = new boolean[n];
        boolean flag = false;
        
        for(int i = 0; i < n; i++) {
            if(visited1[i] || visited[i]) {
                continue;
            }
            ans.add(i);
            visited1[i] = true;
            q.add(i);
            while(!q.isEmpty()) {
                int rv = q.poll();
                for(int nbrs: adj.get(rv)) {
                    if(visited[nbrs]) {
                        flag = true;
                        break;
                    }
                    if(!visited1[nbrs]) {
                        q.add(nbrs);
                        visited1[nbrs] = true;
                        ans.add(nbrs);
                    }

                }
            }

            if(flag) {
                break;
            }
        }

        if(!flag) {
            return ans;
        }

        for(int i = 0; i < n; i++) {
            if(visited[i] || (!visited[i] && !visited1[i])) {
                ans.add(i);
            }
        }

        return ans;
    }
}