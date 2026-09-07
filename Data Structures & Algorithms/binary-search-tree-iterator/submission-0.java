/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
  //in order traversal - comes in pre order traversal 
 //so we need to convert this pre order tree to in order tree and store in list
 //so next is then i++
 //and has next is whether current index is less than list size
class BSTIterator {

    private int currentIdx; 

    private List<Integer> inorder; 

    public BSTIterator(TreeNode root) {
        currentIdx = 0; 
        inorder = new ArrayList<>(); 
        inorderHelper(root); 
    }
    
    public int next() {
        return inorder.get(currentIdx++); 
    }
    
    public boolean hasNext() {
        return currentIdx < inorder.size();
    }

    private void inorderHelper(TreeNode node){
        if(node == null) return;

        inorderHelper(node.left); 

        inorder.add(node.val); 

        inorderHelper(node.right); 
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */