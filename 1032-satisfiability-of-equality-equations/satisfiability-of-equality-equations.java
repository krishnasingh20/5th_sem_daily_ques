class Solution {
    public boolean equationsPossible(String[] equations) {
        DSU dsu = new DSU();
        for(int i = 0; i < 26; i++) {
            dsu.create((char)(i+'a'));
        }
        for(String eqn: equations) {
            dsu.union(eqn);
        }
        for(String s: equations) {
            char c1 = s.charAt(0);
            char c2 = s.charAt(3);
            int val = s.charAt(1)=='='?1:0;
            char r1 = dsu.find(c1);
            char r2 = dsu.find(c2);
            if(val == 1) {
                if(r1 != r2) {
                    return false;
                }
            }
            else {
                if(r1 == r2) {
                    return false;
                }
            }
        }
        return true;
    }
    class DSU{
        class Node{
            char vtx;
            Node parent;
        }
        HashMap<Character, Node> map = new HashMap<>();
        public void create(char v) {
            Node nn = new Node();
            nn.vtx = v;
            nn.parent = nn;
            map.put(v, nn);
        }
        public char find(char v) {
            Node nn = map.get(v);
            return find(nn).vtx;
        }
        public Node find(Node node) {
            if(node == node.parent) {
                return node;
            }
            Node nn = find(node.parent);
            node.parent = nn;
            return nn;
        }
        public void union(String s) {
            char c1 = s.charAt(0);
            char c2 = s.charAt(3);
            int val = s.charAt(1)=='='?1:0;
            Node n1 = map.get(c1);
            Node n2 = map.get(c2);
            Node r1 = find(n1);
            Node r2 = find(n2);
            if(val == 1) {
                if(r1 != r2) {
                    r1.parent = r2;
                }
            }
        }
    }
}