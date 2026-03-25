struct Comparator {
    static bool cmp(vector<int>& a, vector<int>& b) {
        return a[2] < b[2];
    }
};

class DSU {
    vector<int> parent, size, count;
    vector<int>& mx;
public:
    DSU(int n, vector<int>& arr) :mx(arr) {
        parent.resize(n);
        size.resize(n);
        count.resize(n);
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
            count[i] = 1;
        }
    }

    int find(int node) {
        if(node == parent[node]) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }

    int unite(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);

        if(p1 == p2) {
            return 0;
        }

        int val = max(mx[p1], mx[p2]);
        int c = 0;
        int ans = 0;

        if(mx[p1] == mx[p2]) {
            ans += (count[p1]*count[p2]);
            c = count[p1] + count[p2];
        }
        else {
            if(mx[p1] == val) {
                c = count[p1];
                mx[p2] = val;
            }
            else {
                c = count[p2];
                mx[p1] = val;
            }
        }

        if(size[p1] > size[p2]) {
            parent[p2] = p1;
            size[p1] += size[p2];
            count[p1] = c;
        }
        else {
            parent[p1] = p2;
            size[p2] += size[p1];
            count[p2] = c;
        }

        return ans;
    }
};

class Solution {
public:
    int numberOfGoodPaths(vector<int>& vals, vector<vector<int>>& edges) {
        int n = vals.size();

        DSU dsu(n, vals);

        for(int i = 0; i < n-1; i++) {
            int mx = max(vals[edges[i][0]], vals[edges[i][1]]);
            edges[i].push_back(mx);
        }

        sort(edges.begin(), edges.end(), Comparator::cmp);

        int ans = n;//all single node will form good path

        for(auto &e: edges) {
            ans += dsu.unite(e[0], e[1]);
        }

        return ans;
    }
};