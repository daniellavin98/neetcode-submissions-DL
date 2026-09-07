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
  //so bfs -> make each level a list 
 //so start at level 0
 //so for every odd level, the list has to be reversed
 //use an array deque, levels are controlled by logic flag
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>(); 

        if(root == null) return result;

        //use dequeue to process each level 
        Deque<TreeNode> queue = new ArrayDeque<>(); 
        queue.offer(root); 

        boolean isNormal = true;

        while(!queue.isEmpty()){

            List<Integer> currentLevel = new ArrayList<>(); 

            int levelSize = queue.size(); 

            //process all nodes at current level
            for(int i = 0; i < levelSize; i++){
                TreeNode curr = queue.poll();
                currentLevel.add(curr.val); 

                //add left and right children to queue for processing
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }

            if(!isNormal){
                Collections.reverse(currentLevel); 
            }

            result.add(currentLevel); 

            isNormal = !isNormal; 
             
        } 

        return result;
    }
}














