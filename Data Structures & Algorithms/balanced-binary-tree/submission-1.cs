/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Solution {
    private int Height(TreeNode node){
        if(node == null) return 0; 

        //height = 1 = max of left and right height 

        int leftH = Height(node.left);
        int rightH = Height(node.right);

        return 1 + Math.Max(leftH, rightH);
    }
    public bool IsBalanced(TreeNode root) {
        //a tree is balanced if the height between left and right is not greater than 1
        //Use Depth first search traversal

        if(root == null) return true;

        int leftH = Height(root.left);
        int rightH = Height(root.right);

        if(Math.Abs(leftH - rightH) > 1){
            return false;
        }

        return IsBalanced(root.left) && IsBalanced(root.right);
    }
}
