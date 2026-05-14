class Solution {
    List<List<Integer>> result = new ArrayList<>(); 
    List<Integer> current = new ArrayList<>(); 
    private int[] nums; 

    private void backtrack(int index){
        if(index == nums.length){
            result.add(new ArrayList<>(current)); 
            return;
        }

        //don't pick current index 
        backtrack(index + 1); 

        //picl current index 
        current.add(nums[index]); 
        backtrack(index + 1); 

        //pop from current 
        current.remove(current.size() - 1); 
    }

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums; 
        backtrack(0); 

        return result; 
    }
}
