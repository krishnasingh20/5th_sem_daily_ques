class Solution {
    class DSU {
        int[] parent;
        int[] size;

        public DSU() {
            parent = new int[200010];
            size = new int[200010];
            for(int i = 0; i < 200010; i++) {
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

        int maxActive(int n) {
            int fm = -1;
            int sm = -1;
            for(int s: size) {
                if(s > fm) {
                    sm = fm;
                    fm = s;
                }
                else if(s > sm) {
                    sm = s;
                }
            }
            if(fm-1 == n) {
                return n+1;
            }
            return fm + sm - 1;
        }
    }
    
    public int maxActivated(int[][] points) {
        int n = points.length;
        int[] temp = new int[n];

        // first we will do coordinate compression for x
        for(int i = 0; i < n; i++) {
            temp[i] = points[i][0];
        }

        Arrays.sort(temp);

        int idx1 = 1;
        HashMap<Integer, Integer> compressX = new HashMap<>();
        compressX.put(temp[0], idx1);

        for(int i = 1; i < n; i++) {
            if(temp[i] != temp[i-1]) {
                compressX.put(temp[i], ++idx1);
            }
        }

        //coordinate compression for y
        for(int i = 0; i < n; i++) {
            temp[i] = points[i][1];
        }

        Arrays.sort(temp);

        int idx2 = 1;
        HashMap<Integer, Integer> compressY = new HashMap<>();
        compressY.put(temp[0], idx2);

        for(int i = 1; i < n; i++) {
            if(temp[i] != temp[i-1]) {
                compressY.put(temp[i], ++idx2);
            }
        }

        DSU dsu = new DSU();
        int offSet = 100001;//to avoid (x, y) overlap

        for(int[] p: points) {
            int x = compressX.get(p[0]);
            int y = compressY.get(p[1]) + offSet;
            dsu.union(x, y);
        }

        int max = dsu.maxActive(n);

        return max;
    }
}