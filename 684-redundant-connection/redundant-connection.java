class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<Integer>[] adj = new ArrayList[edges.length+1];
        for(int i = 1; i <= edges.length; i++) {
            adj[i] = new ArrayList<>();
        }
        int[] inDegree = new int[edges.length + 1];
        for(int[] edge: edges) {
            inDegree[edge[0]]++;
            inDegree[edge[1]]++;
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[edges.length+1];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < inDegree.length; i++) {
            if(inDegree[i] == 1) {
                q.add(i);
            }
        }
        while(!q.isEmpty()) {
            int rv = q.poll();
            visited[rv] = true;
            for(int nbrs: adj[rv]) {
                if(!visited[nbrs] ) {
                    inDegree[nbrs]--;
                    if(inDegree[nbrs] == 1) {
                        q.add(nbrs);
                    }
                }
            }
        }
        for(int i = edges.length - 1; i >= 0; i--) {
            if(!visited[edges[i][0]] && !visited[edges[i][1]]) {
                return edges[i];
            }
        }
        return new int[]{};
    }
}