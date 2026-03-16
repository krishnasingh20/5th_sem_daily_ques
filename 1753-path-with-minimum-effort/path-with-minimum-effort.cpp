const int dx[4] = {-1,1,0,0};
const int dy[4] = {0,0,-1,1};

class Solution {
public:
    int minimumEffortPath(vector<vector<int>>& heights) {
        int m = heights.size();
        int n = heights[0].size();
        
        vector<vector<int>> effort(m, vector<int>(n, INT_MAX));
        effort[0][0] = 0;
        
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        pq.push({0,0,0});

        while(!pq.empty()) {
            auto rv = pq.top();
            pq.pop();

            if(rv[1] == m-1 && rv[2] == n-1) {
                continue;
            }

            for(int i = 0; i < 4; i++) {
                int newX = rv[1] + dx[i];
                int newY = rv[2] + dy[i];

                if(newX < 0 || newX >= m || newY < 0 || newY >= n) {
                    continue;
                }

                int e = max(abs(heights[rv[1]][rv[2]] - heights[newX][newY]), effort[rv[1]][rv[2]]);
                if(e >= effort[newX][newY]) {
                    continue;
                }

                effort[newX][newY] = e;
                pq.push({e, newX, newY});
            }
        }

        return effort[m-1][n-1];
    }
};