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
    public boolean isPalindrome(ListNode head) {
        ListNode mid = middle(head);
        ListNode nextHalf = mid.next;
        mid.next = null;
        ListNode newhead = reverse(nextHalf, null);
        while(head != null && newhead != null) {
            if(head.val != newhead.val) {
                return false;
            }
            head = head.next;
            newhead = newhead.next;
        }
        return true;
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