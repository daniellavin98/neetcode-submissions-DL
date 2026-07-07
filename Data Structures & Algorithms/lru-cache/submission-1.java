//cant use a hash map -> we need ordering 
//use a double linked list -> put things in constant time
//head is most recent, tail is least recent
//use hash map for get and puts

class LRUCache {

    final Node head = new Node(); 
    final Node tail = new Node(); 

    HashMap<Integer, Node> nodeMap; 
    
    int cacheCapacity;

    public LRUCache(int capacity) {
        nodeMap = new HashMap<>(capacity);
        this.cacheCapacity = capacity; 
        head.next = tail; 
        tail.prev = head; 
    }
    
    public int get(int key) {
        int result = -1; 

        Node node = nodeMap.get(key); 

        if(node != null){ 
            remove(node); 
            add(node);
            result = node.val; 
        }

        return result; 
        
    }
    
    public void put(int key, int value) {

        Node node = nodeMap.get(key); 

        //we do this to overwrite usage 
        //then put the node to the head
        
        if(node != null){ 
            remove(node);
            node.val = value; 
            add(node); 
        }
        else{
            if(nodeMap.size() == cacheCapacity){
                nodeMap.remove(tail.prev.key); 
                remove(tail.prev); 
            }

            Node newNode = new Node(); 
            newNode.key = key; 
            newNode.val = value; 

            nodeMap.put(key, newNode); 
            add(newNode);
        } 
        
    }

    public void remove(Node node){
        Node nextNode = node.next; 
        Node prevNode = node.prev; 

        nextNode.prev = prevNode; 
        prevNode.next = nextNode;

    }

    public void add(Node node){
        Node headNext = head.next; 
        node.next = headNext; 
        headNext.prev = node; 
        head.next = node; 
        node.prev = head; 
    }

    class Node{
        int key; 
        int val;
        Node prev;  
        Node next; 
    }
}
