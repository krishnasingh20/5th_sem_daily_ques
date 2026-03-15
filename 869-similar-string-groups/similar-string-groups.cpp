class DSU {
    vector<int> parent, size;
public:
    int group;

    DSU(int n) {
        group = n;
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

    void unionBySize(int a, int b) {
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
        group--;
    }
};

class Solution {
public:
    int numSimilarGroups(vector<string>& strs) {
        int n = strs.size();

        DSU dsu(n);

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(similar(strs[i], strs[j])) {
                    dsu.unionBySize(i, j);
                }
            }
        }

        return dsu.group;
    }

    bool similar(string& s1, string& s2) {
        int pos = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1[i] != s2[i]) {
                pos++;
            }
            if(pos > 2) {
                return false;
            }
        }
        return pos == 0 || pos == 2;
    }
};