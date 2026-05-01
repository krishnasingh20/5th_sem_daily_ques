class Solution {
public:
    vector<vector<int>> colorGrid(int n, int m, vector<vector<int>>& sources) {
        vector<vector<int>> time(n, vector<int>(m, INT_MAX));
        vector<vector<int>> color(n, vector<int>(m));
        queue<pair<int, int>> q;

        for(auto &s: sources) {
            color[s[0]][s[1]] = s[2];
            time[s[0]][s[1]] = 0;
            q.push({s[0], s[1]});
        }

        int dx[4] = {0, 0, -1, 1};
        int dy[4] = {-1, 1, 0, 0};

        while(!q.empty()) {
            auto rv = q.front();
            q.pop();

            int t = time[rv.first][rv.second] + 1;
            for(int i = 0; i < 4; i++) {
                int nx = rv.first + dx[i];
                int ny = rv.second + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(t == time[nx][ny]) {
                        color[nx][ny] = max(color[nx][ny], color[rv.first][rv.second]);
                    }
                    else if(t < time[nx][ny]) {
                        time[nx][ny] = t;
                        color[nx][ny] = color[rv.first][rv.second];
                        q.push({nx, ny});
                    }
                }
            }
        }

        return color;
    }
};