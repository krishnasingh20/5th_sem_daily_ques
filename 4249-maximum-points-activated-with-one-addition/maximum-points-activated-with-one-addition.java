class Solution {
    class DSU {
        int[] parent;
        int[] size;
        int n;

        public DSU(int n) {
            this.n = n;
            parent = new int[2*n+10];
            size = new int[2*n+10];
            for(int i = 0; i < 2*n+10; i++) {
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
    
    public int maxActivated(int[][] points) {
        int n = points.length;
        int[] temp = new int[n];

        // first we will do coordinate compression for x
        for(int i = 0; i < n; i++) {
            temp[i] = points[i][0];
        }

        Arrays.sort(temp);

        int idx1 = 0;
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

        int idx2 = 0;
        HashMap<Integer, Integer> compressY = new HashMap<>();
        compressY.put(temp[0], idx2);

        for(int i = 1; i < n; i++) {
            if(temp[i] != temp[i-1]) {
                compressY.put(temp[i], ++idx2);
            }
        }

        DSU dsu = new DSU(n);
        int offSet = n;//to avoid (x, y) overlap
        HashSet<Integer> used = new HashSet<>();

        for(int[] p: points) {
            int x = compressX.get(p[0]);
            int y = compressY.get(p[1]) + offSet;
            used.add(x);
            used.add(y);
            dsu.union(x, y);
        }
        
        HashSet<Integer> parent = new HashSet<>();//it will help to know number of component

        for(int a: used) {
            parent.add(dsu.find(a));
        }

        if(parent.size() == 1) {
            return n+1;
        }

        List<Integer> componentSize = new ArrayList<>();

        for(int p: parent) {
            componentSize.add(dsu.size[p]);
        }

        Collections.sort(componentSize);
        int m = componentSize.size();
        
        int maxPoint = componentSize.get(m-1) + componentSize.get(m-2) - 1;

        return maxPoint;
    }
}