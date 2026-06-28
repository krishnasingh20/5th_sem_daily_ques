struct compare {
    bool operator()(vector<int>& a, vector<int>& b) {
        return a[2] > b[2];
    }
};

class Solution {
public:
    int shortestPath(int n, vector<vector<int>>& edges, string labels, int k) {
        vector<vector<vector<int>>> adj(n);
        for(vector<int>& edge: edges) {
            adj[edge[0]].push_back({edge[1], edge[2]});
        }

        priority_queue<vector<int>, vector<vector<int>>, compare> pq;
        vector<vector<bool>> visited(n, vector<bool>(k+1, false));

        pq.push({0, 1, 0});

        while(!pq.empty()) {
            auto rv = pq.top();
            pq.pop();
            if(visited[rv[0]][rv[1]]) {
                continue;
            }
            if(rv[0] == n - 1) {
                return rv[2];
            }
            visited[rv[0]][rv[1]] = true;
            for(vector<int>& nbrs: adj[rv[0]]) {
                int newWeight = rv[2] + nbrs[1];
                int cnt = (labels[rv[0]]-'a' == (labels[nbrs[0]]-'a')) ? rv[1]+1 : 1;
                if(cnt > k || visited[nbrs[0]][cnt]) {
                    continue;
                }
                pq.push({nbrs[0], cnt, newWeight});
            }
        }

        return -1;
    }
};