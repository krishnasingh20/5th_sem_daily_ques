/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        if(node == null) {
            return null;
        }

        if(node.val == 0) {
            return new Node();
        }

        Node[] map = new Node[101];
        Queue<Node> q = new LinkedList<>();

        q.add(node);
        map[1] = new Node(1);

        while(!q.isEmpty()) {

            Node rv = q.poll();

            List<Node> ll = map[rv.val].neighbors;

            for(Node nbrs: rv.neighbors) {
                if(map[nbrs.val] == null) {
                    q.add(nbrs);
                    map[nbrs.val] = new Node(nbrs.val);
                }

                ll.add(map[nbrs.val]);
            }
        }

        return map[1];
    }
}