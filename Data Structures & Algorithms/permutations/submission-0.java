class Solution {
    //use DFS
    //Time - O(n!)
    //Space - O(n) 

    private List<List<Integer>> result = new ArrayList<>(); 
    private List<Integer> current = new ArrayList<>();
    

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length]; 

        backtrack(nums, used); 

        return result;  
    }

    private void backtrack(int[] nums, boolean[] used){
        int n = nums.length; 

        if(current.size() == n){
            result.add(new ArrayList<>(current)); 
            return; 
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue; 

            current.add(nums[i]); 
            used[i] = true; 

            backtrack(nums, used); 

            current.remove(current.size() - 1); 

            used[i] = false; 
        }
    }
}
