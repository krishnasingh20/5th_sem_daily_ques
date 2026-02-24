class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        int m = mat.size();
        int n = mat[0].size();
        int INF = INT_MAX;
        vector<vector<int>> ans(m, vector<int>(n, INF));
        queue<pair<int, int>> q;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    ans[i][j] = 0;
                    q.push({i, j});
                }
            }
        }
        vector<int> dirX = {-1, 1, 0, 0};
        vector<int> dirY = {0, 0, -1, 1};
        while(!q.empty()) {
            int x = q.front().first;
            int y = q.front().second;
            q.pop();
            for(int i = 0; i < 4; i++) {
                int newX = x+dirX[i];
                int newY = y+dirY[i];
                if(newX < 0 || newX >= m || newY < 0 || newY >= n || ans[newX][newY] < ans[x][y]+1) {
                    continue;
                }
                ans[newX][newY] = ans[x][y]+1;
                q.push({newX, newY});
            }
        }
        return ans;
    }
};