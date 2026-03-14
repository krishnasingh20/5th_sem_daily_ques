class DSU {
public:
    vector<int> parent, size, minDis;
    DSU(int n) {
        parent.resize(n+1);
        size.resize(n+1);
        minDis.resize(n+1);
        
        for(int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
            minDis[i] = INT_MAX;
        }
    }

    int findParent(int node) {
        if(node == parent[node]) {
            return node;
        }
        return parent[node] = findParent(parent[node]);
    }

    void unionBySize(int u, int v, int d) {
        int p1 = findParent(u);
        int p2 = findParent(v);

        if(p1 == p2) {
            minDis[p1] = min(minDis[p1], d);
            return;
        }
        if(size[p1] < size[p2]) {
            parent[p1] = p2;
            size[p2] += size[p1];
            minDis[p2] = min(minDis[p1], min(minDis[p2], d));
        }
        else {
            parent[p2] = p1;
            size[p1] += size[p2];
            minDis[p1] = min(minDis[p1], min(minDis[p2], d));
        }
    }
};

class Solution {
public:
    int minScore(int n, vector<vector<int>>& roads) {
        
        DSU dsu(n);

        for(auto &road: roads) {
            dsu.unionBySize(road[0], road[1], road[2]);
        }

        int p1 = dsu.findParent(1);

        return dsu.minDis[p1];
    }
};