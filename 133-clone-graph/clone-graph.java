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

        HashMap<Integer, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        map.put(1, new Node(1));

        while(!q.isEmpty()) {
            Node rv = q.poll();

            List<Node> ll = map.get(rv.val).neighbors;

            for(Node nbrs: rv.neighbors) {
                Node nn = null;
                if(!map.containsKey(nbrs.val)) {
                    q.add(nbrs);
                    map.put(nbrs.val, new Node(nbrs.val));
                }
                nn = map.get(nbrs.val);
                ll.add(nn);
            }
        }

        return map.get(1);
    }
}