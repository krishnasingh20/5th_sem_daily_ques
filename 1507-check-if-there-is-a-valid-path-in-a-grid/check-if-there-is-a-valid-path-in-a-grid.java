class Solution {
    static int[][][] dir = {{{0,-1},{0, 1}},{{-1, 0},{1, 0}},{{0, -1},{1, 0}},{{0, 1},{1, 0}},{{-1, 0},{0, -1}},{{-1, 0},{0, 1}}};
    public boolean hasValidPath(int[][] grid) {
        return bfs(grid);
    }
    public boolean bfs(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        while(!q.isEmpty()) {
            int[] rv = q.poll();
            if(grid[rv[0]][rv[1]] == -1) {
                continue;
            }
            if(rv[0] == m-1 && rv[1] == n-1) {
                return true;
            }
            int street = grid[rv[0]][rv[1]];
            grid[rv[0]][rv[1]] = -1;
            // first
            int r1 = dir[street-1][0][0]+rv[0];
            int c1 = dir[street-1][0][1]+rv[1];
            if(r1 >= 0 && r1 < m && c1 >= 0 && c1 < n && grid[r1][c1] != -1) {
                if(street == 1) {
                    if(grid[r1][c1] == 1 || grid[r1][c1] == 4 || grid[r1][c1] == 6) {
                        q.add(new int[]{r1, c1});
                    }
                }
                else if(street == 2) {
                    if(grid[r1][c1] == 2 || grid[r1][c1] == 3 || grid[r1][c1] == 4) {
                        q.add(new int[]{r1, c1});
                    }
                }
                else if(street == 3) {
                    if(grid[r1][c1] == 1 || grid[r1][c1] == 4 || grid[r1][c1] == 6) {
                        q.add(new int[]{r1, c1});
                    }
                }
                else if(street == 4) {
                    if(grid[r1][c1] == 1 || grid[r1][c1] == 3 || grid[r1][c1] == 5) {
                        q.add(new int[]{r1, c1});
                    }
                }
                else if(street == 5) {
                    if(grid[r1][c1] == 2 || grid[r1][c1] == 3 || grid[r1][c1] == 4) {
                        q.add(new int[]{r1, c1});
                    }
                }
                else {
                    if(grid[r1][c1] == 2 || grid[r1][c1] == 3 || grid[r1][c1] == 4) {
                        q.add(new int[]{r1, c1});
                    }
                }
            }
            // second
            int r2 = dir[street-1][1][0]+rv[0];
            int c2 = dir[street-1][1][1]+rv[1];
            if(r2 >= 0 && r2 < m && c2 >= 0 && c2 < n && grid[r2][c2] != -1) {
                if(street == 1) {
                    if(grid[r2][c2] == 1 || grid[r2][c2] == 3 || grid[r2][c2] == 5) {
                        q.add(new int[]{r2, c2});
                    }
                }
                else if(street == 2) {
                    if(grid[r2][c2] == 2 || grid[r2][c2] == 5 || grid[r2][c2] == 6) {
                        q.add(new int[]{r2, c2});
                    }
                }
                else if(street == 3) {
                    if(grid[r2][c2] == 2 || grid[r2][c2] == 5 || grid[r2][c2] == 6) {
                        q.add(new int[]{r2, c2});
                    }
                }
                else if(street == 4) {
                    if(grid[r2][c2] == 2 || grid[r2][c2] == 5 || grid[r2][c2] == 6) {
                        q.add(new int[]{r2, c2});
                    }
                }
                else if(street == 5) {
                    if(grid[r2][c2] == 1 || grid[r2][c2] == 4 || grid[r2][c2] == 6) {
                        q.add(new int[]{r2, c2});
                    }
                }
                else {
                    if(grid[r2][c2] == 1 || grid[r2][c2] == 3 || grid[r2][c2] == 5) {
                        q.add(new int[]{r2, c2});
                    }
                }
            }
        }
        return false;
    }
}