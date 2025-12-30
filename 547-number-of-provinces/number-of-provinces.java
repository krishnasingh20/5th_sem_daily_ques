class Solution {
    public int findCircleNum(int[][] isConnected) {
        return component(isConnected);
    }
    public int component(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        int c = 0;
        for(int i = 0; i < n; i++) {
            if(visited[i]) {
                continue;
            }
            c++;
            q.add(i);
            while(!q.isEmpty()) {
                int rv = q.poll();
                if(visited[rv]) {
                    continue;
                }
                visited[rv] = true;
                for(int j = 0; j < m; j++) {
                    if(j != rv) {
                        if(!visited[j] && graph[rv][j] == 1) {
                            q.add(j);
                        }
                    }
                }
            }
        }
        return c;
    }
}