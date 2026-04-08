class Solution {

    class DSU {
        int[] parent;
        int[] size;
        public DSU(int n) {
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

    public int largestIsland(int[][] grid) {
        int n = grid.length;

        DSU dsu = new DSU(n*n);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    continue;
                }

                int id1 = i*n + (j+1);

                if(j-1 >= 0 && grid[i][j-1] == 1) {
                    int id2 = i*n + j;

                    dsu.union(id1, id2);
                }

                if(i-1 >= 0 && grid[i-1][j] == 1) {
                    int id2 = (i-1)*n + (j+1);
                    
                    dsu.union(id1, id2);
                } 
            }
        }

        int ans = 0;
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    if(j-1 >= 0 && grid[i][j-1] == 1) {
                        int id = i*n + j;
                        set.add(dsu.find(id));
                    }

                    if(j+1 < n && grid[i][j+1] == 1) {
                        int id = i*n + (j+2);
                        set.add(dsu.find(id));
                    }

                    if(i-1 >= 0 && grid[i-1][j] == 1) {
                        int id = (i-1)*n + (j+1);
                        set.add(dsu.find(id));
                    }

                    if(i+1 < n && grid[i+1][j] == 1) {
                        int id = (i+1)*n + (j+1);
                        set.add(dsu.find(id));
                    }

                    int curr = 0;
                    for(int s: set) {
                        curr += dsu.size[s];
                    }

                    set.clear();
                    ans = Math.max(ans, curr+1);
                }
            }
        }

        return ans==0?(n*n):ans;
    }
}