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
    //diameter of a binary tree is the number of edges on the longest path 
    //so use DFS 
    static int maxDiameter = 0;

    private int DfsHelper(TreeNode node){
        if(node == null) return 0; 

        int leftH = DfsHelper(node.left);
        int rightH = DfsHelper(node.right);

        if(leftH + rightH > maxDiameter){
            maxDiameter = leftH + rightH;
        }

        return 1 + Math.Max(leftH, rightH);
    }
    public int DiameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        DfsHelper(root);

        return maxDiameter;
    }
}
