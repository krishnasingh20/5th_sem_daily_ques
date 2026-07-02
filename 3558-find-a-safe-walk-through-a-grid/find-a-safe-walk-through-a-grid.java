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

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});

        while(!q.isEmpty()) {
            int[] rv = q.poll();

            for(int i = 0; i < 4; i++) {
                int nX = dx[i] + rv[0];
                int nY = dy[i] + rv[1];

                if(nX < 0 || nX >= m || nY < 0 || nY >= n) {
                    continue;
                }

                    int newHealth  = healthLeft[rv[0]][rv[1]] - grid.get(nX).get(nY);
                if(newHealth > healthLeft[nX][nY]) {
                    healthLeft[nX][nY] = newHealth;
                    q.add(new int[]{nX, nY});
                }
            }
        }

        return healthLeft[m-1][n-1] > 0;
    }
}