const int dx[4] = {0,0,-1,1};
const int dy[4] = {-1,1,0,0};

class Solution {
public:
    int minR;
    int minC;
    int maxR;
    int maxC;
    int m;
    int n;

    vector<vector<int>> findFarmland(vector<vector<int>>& land) {

        vector<vector<int>> ans;
        m = land.size();
        n = land[0].size();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(land[i][j] == 1) {
                    minR = INT_MAX;
                    minC = INT_MAX;
                    maxR = INT_MIN;
                    maxC = INT_MIN;
                    dfs(i, j, land);
                    ans.push_back({minR, minC, maxR, maxC});
                }
            }
        }

        return ans;
    }

    void dfs(int r, int c, vector<vector<int>>& land) {
        minR = min(minR, r);
        minC = min(minC, c);
        maxR = max(maxR, r);
        maxC = max(maxC, c);

        land[r][c] = 0;

        for(int i = 0; i < 4; i++) {
            int newR = r+dx[i];
            int newC = c+dy[i];
            
            if(newR >= 0 && newC >= 0 && newR < m && newC < n && land[newR][newC] == 1) {
                dfs(newR, newC, land);
            }
        }
    } 
};