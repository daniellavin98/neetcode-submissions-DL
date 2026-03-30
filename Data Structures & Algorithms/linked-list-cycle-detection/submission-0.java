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
    public boolean hasCycle(ListNode head) {
        //two pointer, a slow pointer and fast pointer -> tortoise and hare 
        //slow goes one at a time, fast goes at two 
        //if not cycle, reach null
        //so if fast reaches null, it is not a cycle and return false
        //if not, fast will eventually reach slow, be equal, if so return true

        if(head == null) return false; 

        ListNode slow = head; 
        ListNode fast = head.next; 

        while(slow != fast){

            //check if fast reaches null
            //if so, return false
            if(fast == null || fast.next == null){
                return false;
            }

            slow = slow.next; 
            fast = fast.next.next; 
        }

        //if we break out of while loop, slow equals fast - cycle
        return true;
    }
}
