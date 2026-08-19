/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> map = new HashMap<>(); 
    public Node cloneGraph(Node node) {

        if(node == null) return null; 
        
        //curr is the copy of graph
        //so key is orgiinal, value is copy
        Node curr = new Node(node.val); 
        map.put(node, curr); 

        for(Node nei : node.neighbors){
            if(!map.containsKey(nei)){
                cloneGraph(nei); 
            }

            //otherwise add copy of node to copy of graph
            curr.neighbors.add(map.get(nei)); 
        }

        return curr; 
    }
}