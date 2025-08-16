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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        int size = 0;
        ListNode temp = head;
        while(temp != null) {
            size++;
            temp = temp.next;
        }
        int a = 0;
        int b = 0;
        a = size / k;
        b = (size / k) + 1;
        int len = size % k;
        int i = 0;
        ListNode curr = head;
        ListNode start = head;
        int idx = 0;
        while(curr != null) {
            if(len > 0 && i+1 == b) {
                ListNode next = curr.next;
                curr.next = null;
                ans[idx++] = start;
                start = next;
                curr = next;
                i = 0;
                len--;
            }
            else if(len == 0 && i+1 == a) {
                ListNode next = curr.next;
                curr.next = null;
                ans[idx++] = start;
                start = next;
                curr = next;
                i = 0;
            }
            else {
                curr = curr.next;
                i++;
            }
        }
        return ans;
    }
}