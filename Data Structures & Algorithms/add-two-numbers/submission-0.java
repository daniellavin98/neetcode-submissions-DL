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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); 
        ListNode l3 = dummy; 

        int carry = 0; 

        while(l1 != null || l2 != null){
            int l1Val = (l1 != null) ? l1.val : 0;
            int l2Val = (l2 != null) ? l2.val : 0;

            int curSum = l1Val + l2Val + carry; 
            carry = curSum/10; 
            int lastDigit = curSum % 10; 

            ListNode node = new ListNode(lastDigit); 
            l3.next = node; 

            if(l1 != null) l1 = l1.next;  
            if(l2 != null) l2 = l2.next;

            l3 = l3.next;   
        }

        if(carry > 0){
            ListNode node = new ListNode(carry); 
            l3.next = node; 
            l3 = l3.next; 
        }

        return dummy.next; 
    }
}
