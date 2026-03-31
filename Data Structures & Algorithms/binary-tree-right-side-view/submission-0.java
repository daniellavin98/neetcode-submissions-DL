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
    //dfs and recursion
    //create dfs helper function that takes in an node and a list of integer
    //check whether if it is a new level, if so add the node to the list
    //then repeat the nodes right children first, then the left children
    //left child could still be most right if right does not exist

    static void dfsHelper(TreeNode node, int depth, List<Integer> result){
        if(node == null) return; 

        if(result.size() == depth){
            result.add(node.val); 
        }

        dfsHelper(node.right, depth + 1, result); 
        dfsHelper(node.left, depth + 1, result); 
    }
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new ArrayList<>(); 
        
        int depth = 0; 

        dfsHelper(root, depth, result); 

        return result; 
    }
}
