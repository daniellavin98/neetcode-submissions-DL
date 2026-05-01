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
    public ListNode mergeKLists(ListNode[] lists) {
        //simillar to merge two linked lists
        //use dummy node to find smallest value, but its not boolean
        //so use min heap
        //heap will always have k elements
        //put smallest values in lists in min heap, then update one by one 

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val)); 


        for(ListNode node : lists){
            if(node != null){
                minHeap.offer(node); 
            }
        }

        ListNode dummy = new ListNode(0); 
        ListNode curr = dummy; 

        while(!minHeap.isEmpty()){
            ListNode node = minHeap.poll(); 
            curr.next = node; 
            curr = node; 

            if(node.next != null){
                minHeap.offer(node.next); 
            }
        }

        return dummy.next; 
    }
}
