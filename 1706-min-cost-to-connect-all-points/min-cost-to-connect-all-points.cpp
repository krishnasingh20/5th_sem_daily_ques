struct Comparator {
    static bool cmp(vector<int>& a, vector<int>& b) {
        return a[2] < b[2];
    }
};

class DSU {
    vector<int> parent, size;
public:
    DSU(int n) {
        parent.resize(n);
        size.resize(n);
        for(int i = 0; i < n; i++) {
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

    bool unite(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);

        if(p1 == p2) {
            return false;
        }

        if(size[p1] > size[p2]) {
            parent[p2] = p1;
            size[p1] += size[p2];
        }
        else {
            parent[p1] = p2;
            size[p2] += size[p1];
        }

        return true;
    }
};

class Solution {
public:
    int minCostConnectPoints(vector<vector<int>>& p) {

        int n = p.size();
        
        vector<vector<int>> edges = getAllEdges(p);

        sort(edges.begin(), edges.end(), Comparator::cmp);

        DSU dsu(n);

        int cost = 0;
        int count = 0;

        for(auto &e: edges) {
            if(dsu.unite(e[0], e[1])) {
                count++;
                cost += e[2];
            }
            if(count == n-1) {
                return cost;
            }
        }

        return cost;
    }

    vector<vector<int>> getAllEdges(vector<vector<int>>& p) {

        vector<vector<int>> edges;

        int n = p.size();

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                int curr = abs((p[i][0]-p[j][0])) + abs((p[i][1]-p[j][1]));
                vector<int> a;
                a.push_back(i);
                a.push_back(j);
                a.push_back(curr);
                edges.push_back(a);
            }
        }

        return edges;
    }
};