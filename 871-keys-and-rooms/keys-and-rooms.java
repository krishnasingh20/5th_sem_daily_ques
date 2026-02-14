class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        int room = 0;
        q.add(0);
        while(!q.isEmpty()) {
            int rv = q.poll();
            if(visited[rv]) {
                continue;
            }
            visited[rv] = true;
            room++;
            List<Integer> keys = rooms.get(rv);
            for(int key: keys) {
                if(!visited[key]) {
                    q.add(key);
                }
            }
        }
        return room == n;
    }
}