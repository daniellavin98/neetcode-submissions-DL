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
    bool hasCycle(ListNode* head) {
        //use hare and tortoise 
        //have two pointers, slow and fast 
        //if value of slow equals fast - cycle must exist 

        if(head == nullptr){
            return false; 
        }
        
        ListNode* slow = head;
        ListNode* fast = head->next; 

        while(slow != fast){
            
            if(fast == nullptr || fast->next == nullptr){
                return false; 
            }

            slow = slow->next; 
            fast = fast->next->next; 
        }  

        return true; 

    }
};
