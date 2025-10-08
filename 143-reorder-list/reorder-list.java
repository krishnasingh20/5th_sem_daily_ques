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
    public void reorderList(ListNode head) {
        if(head.next == null || head.next.next == null) {
            return;
        }
        ListNode mid = middle(head);
        ListNode nexthalf = mid.next;
        mid.next = null;
        ListNode newhead = reverse(nexthalf, null);
        ListNode temp = head;
        while(temp != null && newhead != null) {
            ListNode next = temp.next;
            temp.next = newhead;
            newhead = newhead.next;
            temp = temp.next;
            temp.next = next;
            temp = temp.next;
        }
    }
    public ListNode middle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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