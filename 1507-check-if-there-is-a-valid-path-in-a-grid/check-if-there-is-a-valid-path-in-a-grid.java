class Solution {
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
            if(rv[0] == m-1 && rv[1] == n-1) {
                return true;
            }
            int street = grid[rv[0]][rv[1]];
            grid[rv[0]][rv[1]] = -1;
            if(street == 1) {
                int c1 = rv[1] - 1;
                int c2 = rv[1] + 1;
                if(c1 >= 0 && grid[rv[0]][c1] != -1) {
                    if(grid[rv[0]][c1] == 1 || grid[rv[0]][c1] == 4 || grid[rv[0]][c1] == 6) {
                        q.add(new int[]{rv[0], c1});
                    }
                }
                if(c2 < n && grid[rv[0]][c2] != -1) {
                    if(grid[rv[0]][c2] == 1 || grid[rv[0]][c2] == 3 || grid[rv[0]][c2] == 5) {
                        q.add(new int[]{rv[0], c2});
                    }
                }
            }
            else if(street == 2) {
                int r1 = rv[0]-1;
                int r2 = rv[0]+1;
                if(r1 >= 0 && grid[r1][rv[1]] != -1) {
                    if(grid[r1][rv[1]] == 2 || grid[r1][rv[1]] == 3 || grid[r1][rv[1]] == 4) {
                        q.add(new int[]{r1, rv[1]});
                    }
                }
                if(r2 < m && grid[r2][rv[1]] != -1) {
                    if(grid[r2][rv[1]] == 2 || grid[r2][rv[1]] == 5 || grid[r2][rv[1]] == 6) {
                        q.add(new int[]{r2, rv[1]});
                    }
                }
            }
            else if(street == 3) {
                int c1 = rv[1]-1;
                int r2 = rv[0]+1;
                if(c1 >= 0 && grid[rv[0]][c1] != -1) {
                    if(grid[rv[0]][c1] == 1 || grid[rv[0]][c1] == 4 || grid[rv[0]][c1] == 6) {
                        q.add(new int[]{rv[0], c1});
                    }
                }
                if(r2 < m && grid[r2][rv[1]] != -1) {
                    if(grid[r2][rv[1]] == 2 || grid[r2][rv[1]] == 5 || grid[r2][rv[1]] == 6) {
                        q.add(new int[]{r2, rv[1]});
                    }
                }
            }
            else if(street == 4) {
                int c1 = rv[1]+1;
                int r2 = rv[0]+1;
                if(c1 < n && grid[rv[0]][c1] != -1) {
                    if(grid[rv[0]][c1] == 1 || grid[rv[0]][c1] == 3 || grid[rv[0]][c1] == 5) {
                        q.add(new int[]{rv[0], c1});
                    }
                }
                if(r2 < m && grid[r2][rv[1]] != -1) {
                    if(grid[r2][rv[1]] == 2 || grid[r2][rv[1]] == 5 || grid[r2][rv[1]] == 6) {
                        q.add(new int[]{r2, rv[1]});
                    }
                }
            }
            else if(street == 5) {
                int r1 = rv[0]-1;
                int c2 = rv[1]-1;
                if(r1 >= 0 && grid[r1][rv[1]] != -1) {
                    if(grid[r1][rv[1]] == 2 || grid[r1][rv[1]] == 3 || grid[r1][rv[1]] == 4) {
                        q.add(new int[]{r1, rv[1]});
                    }
                }
                if(c2 >= 0 && grid[rv[0]][c2] != -1) {
                    if(grid[rv[0]][c2] == 1 || grid[rv[0]][c2] == 4 || grid[rv[0]][c2] == 6) {
                        q.add(new int[]{rv[0], c2});
                    }
                }
            }
            else {
                int r1 = rv[0]-1;
                int c2 = rv[1]+1;
                if(r1 >= 0 && grid[r1][rv[1]] != -1) {
                    if(grid[r1][rv[1]] == 2 || grid[r1][rv[1]] == 3 || grid[r1][rv[1]] == 4) {
                        q.add(new int[]{r1, rv[1]});
                    }
                }
                if(c2 < n && grid[rv[0]][c2] != -1) {
                    if(grid[rv[0]][c2] == 1 || grid[rv[0]][c2] == 3 || grid[rv[0]][c2] == 5) {
                        q.add(new int[]{rv[0], c2});
                    }
                }
            }
        }
        return false;
    }
}