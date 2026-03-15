class Solution {

    class DSU {
        int component;
        int[] parent;
        int[] size;
        int n;
        public DSU(int n) {
            this.n = n;
            component = n;
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

        void union(int a, int b) {
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
            component--;
        }

        int stoneRemove() {
            return n-component;
        }
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;
        DSU dsu = new DSU(n);
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    dsu.union(i, j);
                }
            }
        }

        return dsu.stoneRemove();
    }
}