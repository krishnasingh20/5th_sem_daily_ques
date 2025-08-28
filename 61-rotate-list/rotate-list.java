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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return head;
        }
        int size = 0;
        ListNode temp = head;
        while(temp != null) {
            size++;
            temp = temp.next;
        }
        k = k % size;
        if(k == 0) {
            return head;
        }
        ListNode newhead = reverse(head, null);
        ListNode curr = newhead;
        for(int i = 0; i < k - 1; i++) {
            curr = curr.next;
        }
        ListNode nexthalf = curr.next;
        curr.next = null;
        ListNode A = reverse(newhead, null);
        ListNode B = reverse(nexthalf, null);
        curr = A;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = B;
        return A;
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