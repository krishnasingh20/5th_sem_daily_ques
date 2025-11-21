/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null) {
            return head;
        }
        Node curr = head;
        Node dummy = new Node();
        Node temp = dummy;
        Stack<Node> st = new Stack<>();
        while(curr != null || !st.isEmpty()) {
            if(curr != null) {
                temp.next = curr;
                curr.prev = temp;
                temp = temp.next;
                if(curr.child != null) {
                    if(curr.next != null) {
                        st.push(curr.next);
                        curr.next.prev = null;
                        curr.next = null;
                    }
                    Node ch = curr.child;
                    curr.child = null;
                    curr = ch;
                    continue;
                }
                curr = curr.next;
            }
            else {
                curr = st.pop();
            }
        }
        dummy.next.prev = null;
        return dummy.next;
    }
}