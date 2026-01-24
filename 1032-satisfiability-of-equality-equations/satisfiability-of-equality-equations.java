class Solution {
    public boolean equationsPossible(String[] equations) {
        DSU dsu = new DSU();
        for(int i = 0; i < 26; i++) {
            dsu.create((char)(i+'a'));
        }
        for(String eqn: equations) {
            if(eqn.charAt(1) != '!') {
                dsu.union(eqn.charAt(0), eqn.charAt(3));
            }
        }
        for(String eqn: equations) {
            if(eqn.charAt(1) == '!') {
                char r1 = dsu.find(eqn.charAt(0));
                char r2 = dsu.find(eqn.charAt(3));
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
        public void union(char c1, char c2) {
            Node n1 = map.get(c1);
            Node n2 = map.get(c2);
            Node r1 = find(n1);
            Node r2 = find(n2);
            if(r1 != r2) {
                r1.parent = r2;
            }
        }
    }
}