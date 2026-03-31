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
    //do dfs and use a max min range 
    //if the node is less than the min, or greater than the max, return false
    //then check for the left child with the max being the node - 1
    //the check for the right child with the min being node - 1

    static boolean dfsHelper(TreeNode node, int min, int max){
        if(node == null) return true;

        if(node.val < min || node.val > max){
            return false;
        }

        return dfsHelper(node.left, min, node.val - 1) && dfsHelper(node.right, node.val + 1, max);
    }
    public boolean isValidBST(TreeNode root) {

        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        return dfsHelper(root, min, max);
        
    }
}
