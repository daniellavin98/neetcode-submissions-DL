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
    //use DFS
    //Compare root of tree to that of subtree
    //then move down and compare the children to left, then to right 
    //have a helper function that checks if the trees are the same 

    static boolean isSame(TreeNode tree1, TreeNode tree2){
        if(tree1 == null && tree2 == null) return true;

        if(tree1 == null || tree2 == null) return false; 

        return (tree1.val == tree2.val) && isSame(tree1.left, tree2.left) && isSame(tree1.right, tree2.right); 
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        //we check if they trees are identical
        //if not, check if left subtree is identical to subtree
        //or if right subtree is identical

        if(subRoot == null) return true;

        if(root == null) return false; 

        if(isSame(root, subRoot)){
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
