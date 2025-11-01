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
    public ListNode modifiedList(int[] nums, ListNode head) {
        int max = Integer.MIN_VALUE;
        for(int num : nums) {
            max = Math.max(num, max);
        }
        boolean[] flag = new boolean[max + 1];
        for(int num : nums) {
            flag[num] = true;
        }
        ListNode newhead = new ListNode(0);
        ListNode temp = newhead;
        ListNode curr = head;
        while(curr != null) {
            if(curr.val <= max && flag[curr.val] == false) {
                temp.next = curr;
                temp = temp.next;
            }else if(curr.val > max) {
                temp.next = curr;
                temp = temp.next;
            }
            curr = curr.next;
        }
        temp.next = null;
        return newhead.next;
    }
}