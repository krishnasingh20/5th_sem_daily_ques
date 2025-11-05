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
        Stack<Node> st = new Stack<>();
        Node temp = head;
        Node curr = head.next;
        if(head.child != null) {
            curr = head.child;
            head.child = null;
            if(head.next != null) {
                head.next.prev = null;
                st.push(head.next);
            }
        }
        while(curr != null || !st.isEmpty()) {
            if(curr == null) {
                curr = st.pop();
            }
            temp.next = curr;
            curr.prev = temp;
            temp = temp.next;
            if(curr.child != null) {
                if(curr.next != null) {
                    curr.next.prev = null;
                    st.push(curr.next);
                }
                Node next = curr.child;
                curr.child = null;
                curr = next;
            }
            else {
                curr = curr.next;
            }
        }
        return head;
    }
}