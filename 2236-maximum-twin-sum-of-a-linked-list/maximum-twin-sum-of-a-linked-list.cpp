/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    int pairSum(ListNode* head) {
        ListNode* mid = middle(head);

        ListNode* nextHalf = mid->next;
        mid->next = nullptr;

        ListNode* head1 = reverse(nextHalf, nullptr);

        int ans = 0;

        while(head != nullptr) {
            ans = max(ans, head->val + head1->val);
            head = head->next;
            head1 = head1->next;
        }

        return ans;
    }

    ListNode* middle(ListNode* head) {
        ListNode* fast = head;
        ListNode* slow = head;

        while(fast->next != nullptr && fast->next->next != nullptr) {
            slow = slow->next;
            fast = fast->next->next;
        }

        return slow;
    }

    ListNode* reverse(ListNode* curr, ListNode* prev) {
        if(curr == nullptr) {
            return prev;
        }

        ListNode* temp = reverse(curr->next, curr);
        curr->next = prev;

        return temp;
    }
};