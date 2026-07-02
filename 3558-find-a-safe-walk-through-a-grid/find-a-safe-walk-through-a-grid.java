class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int[][] healthLeft = new int[m][n];

        for(int[] h: healthLeft) {
            Arrays.fill(h, Integer.MIN_VALUE);
        }
        healthLeft[0][0] = health - grid.get(0).get(0);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[2], a[2]));
        pq.add(new int[]{0, 0, healthLeft[0][0]});

        while(!pq.isEmpty()) {
            int[] rv = pq.poll();

            if(rv[0] == m-1 && rv[1] == n-1) {
                if(rv[2] > 0) {
                    return true;
                }
                continue;
            }

            for(int i = 0; i < 4; i++) {
                int nX = dx[i] + rv[0];
                int nY = dy[i] + rv[1];

                if(nX < 0 || nX >= m || nY < 0 || nY >= n) {
                    continue;
                }

                int newHealth  = healthLeft[rv[0]][rv[1]] - grid.get(nX).get(nY);
                if(newHealth > healthLeft[nX][nY]) {
                    healthLeft[nX][nY] = newHealth;
                    pq.add(new int[]{nX, nY, newHealth});
                }
            }
        }

        return false;
    }
}