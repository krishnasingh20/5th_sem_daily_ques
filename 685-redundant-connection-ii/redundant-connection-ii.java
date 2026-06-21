class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        HashSet<Integer>[] adj = new HashSet[n+1];

        for(int i = 0; i <= n; i++) {
            adj[i] = new HashSet<>();
        }

        for(int[] edge: edges) {
            adj[edge[0]].add(edge[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        int[] inDegree = new int[n+1];

        for(int i = n - 1; i >= 0; i--) {

            for(int[] edge: edges) {
                inDegree[edge[1]]++;
            }

            adj[edges[i][0]].remove(edges[i][1]);
            inDegree[edges[i][1]]--;

            for(int j = 1; j <= n; j++) {
                if(inDegree[j] == 0) {
                    q.add(j);
                }
            }

            if(q.size() > 1) {
                Arrays.fill(inDegree, 0);
                adj[edges[i][0]].add(edges[i][1]);
                q.clear();
                continue;
            }

            int count = 0;
            while(!q.isEmpty()) {
                int rv = q.poll();
                count++;
                for(int nbrs: adj[rv]) {
                    if(--inDegree[nbrs] == 0) {
                        q.add(nbrs);
                    }
                }
            }

            if(count == n) {
                return edges[i];
            }

            Arrays.fill(inDegree, 0);
            adj[edges[i][0]].add(edges[i][1]);

        }

        return new int[]{};
    }
}