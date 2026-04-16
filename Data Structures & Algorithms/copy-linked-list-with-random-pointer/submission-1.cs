/*
// Definition for a Node.
public class Node {
    public int val;
    public Node next;
    public Node random;
    
    public Node(int _val) {
        val = _val;
        next = null;
        random = null;
    }
}
*/

    //Two loops 
    //First loop, take input and make copies of each, use hash map
    //map original node to old copy 
    //Second loop, do pointer connecting 
    //leverage hash to map old node to new node

public class Solution {
    public Node copyRandomList(Node head) {
        
        if(head == null) return null; 

        Node curr = head; 

        var oldToCopy = new Dictionary<Node, Node>(); 

        while(curr != null){
            Node copy = new Node(curr.val); 
            oldToCopy[curr] = copy;
            curr = curr.next; 
        }

        curr = head; 
        
        while(curr != null){
            Node copy = oldToCopy[curr]; 
            copy.next = curr.next != null ? oldToCopy[curr.next] : null; 
            copy.random = curr.random != null ? oldToCopy[curr.random] : null; 
            curr = curr.next; 
        }

        return head != null ? oldToCopy[head] : null; 
    }
}
