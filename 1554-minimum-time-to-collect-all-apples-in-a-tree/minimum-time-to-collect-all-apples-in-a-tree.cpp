class Solution {
public:
    int minTime(int n, vector<vector<int>>& edges, vector<bool>& hasApple) {
        vector<vector<int>> tree(n);

        for(int i = 0; i < edges.size(); i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            tree[u].push_back(v);
            tree[v].push_back(u);
        }

        vector<bool> visited(n, false);

        int time = dfs(0, tree, visited, hasApple);
        
        return max(0, time-2);
    }

    int dfs(int src, vector<vector<int>>& tree, vector<bool>& visited, vector<bool>& hasApple) {
        visited[src] = true;
        int time = 0;

        for(int child: tree[src]) {
            if(!visited[child]) {
                time += dfs(child, tree, visited, hasApple);
            }
        }

        if(time > 0 || hasApple[src]) {
            time += 2;
        }

        return time;
    }
};