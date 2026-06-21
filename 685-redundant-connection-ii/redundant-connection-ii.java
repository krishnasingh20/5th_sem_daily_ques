class Solution {
    Queue<Integer> q = new LinkedList<>();
    HashSet<Integer>[] adj;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] inDegree = new int[n+1];
        adj = new HashSet[n+1];

        for(int i = 1; i <= n; i++) {
            adj[i] = new HashSet<>();
        }

        for(int[] edge: edges) {
            adj[edge[0]].add(edge[1]);
            inDegree[edge[1]]++;
        }

        int zero = -1;//root node
        int two = -1;

        for(int i = 1; i <= n; i++) {
            if(inDegree[i] == 0) {
                zero = i;
            }
            if(inDegree[i] == 2) {
                two = i;
            }
        }

        if(two != -1) {//node having two parent
            for(int i = n - 1; i >= 0; i--) {
                if(edges[i][1] == two) {
                    adj[edges[i][0]].remove(edges[i][1]);
                    if(validTree(zero)) {
                        return edges[i];
                    }
                    adj[edges[i][0]].add(edges[i][1]);
                }
            }
        }

        for(int i = n - 1; i >= 0; i--) {
            adj[edges[i][0]].remove(edges[i][1]);
            if(validTree(edges[i][1])) {
                return edges[i];
            }
            adj[edges[i][0]].add(edges[i][1]);
        }

        return new int[]{};
    }

    public boolean validTree(int src) {
        q.add(src);
        int count = 0;
        while(!q.isEmpty()) {
            int rv = q.poll();
            count++;
            for(int nbrs: adj[rv]) {
                q.add(nbrs);
            }
        }

        return count == adj.length - 1;
    }
}