class Solution {
    //dont want duplicate subsets 
    //so use hash set to deal with duplicates 
    //have to sort array first 
    List<List<Integer>> result = new ArrayList<>(); 
    List<Integer> current = new ArrayList<>(); 
    private int nums[]; 
    HashSet<List<Integer>> subsets = new HashSet<>(); 

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums); 
        this.nums = nums; 
        backtrack(0); 

        return result; 
    }

    private void backtrack(int index){
        if(index == nums.length){
            if(!subsets.contains(current)){
                result.add(new ArrayList<>(current));
                subsets.add(new ArrayList<>(current)); 
            }
            return; 
        }

        backtrack(index + 1); 

        current.add(nums[index]); 

        backtrack(index + 1); 

        current.remove(current.size() - 1); 
    }
}
