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
//use hare and tortoise algorithm 
//to delete node from list, we set the node.next to be node.next.next
//first move fast pointer n times
//then both nodes move until fast reaches end
//once here, set slow.next = slow.next.next
//however, if fast reaches null before this, head is nth node so return head.next
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* slow = head; 
        ListNode* fast = head; 

        for(int i = 0; i < n; i++){
            fast = fast->next; 
        }

        if(fast == nullptr){
            return head->next; 
        }

        while(fast->next != nullptr){
            fast = fast->next; 
            slow = slow->next; 
        }

        slow->next = slow->next->next; 

        return head; 
    }
};
