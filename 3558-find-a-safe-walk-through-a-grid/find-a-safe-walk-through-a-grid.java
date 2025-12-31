class Solution {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->a.cost-b.cost);
        pq.add(new Pair(0, 0, grid.get(0).get(0)));
        boolean[][] visited = new boolean[m][n];
        while(!pq.isEmpty()) {
            Pair rv = pq.poll();
            if(visited[rv.x][rv.y]) {
                continue;
            }
            visited[rv.x][rv.y] = true;
            if(rv.x == m-1 && rv.y == n-1) {
                if(health-rv.cost >= 1) {
                    return true;
                }
                continue;
            }
            for(int i = 0; i < 4; i++) {
                int nx = rv.x+dx[i];
                int ny = rv.y+dy[i];
                if(nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny]) {
                    pq.add(new Pair(nx, ny, rv.cost+grid.get(nx).get(ny)));
                }
            }
        }
        return false;
    }
    class Pair{
        int x;
        int y;
        int cost;
        public Pair(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}