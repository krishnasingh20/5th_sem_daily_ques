class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int v = edges.length;
        DSU dsu = new DSU();
        for(int i = 1; i <= v; i++) {
            dsu.create(i);
        }
        for(int[] edge: edges) {
            if(dsu.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[]{};
    }
    class DSU{
        private HashMap<Integer, Node> map = new HashMap<>();
        class Node {
            int val;
            int rank;
            Node parent;
            public Node(int val, int rank, Node parent) {
                this.val = val;
                this.rank = rank;
                this.parent = parent;
            }
        }
        public void create(int v) {
            Node nn = new Node(v, 0, null);
            nn.parent = nn;
            map.put(v, nn);
        }
        public int find(int v) {
            Node nn = map.get(v);
            return find(nn).val;
        }
        private Node find(Node node) {
            if(node.parent == node) {
                return node;
            }
            Node nn = find(node.parent);
            node.parent = nn;
            return nn;
        }
        public boolean union(int v1, int v2) {
            Node n1 = map.get(v1);
            Node n2 = map.get(v2);
            Node r1 = find(n1);
            Node r2 = find(n2);
            if(r1 == r2) {
                return true;
            }
            else {
                if(r1.rank == r2.rank) {
                    r1.parent = r2;
                    r2.rank++;
                }
                else if(r1.rank < r2.rank) {
                    r1.parent = r2;
                }
                else {
                    r2.parent = r1;
                }
                return false;
            }
        }
    }
}