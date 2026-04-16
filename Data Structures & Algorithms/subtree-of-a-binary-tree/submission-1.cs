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

    private bool IsSame(TreeNode tree1, TreeNode tree2){
        if(tree1 == null && tree2 == null) return true;

        if(tree1 == null || tree2 == null) return false;

        return (tree1.val == tree2.val) 
        && IsSame(tree1.left, tree2.left) 
        && IsSame(tree1.right, tree2.right);
    }  
    public bool IsSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false; 

        if(subRoot == null) return true;

        if(IsSame(root, subRoot)){
            return true;
        }

        return IsSubtree(root.left, subRoot) || IsSubtree(root.right, subRoot);
    }
}
