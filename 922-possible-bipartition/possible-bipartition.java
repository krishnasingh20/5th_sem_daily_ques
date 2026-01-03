class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] dis: dislikes) {
            graph[dis[0]].add(dis[1]);
            graph[dis[1]].add(dis[0]);
        }
        int[] visited = new int[n+1];
        Arrays.fill(visited, -1);
        Queue<Pair> q = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            if(visited[i] != -1) {
                continue;
            }
            q.add(new Pair(i, 0));
            while(!q.isEmpty()) {
                Pair rv = q.poll();
                if(visited[rv.vtx] != -1) {
                    if(visited[rv.vtx] != rv.dis) {
                        return false;//odd length cycle
                    }
                    continue;
                }
                visited[rv.vtx] = rv.dis;
                for(int nbrs: graph[rv.vtx]) {
                    if(visited[nbrs] == -1) {
                        q.add(new Pair(nbrs, rv.dis+1));
                    }
                }
            }
        }
        return true;//even length cycle or no cycle
    }
    class Pair{
        int vtx;
        int dis;
        Pair(int vtx, int dis) {
            this.vtx = vtx;
            this.dis = dis;
        }
    }
}