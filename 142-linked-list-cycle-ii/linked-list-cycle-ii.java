/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode meet = hasCycle(head);
        if(meet == null) {
            return null;//no cycle
        }
        ListNode start = head;
        while(start != meet) {
            start = start.next;
            meet = meet.next;
        }
        return start;
    }
    private ListNode hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) {
                return slow;
            }
        }
        return null;
    }
}