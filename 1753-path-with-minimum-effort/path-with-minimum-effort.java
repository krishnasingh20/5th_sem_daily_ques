class Solution {
    int[][] efforts;
    int n;
    int m;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public int minimumEffortPath(int[][] heights) {
        n = heights.length;
        m = heights[0].length;
        efforts = new int[n][m];
        for(int[] e: efforts) {
            Arrays.fill(e, Integer.MAX_VALUE);
        }
        efforts[0][0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->Integer.compare(a.effort, b.effort));
        pq.add(new Pair(0,0,0));
        while(!pq.isEmpty()) {
            Pair rv = pq.poll();
            for(int i = 0; i < 4; i++) {
                int nX = rv.x + dx[i];
                int nY = rv.y + dy[i];
                if(nX < 0 || nY < 0 || nX >= n || nY >= m) {
                    continue;
                }
                int newEffort = Math.max(rv.effort, Math.abs(heights[rv.x][rv.y]-heights[nX][nY]));
                if(newEffort < efforts[nX][nY]) {
                    efforts[nX][nY] = newEffort;
                    pq.add(new Pair(nX, nY, newEffort));
                }
            }
        }
        return efforts[n-1][m-1];
    }
    class Pair {
        int x;
        int y;
        int effort;
        Pair(int x, int y, int effort) {
            this.x = x;
            this.y = y;
            this.effort = effort;
        }
    }
}