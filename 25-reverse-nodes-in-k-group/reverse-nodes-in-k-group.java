/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode Dummy = new ListNode();
        ListNode temp = Dummy;
        int i = 0;
        ListNode curr = head;
        ListNode start = head;
        while(curr != null) {
            if(i == k - 1) {
                ListNode next = curr.next;
                curr.next = null;
                ListNode reverse = reverse(start, null);
                temp.next = reverse;
                while(temp.next != null) {
                    temp = temp.next;
                }
                start = next;
                curr = next;
                i = 0;
            }
            else {
                curr = curr.next;
                i++;
            }
        }
        temp.next = start;
        return Dummy.next;
    }
    public ListNode reverse(ListNode curr, ListNode prev) {
        if(curr == null) {
            return prev;
        }
        ListNode temp = reverse(curr.next, curr);
        curr.next = prev;
        return temp;
    }
}