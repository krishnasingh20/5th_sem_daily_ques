const int dx[4] = {0,0,-1,1};
const int dy[4] = {-1,1,0,0};

class Solution {
public:
    bool flag;
    int m;
    int n;

    int countSubIslands(vector<vector<int>>& grid1, vector<vector<int>>& grid2) {

        int ans = 0;
        m = grid1.size();
        n = grid1[0].size();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid1[i][j] == 1 && grid2[i][j] == 1) {
                    flag = true;
                    dfs(i, j, grid1, grid2);
                    if(flag) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

    void dfs(int r, int c, vector<vector<int>>& grid1, vector<vector<int>>& grid2) {

        if(flag) {
            if(grid1[r][c] == 0) {
                flag = false;
            }
        }

        grid2[r][c] = 0;

        for(int i = 0; i < 4; i++) {
            int newR = r+dx[i];
            int newC = c+dy[i];
            
            if(newR >= 0 && newR < m && newC >= 0 && newC < n && grid2[newR][newC] == 1) {
                dfs(newR, newC, grid1, grid2);
            }
        }
    }
};