class Solution {
public:
    int minScore(int n, vector<vector<int>>& roads) {

        vector<vector<pair<int, int>>> tree(n+1);

        for(int i = 0; i < roads.size(); i++) {
            tree[roads[i][0]].push_back({roads[i][1], roads[i][2]});
            tree[roads[i][1]].push_back({roads[i][0], roads[i][2]});
        }

        vector<int> minDis(n+1, INT_MAX);
        queue<int> q;

        q.push(1);

        while(!q.empty()) {

            int rv = q.front();
            q.pop();

            for(pair<int, int>& p: tree[rv]) {
                int curr = min(minDis[rv], p.second);

                if(curr < minDis[p.first]) {
                    minDis[p.first] = curr;
                    q.push(p.first);
                }
            }
        }

        return minDis[n];
    }
};