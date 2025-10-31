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
    public ListNode sortList(ListNode head) {
        return sort(head);
    }
    public ListNode sort(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode mid = middle(head);
        ListNode nextHalf = mid.next;
        mid.next = null;
        ListNode A = sort(head);
        ListNode B = sort(nextHalf);
        return merge(A, B);
    }
    public ListNode merge(ListNode A, ListNode B) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        while(A != null && B != null) {
            if(A.val < B.val) {
                temp.next = A;
                temp = temp.next;
                A = A.next;
            }
            else {
                temp.next = B;
                temp = temp.next;
                B = B.next;
            }
        }
        if(A != null) {
            temp.next = A;
        }
        if(B != null) {
            temp.next = B;
        }
        return dummy.next;
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
}