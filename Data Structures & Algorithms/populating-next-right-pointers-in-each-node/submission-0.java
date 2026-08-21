/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
*/

class Solution {
    //use BFS
    public Node connect(Node root) {
        if(root == null) return null; 

        Queue<Node> queue = new LinkedList<>(); 

        Node dummy = root; 

        queue.add(dummy); 

        while(!queue.isEmpty()){

            int size = queue.size(); 

            for(int i = 0; i < size; i++){
                Node node = queue.poll();

                //check whether next is null
                //otherwise set to the peek
                if(i == size - 1){
                    node.next = null; 
                }
                else{
                    node.next = queue.peek(); 
                }

                //push the children 
                if(node.left != null){
                    queue.add(node.left); 
                }
                if(node.right != null){
                    queue.add(node.right); 
                }
            }
            
        }

        return dummy; 
    }
}