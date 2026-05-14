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

//do inorder traversal 
//compare root node to max (integer min value), increment counter by one 
//then set max value to root, redo for left child
//if left child greater than root, increment counter, otherwise continue 
//then compare to rigth child and do the same

class Solution {
    private int count = 0; 

    private void findGood(TreeNode node, int max){
        if(node == null) return; 

        if(node.val >= max){
            count++;

            max = node.val; 
        }

        findGood(node.left, max);
        findGood(node.right, max);
        
    }

    public int goodNodes(TreeNode root) {
        
        findGood(root, Integer.MIN_VALUE); 

        return count; 
    }
}
