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

//Split the linked list in two -> do this using hare and tortoise method to find middle 
//then reverse the second half of the list 
//merge two halves by alternating between nodes from first half and second half


class Solution {

    public void reorderList(ListNode head) {
        ListNode slow = head; 
        ListNode fast = head.next; 

        while(fast != null && fast.next != null){
            slow = slow.next; 
            fast = fast.next.next; 
        }

        ListNode firstHalf = head; 
        ListNode secondHalf = slow.next;
        ListNode prev = slow.next = null;   

        while(secondHalf != null){
            ListNode temp = secondHalf.next; 
            secondHalf.next = prev; 

            prev = secondHalf; 
            secondHalf = temp; 
        }

        secondHalf = prev; 

        while(secondHalf != null){
            ListNode temp1 = firstHalf.next; 
            ListNode temp2 = secondHalf.next; 

            firstHalf.next = secondHalf; 
            secondHalf.next = temp1;
            firstHalf = temp1; 
            secondHalf = temp2;         
        }
    }
}
