class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for(int[] edge: edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        while(!q.isEmpty()) {
            int rv = q.poll();//remove
            if(visited.contains(rv)) {//ignore if already visited
                continue;
            }
            visited.add(rv);//marked visited
            if(rv == destination) {//self work
                return true;
            }
            for(int nbrs: map.get(rv)) {//add all unvisited neighbour
                if(!visited.contains(nbrs)) {
                    q.add(nbrs);
                }
            }
        }
        return false;
    }
}