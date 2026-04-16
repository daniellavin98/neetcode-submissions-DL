/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

public class Solution {
    public void ReorderList(ListNode head) {
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
