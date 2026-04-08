class DSU {
public:
    vector<int> parent, size;

    DSU(int n) {
        parent.resize(n+1);
        size.resize(n+1);
        for(int i = 0; i < n+1; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int node) {
        if(node == parent[node]) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }

    void unite(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);

        if(p1 == p2) {
            return;
        }

        if(size[p1] > size[p2]) {
            parent[p2] = p1;
            size[p1] += size[p2];
        }
        else {
            parent[p1] = p2;
            size[p2] += size[p1];
        }
    }
};

class Solution {
public:
    int largestIsland(vector<vector<int>>& grid) {
        int n = grid.size();

        DSU dsu(n*n);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int id = (i*n)+(j+1);
                if(grid[i][j] == 0) {
                    continue;
                }
                if(j-1 >= 0 && grid[i][j-1]) {
                    dsu.unite((i*n)+(j), id);
                }

                if(i-1 >= 0 && grid[i-1][j]) {
                    dsu.unite(((i-1)*n)+(j+1), id);
                }
            }
        }

        int ans = INT_MIN;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    unordered_set<int> set;
                    if(i-1 >= 0 && grid[i-1][j]) {
                        int id = (i-1)*n + (j+1);
                        set.insert(dsu.find(id));
                    }
                    if(j-1 >= 0 && grid[i][j-1]) {
                        int id = i*n + j;
                        set.insert(dsu.find(id));
                    }
                    if(i+1 < n && grid[i+1][j]) {
                        int id = (i+1)*n + (j+1);
                        set.insert(dsu.find(id));
                    }
                    if(j+1 < n && grid[i][j+1]) {
                        int id = i*n + (j+2);
                        set.insert(dsu.find(id));
                    }

                    int curr = 0;
                    for(auto &s: set) {
                        curr += dsu.size[s];
                    }

                    ans = max(ans, curr+1);
                }
            }
        }

        if(ans == INT_MIN) {
            return n*n;
        }

        return ans;
    }
};