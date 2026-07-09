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
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        DSU dsu = new DSU(n);

        for(int i = 1; i < n; i++) {
            if(nums[i]-nums[i-1] <= maxDiff) {
                dsu.unite(i, i-1);
            }
        }

        boolean[] ans = new boolean[queries.length];

        for(int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            if(dsu.find(u) == dsu.find(v)) {
                ans[i] = true;
            }
        }

        return ans;
    }
}