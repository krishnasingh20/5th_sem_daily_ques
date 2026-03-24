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
        int[] left;
        int[] right;
        public DSU() {
            parent = new int[10001];
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
                parent[a] = p1;
                parent[p2] = p1;
                left[p1] = left[p1];
                right[p1] = right[p2];
                set.remove(p2);
            }
            else if(p1 != -1) {
                parent[a] = p1;
                right[p1] = a;
            }
            else if(p2 != -1) {
                parent[a] = p2;
                left[p2] = a;
            }
            else {
                set.add(a);
                parent[a] = a;
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