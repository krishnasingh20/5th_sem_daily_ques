class Solution {
    class DSU {
        int n;
        int[] parent;
        int[] size;
        DSU(int n) {
            this.n = n;
            parent = new int[n];
            size = new int[n];
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

        void unite(int u, int v) {
            int p1 = find(u);
            int p2 = find(v);

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
    }
    public int countCompleteComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);

        int[] degree = new int[n];

        for(int[] edge: edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            dsu.unite(edge[0], edge[1]);
        }

        HashSet<Integer> comp = new HashSet<>();

        for(int i = 0; i < n; i++) {
            comp.add(dsu.find(i));
        }

        if(comp.size() == n) {
            return n;
        }

        int ans = 0;

        for(int p: comp) {
            if(dsu.size[p] == 1) {
                ans++;
                continue;
            }
            boolean flag = false;
            for(int i = 0; i < n; i++) {
                if(dsu.find(i) == p) {
                    if(degree[i] != dsu.size[p]-1) {
                        flag = true;
                        break;
                    }
                }
            }
            if(!flag) {
                ans++;
            }
        }

        return ans;
    }
}