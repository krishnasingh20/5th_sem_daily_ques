class Solution {
    public int findCircleNum(int[][] isConnected) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int n = isConnected.length;
        for(int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(isConnected[i][j] == 1 && i != j) {
                    map.get(i).add(j);
                }
            }
        }
        int provinces = 0;
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(visited.contains(i)) {
                continue;
            }
            q.add(i);
            provinces++;
            while(!q.isEmpty()) {
                int rv = q.poll();//remove
                if(visited.contains(rv)) {//ignore if already visited
                    continue;
                }
                visited.add(rv);//marked visited
                // self work - nothing to do these time
                for(int nbrs: map.get(rv)) {//add all unvisited neighbour
                    if(!visited.contains(nbrs)) {
                        q.add(nbrs);
                    }
                }
            }
        }
        return provinces;
    }
}