class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
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
                for(int j = 0; j < n; j++) {// add all unvisited neighbour
                    if(isConnected[rv][j] == 1 && !visited.contains(j)) {
                        q.add(j);
                    }
                }
            }
        }
        return provinces;
    }
}