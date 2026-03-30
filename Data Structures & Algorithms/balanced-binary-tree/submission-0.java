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
    private int height(TreeNode node){
        if(node == null) return 0; 

        //height = 1 + max of left height and right height
        int leftHeight = height(node.left); 
        int rightHeight = height(node.right); 

        return 1 + Math.max(leftHeight, rightHeight); 
    }
    public boolean isBalanced(TreeNode root) {
        //a tree is balanced if the height between left and right is not greater than 1
        //Use Depth first search traversal

        if(root == null) return true;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if(Math.abs(leftHeight - rightHeight) > 1){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }
}
