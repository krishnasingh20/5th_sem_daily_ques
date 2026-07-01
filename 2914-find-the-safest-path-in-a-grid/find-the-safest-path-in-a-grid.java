class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();

        if(grid.get(0).get(0) == 1 || grid.get(n-1).get(n-1) == 1) {
            return 0;
        }

        int[][] manDis = new int[n][n];
        for(int[] a: manDis) {
            Arrays.fill(a, Integer.MAX_VALUE);
        }
        List<int[]> thief = new ArrayList<>();

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid.get(i).get(j) == 1) {
                    manDis[i][j] = 0;
                    q.add(new int[]{i, j, i, j});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] rv = q.poll();
            for(int i = 0; i < 4; i++) {
                int nX = dx[i] + rv[0];
                int nY = dy[i] + rv[1];
                if(nX < 0 || nX >= n || nY < 0 || nY >= n) {
                    continue;
                }
                int newDis = Math.abs(nX - rv[2]) + Math.abs(nY - rv[3]);
                if(newDis < manDis[nX][nY]) {
                    manDis[nX][nY] = newDis;
                    q.add(new int[]{nX, nY, rv[2], rv[3]});
                }
            }
        }

        int[][] dist = new int[n][n];
        for(int[] d: dist) {
            Arrays.fill(d, Integer.MIN_VALUE);
        }
        dist[0][0] = manDis[0][0];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[2], a[2]));
        pq.add(new int[]{0, 0, dist[0][0]});

        while(!pq.isEmpty()) {
            int[] rv = pq.poll();

            if(rv[0] == n-1 && rv[1] == n-1) {
                return rv[2];
            }

            for(int i = 0; i < 4; i++) {
                int nX = dx[i] + rv[0];
                int nY = dy[i] + rv[1];

                if(nX < 0 || nX >= n || nY < 0 || nY >= n) {
                    continue;
                }

                int newDis = Math.min(dist[rv[0]][rv[1]], manDis[nX][nY]);
                if(newDis > dist[nX][nY]) {
                    dist[nX][nY] = newDis;
                    pq.add(new int[]{nX, nY, newDis});
                }
            }
        }

        return -1;
    }
}