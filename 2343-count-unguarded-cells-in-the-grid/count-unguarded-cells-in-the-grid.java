class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] mat = new int[m][n];
        for(int i = 0; i < guards.length; i++) {
            mat[guards[i][0]][guards[i][1]] = 1;
        }
        for(int i = 0; i < walls.length; i++) {
            mat[walls[i][0]][walls[i][1]] = 2;
        }
        boolean flag = false;
        // from left to right row wise
        for(int i = 0; i < m; i++) {
            flag = false;
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 1) {
                    flag = true;
                }
                else if(mat[i][j] == 2) {
                    flag = false;
                }
                else if(flag) {
                    mat[i][j] = -1;
                }
            }
        }
        // from right to left row wise
        for(int i = 0; i < m; i++) {
            flag = false;
            for(int j = n - 1; j >= 0; j--) {
                if(mat[i][j] == 1) {
                    flag = true;
                }
                else if(mat[i][j] == 2) {
                    flag = false;
                }
                else if(flag) {
                    mat[i][j] = -1;
                }
            }
        }
        //from top to bottom column wise
        for(int j = 0; j < n; j++) {
            flag = false;
            for(int i = 0; i < m; i++) {
                if(mat[i][j] == 1) {
                    flag = true;
                }
                else if(mat[i][j] == 2) {
                    flag = false;
                }
                else if(flag) {
                    mat[i][j] = -1;
                }
            }
        }
        //from bottom to top column wise
        for(int j = 0; j < n; j++) {
            flag = false;
            for(int i = m - 1; i >= 0; i--) {
                if(mat[i][j] == 1) {
                    flag = true;
                }
                else if(mat[i][j] == 2) {
                    flag = false;
                }
                else if(flag) {
                    mat[i][j] = -1;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    ans++;
                }
            }
        }

        return ans;
    }
}