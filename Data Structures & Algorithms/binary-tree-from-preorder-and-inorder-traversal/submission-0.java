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

class Solution {
    //inorder -> left, current, right
    //preorder -> current, left, right
    //construct the tree using pre order traveral 
    //get the root node by getting the first element in preorder 
    //find this root node in inorder
    //create the left subtree using elements in inorder left of root
    //the first value after root in preorder is root of left subtree, then left right children
    //create right subtree using elements in inorder right of root
    //to reduce time, use hash map to map the inorder array to its indices
    HashMap<Integer, Integer> inorderMap = new HashMap<>();

    
    public TreeNode dfsHelper(int[] preorder, int[] preIndex, int l, int r){
        //for empty inorder array return null
        if(l > r){
            return null; 
        }

        int rootVal = preorder[preIndex[0]]; 
        preIndex[0]++; 

        TreeNode root = new TreeNode(rootVal); 

        int index = inorderMap.get(rootVal); 

        //recursively create left and right subtrees using dfs
        root.left = dfsHelper(preorder, preIndex, l, index - 1);
        root.right = dfsHelper(preorder, preIndex, index + 1, r);

        return root; 
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //use hash map to store index of root element in inorder array
        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i); 
        }

        int[] preIndex = {0}; 

        return dfsHelper(preorder, preIndex, 0, inorder.length - 1); 
    }
}
