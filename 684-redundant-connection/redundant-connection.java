class Solution {
    
    class DSU {
        int[] parent;
        int[] size;
        int n;
        
        public DSU(int n) {
            this.n = n;
            parent = new int[n+1];
            size = new int[n+1];

            for(int i = 0; i <= n; i++) {
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

        boolean union(int a, int b) {
            int p1 = find(a);
            int p2 = find(b);

            if(p1 == p2) {
                return true;
            }

            if(size[p1] > size[p2]) {
                parent[p2] = p1;
                size[p1] += size[p2];
            }
            else {
                parent[p1] = p2;
                size[p2] += size[p1];
            }

            return false;
        }
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        DSU dsu = new DSU(n);

        for(int[] edge: edges) {
            if(dsu.union(edge[0], edge[1])) {
                return edge;
            }
        }

        return new int[]{-1, -1};
    }
}