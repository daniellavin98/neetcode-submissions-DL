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
    //DFS inorder traversal
    //so check left, then self, then right 
    //decrement k each time you process a node 
    //when k reaches one, that is the answer
    //Time = O(n)
    //Spave = 0(H)

    private void dfsHelper(TreeNode node, int[] temp){
        if(node == null) return; 

        dfsHelper(node.left, temp); 

        temp[0] -= 1; 

        if(temp[0] == 0){
            temp[1] = node.val;
        }

        dfsHelper(node.right, temp);
    }
    public int kthSmallest(TreeNode root, int k) {
        int[] temp = new int[2];

        temp[0] = k; 

        dfsHelper(root, temp); 

        return temp[1]; 
    }
}
