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
    //use recursion and breadth first search
    //create a helper function to create lists for each level 
    //if size is less than level, add a new level 
    //add the root and the data
    //then do it recursively for the children

    static void bfsHelper(TreeNode node, int level, List<List<Integer>> result){
        if(node == null) return;

        //add new level to result if needed 
        if(result.size() <= level){
            result.add(new ArrayList<>()); 
        }

        //add node to the corresponding level
        result.get(level).add(node.val); 

        //do recursively with left and right level, with level + 1

        bfsHelper(node.left, level + 1, result);
        bfsHelper(node.right, level + 1, result);

    } 
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>(); 

        int level = 0; 

        bfsHelper(root, level, result); 

        return result;
        
    }
}
