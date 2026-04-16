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
    //use hare and tortoise algorithm 
    //do delete node from list, we set the node.next to be node.next.next
    //first move fast pointer n times
    //then both nodes move until fast reaches end
    //once here, set slow.next = slow.next.next
    //however, if fast reaches null before this, head is nth node so return head.next
    public ListNode RemoveNthFromEnd(ListNode head, int n) {
        ListNode slow = head; 
        ListNode fast = head;

        for(int i = 0; i < n; i++){
            fast = fast.next; 
        } 

        if(fast == null){
            return head.next; 
        }

        while(fast.next != null){
            fast = fast.next; 
            slow = slow.next; 
        }

        slow.next = slow.next.next; 

        return head; 
    }
}
