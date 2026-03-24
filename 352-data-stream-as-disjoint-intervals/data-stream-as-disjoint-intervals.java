class SummaryRanges {

    DSU dsu = new DSU();

    public SummaryRanges() {
        
    }
    
    public void addNum(int value) {
        dsu.union(value);
    }
    
    public int[][] getIntervals() {
        return dsu.interval();
    }

    class DSU {
        TreeSet<Integer> set = new TreeSet<>();
        int[] parent;
        int[] size;
        int[] left;
        int[] right;
        public DSU() {
            parent = new int[10001];
            size = new int[10001];
            left = new int[10001];
            right = new int[10001];

            Arrays.fill(parent, -1);
        }

        int find(int node) {
            if(parent[node] == -1) {
                return -1;
            }
            if(node == parent[node]) {
                return node;
            }
            return parent[node] = find(parent[node]);
        }

        void union(int a) {
            if(find(a) != -1) {
                return;
            }
            int p1 = (a == 0)?-1:find(a-1);
            int p2 = (a == 10000)?-1:find(a+1);
            
            if(p1 != -1 && p2 != -1) {
                if(size[p1] > size[p2]) {
                    parent[a] = p1;
                    parent[p2] = p1;
                    size[p1] += size[p2] + 1;
                    left[p1] = left[p1];
                    right[p1] = right[p2];
                    set.remove(p2);
                }
                else {
                    parent[a] = p2;
                    parent[p1] = p2;
                    size[p2] += size[p1] + 1;
                    left[p2] = left[p1];
                    set.remove(p1);
                }
            }
            else if(p1 != -1) {
                parent[a] = p1;
                size[p1] += 1;
                right[p1] = a;
            }
            else if(p2 != -1) {
                parent[a] = p2;
                size[p2] += 1;
                left[p2] = a;
            }
            else {
                set.add(a);
                parent[a] = a;
                size[a] = 1;
                left[a] = a;
                right[a] = a;
            }
        }

        int[][] interval() {
            int[][] ans = new int[set.size()][2];
            int i = 0;
            for(int s: set) {
                ans[i++] = new int[]{left[s], right[s]};
            }
            return ans;
        }
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */