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
    public ListNode reverseList(ListNode head) {
        // return reverse(head, null);//recursive approach
        return reverse1(head);//iterative approach
    }
    public ListNode reverse(ListNode curr, ListNode prev) {
        if(curr == null) {
            return prev;
        }
        ListNode temp = reverse(curr.next, curr);
        curr.next = prev;
        return temp;
    }
    public ListNode reverse1(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null) {
            ListNode next = curr.next;
            ListNode temp = curr;
            curr.next = prev;
            prev = temp;
            curr = next;
        }
        return prev;
    }
}