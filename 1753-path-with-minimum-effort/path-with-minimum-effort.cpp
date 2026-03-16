const int dx[4] = {-1,1,0,0};
const int dy[4] = {0,0,-1,1};

class Solution {
public:
    int minimumEffortPath(vector<vector<int>>& heights) {
        int m = heights.size();
        int n = heights[0].size();
        
        vector<vector<int>> effort(m, vector<int>(n, INT_MAX));
        effort[0][0] = 0;
        
        queue<pair<int, int>> q;
        q.push({0, 0});

        while(!q.empty()) {
            auto rv = q.front();
            int x = rv.first;
            int y = rv.second;
            q.pop();

            if(x == m-1 && y == n-1) {
                continue;
            }

            for(int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if(newX < 0 || newX >= m || newY < 0 || newY >= n) {
                    continue;
                }

                int e = max(abs(heights[x][y] - heights[newX][newY]), effort[x][y]);
                if(e >= effort[newX][newY]) {
                    continue;
                }

                effort[newX][newY] = e;
                q.push({newX, newY});
            }
        }

        return effort[m-1][n-1];
    }
};