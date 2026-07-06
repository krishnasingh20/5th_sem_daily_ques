class Solution {
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1};
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        char[][] grid = new char[n][n];
        for(int i = 0; i < n; i++) {
            String s = board.get(i);
            for(int j = 0; j < n; j++) {
                grid[i][j] = s.charAt(j);
            }
        }
        grid[0][0] = grid[n - 1][n - 1] = '0';
        int[][] dist = new int[n][n];
        for(int[] d: dist) {
            Arrays.fill(d, Integer.MIN_VALUE);
        }
        dist[0][0] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});
        
        while(!q.isEmpty()) {
            int[] rv = q.poll();

            if(dist[rv[0]][rv[1]] != rv[2]) {
                continue;
            }

            for(int i = 0; i < 3; i++) {
                int nX = dx[i] + rv[0];
                int nY = dy[i] + rv[1];

                if(nX >= n || nY >= n || grid[nX][nY] == 'X') {
                    continue;
                }

                int newDist = dist[rv[0]][rv[1]] + (grid[nX][nY] - '0');
                if(newDist > dist[nX][nY]) {
                    dist[nX][nY] = newDist;
                    q.add(new int[]{nX, nY, newDist});
                }
            }
        }

        if(dist[n-1][n-1] == Integer.MIN_VALUE) {
            return new int[]{0, 0};
        }

        int[][][] dp2 = new int[n][n][dist[n-1][n-1]+1];
        for(int[][] d: dp2) {
            for(int[] a: d) {
                Arrays.fill(a, -1);
            }
        }
        int count = countPath(grid, n - 1, n - 1, dist[n-1][n-1], dp2);
        return new int[]{dist[n-1][n-1], count};
    }
    public int countPath(char[][] grid, int r, int c, int max, int[][][] dp) {
        if(r == 0 && c == 0) {
            if(max == 0) {
                return 1;
            }
            return 0;
        }
        if(r < 0 || c < 0 || grid[r][c] == 'X') {
            return 0;
        }
        if(dp[r][c][max] != -1) {
            return dp[r][c][max];
        }
        int val = grid[r][c] - '0';
        int up = countPath(grid, r-1, c, max - val, dp);
        int left = countPath(grid, r, c-1, max - val, dp);
        int up_left = countPath(grid, r-1, c-1, max - val, dp);
        return dp[r][c][max] = (up + left + up_left) % 1000000007;
    }
}