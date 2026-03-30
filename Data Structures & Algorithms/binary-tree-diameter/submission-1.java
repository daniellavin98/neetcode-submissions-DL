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
    //diameter of a binary tree is the number of edges on the longest path 
    //so use DFS 

    static int maxDiameter = 0; 

    private int dfsHelper(TreeNode node){
        if(node == null) return 0;

        int leftH = dfsHelper(node.left); 
        int rightH = dfsHelper(node.right); 

        if(leftH + rightH > maxDiameter){
            maxDiameter = leftH + rightH; 
        }

        return 1 + Math.max(leftH, rightH); 
    }

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0; 
        dfsHelper(root); 

        return maxDiameter;
    }
}
