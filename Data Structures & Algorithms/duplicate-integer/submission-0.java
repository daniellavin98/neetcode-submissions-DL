class Solution {
    public boolean hasDuplicate(int[] nums) {
        //Use hash map
        HashMap<Integer, Integer> hash = new HashMap<>(); 

        for(int i = 0; i < nums.length; i++){

            hash.put(nums[i], hash.getOrDefault(nums[i], 0) + 1); 

            if(hash.containsKey(nums[i]) && hash.get(nums[i]) > 1){
                return true;
            }
        }

        return false; 

    }
}