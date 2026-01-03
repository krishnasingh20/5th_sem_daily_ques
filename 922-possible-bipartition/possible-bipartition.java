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
        HashMap<Integer, Integer> visited = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            if(visited.containsKey(i)) {
                continue;
            }
            q.add(new Pair(i, 0));
            while(!q.isEmpty()) {
                Pair rv = q.poll();
                if(visited.containsKey(rv.vtx)) {
                    if(visited.get(rv.vtx) != rv.dis) {
                        return false;//odd length cycle
                    }
                }
                visited.put(rv.vtx, rv.dis);
                for(int nbrs: graph[rv.vtx]) {
                    if(!visited.containsKey(nbrs)) {
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