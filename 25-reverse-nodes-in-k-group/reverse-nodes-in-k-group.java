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
        int c = k;
        ListNode oh = null;
        ListNode ot = null;
        ListNode th = null;
        ListNode tt = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = null;
            curr.next = th;
            if(th == null) {    
                tt = curr;
                th = curr;
            }
            else {
                th = curr;
            }
            c--;
            if(c == 0) {
                if(oh == null) {
                    oh = th;
                }
                else {
                    ot.next = th;
                }
                ot = tt;
                c = k;
                tt = null;
                th = null;
            }
            curr = next;
        }
        if(c != 0) {
            ListNode t1 = null;
            ListNode t2 = null;
            while(th != null) {
                ListNode next = th.next;
                th.next = null;
                th.next = t1;
                if(t1 == null) {
                    t1 = th;
                    t2 = th;
                }
                else {
                    t1 = th;
                }
                th = next;
            }
            ot.next = t1;
        }
        return oh;
    }
}