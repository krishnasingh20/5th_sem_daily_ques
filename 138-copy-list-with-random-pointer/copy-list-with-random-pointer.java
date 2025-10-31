/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Integer> map1 = new HashMap<>();
        HashMap<Integer, Node> map2 = new HashMap<>();
        Node dummy = new Node(0, null, null);
        Node temp = dummy;
        Node curr = head;
        int i = 0;
        while(curr != null) {
            temp.next = new Node(0, null, null);
            map1.put(curr, i);
            map2.put(i, temp.next);
            temp = temp.next;
            curr = curr.next;
            i++;
        }
        temp = dummy.next;
        curr = head;
        while(curr != null) {
            temp.val = curr.val;
            if(curr.random == null) {
                temp.random = null;
            }
            else {
                int x = map1.get(curr.random);
                temp.random = map2.get(x);
            }
            curr = curr.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}