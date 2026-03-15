class Solution {

    class DSU {
        int[] parent;
        int[] size;
        public DSU() {
            parent = new int[20010];
            size = new int[20010];
            for(int i = 0; i < 20010; i++) {
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
        }
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;
        DSU dsu = new DSU();
        int offSet = 10001;

        HashSet<Integer> used = new HashSet<>();//all unique node

        for(int i = 0; i < n; i++) {
            int r = stones[i][0];
            int c = stones[i][1] + offSet;
            used.add(r);
            used.add(c);

            dsu.union(r, c);
        }

        HashSet<Integer> parent = new HashSet<>();//size of these hashset tell number of component
        
        for(int node: used) {
            parent.add(dsu.find(node));
        }

        return n - parent.size();
    }
}