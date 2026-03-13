class Solution {
    class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int findParent(int node) {
            if(node == parent[node]) {
                return node;
            }
            return parent[node] = findParent(parent[node]);
        }

        void unionByRank(int u, int v) {
            int p1 = findParent(u);
            int p2 = findParent(v);

            if(p1 == p2) {
                return;
            }

            if(rank[p1] < rank[p2]) {
                parent[p1] = p2;
            }
            else if(rank[p1] > rank[p2]) {
                parent[p2] = p1;
            }
            else {
                parent[p1] = p2;
                rank[p2]++;
            }
        }
    }
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        
        Arrays.sort(edgeList, (a, b)->a[2]-b[2]);

        int q = queries.length;
        int[][] arr = new int[q][4];

        for(int i = 0; i < q; i++) {
            arr[i][0] = queries[i][0];
            arr[i][1] = queries[i][1];
            arr[i][2] = queries[i][2];
            arr[i][3] = i;
        }

        Arrays.sort(arr, (a, b)->a[2]-b[2]);

        boolean[] ans = new boolean[q];

        DSU dsu = new DSU(n);

        int j = 0;

        for(int i = 0; i < q; i++) {

            while(j < edgeList.length && edgeList[j][2] < arr[i][2]) {
                dsu.unionByRank(edgeList[j][0], edgeList[j][1]);
                j++;
            }

            int p1 = dsu.findParent(arr[i][0]);
            int p2 = dsu.findParent(arr[i][1]);

            if(p1 == p2) {
                ans[arr[i][3]] = true;
            }
        }

        return ans;
    }
}