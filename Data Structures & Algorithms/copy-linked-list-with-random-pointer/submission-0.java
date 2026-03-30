/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

       //Two loops 
        //First loop, take input and make copies of each, use hash map
        //map original node to old copy 
        //Second loop, do pointer connecting 
        //leverage hash to map old node to new node

class Solution {
    public Node copyRandomList(Node head) {

        if(head == null) return null; 

        Node curr = head; 

        HashMap<Node, Node> oldToCopy = new HashMap<>(); 

        while(curr != null){
            Node copy = new Node(curr.val); 
            oldToCopy.put(curr, copy); 
            curr = curr.next;
        }

        curr = head; 

        while(curr != null){
            Node copy = oldToCopy.get(curr); 
            copy.next = oldToCopy.get(curr.next); 
            copy.random = oldToCopy.get(curr.random);
            curr = curr.next;  
        }

        return oldToCopy.get(head); 
        
    }
}
