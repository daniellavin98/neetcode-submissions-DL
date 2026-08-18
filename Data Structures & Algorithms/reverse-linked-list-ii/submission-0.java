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
    //first get the left node 
    //then reverse from left to right
    //update the pointers 
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr = head; 
        ListNode dummy = new ListNode(0, head); 
        ListNode leftPrev = dummy; 
        ListNode prev = null; 

        for(int i = 0; i < left - 1; i++){
            leftPrev = curr; 
            curr = curr.next; 
        }

        //now left node is at curr
        //so reverse from left to right 

        for(int i = 0; i < right - left + 1; i++){
            ListNode tempNext = curr.next; 
            curr.next = prev; 

            prev = curr; 
            curr = tempNext; 
        }

        //update the nodes 
        leftPrev.next.next = curr; 
        leftPrev.next = prev; 

        return dummy.next; 

    }
}