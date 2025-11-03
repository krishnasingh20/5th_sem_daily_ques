class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<BipartitePair> q = new LinkedList<>();
        HashMap<Integer, Integer> visited = new HashMap<>();
        for(int i = 0; i < graph.length; i++) {
            if(visited.containsKey(i)) {
                continue;
            }
            q.add(new BipartitePair(i, 0));
            while(!q.isEmpty()) {
                //remove
                BipartitePair rv = q.poll();
                //ignore
                if(visited.containsKey(rv.vtx)) {
                    if(visited.get(rv.vtx) != rv.dis) {
                        return false;//odd length cycle
                    }
                    continue;
                }
                //visited
                visited.put(rv.vtx, rv.dis);
                //selfwork
                //add all unvisited neighbour
                for(int nbrs: graph[rv.vtx]) {
                    if(!visited.containsKey(nbrs)) {
                        q.add(new BipartitePair(nbrs, rv.dis + 1));
                    }
                }
            }
        }
        return true;//even length cycle or no cycle case
    }
    class BipartitePair {
        int vtx;
        int dis;
        public BipartitePair(int vtx, int dis) {
            this.vtx = vtx;
            this.dis = dis;
        }
    }
}