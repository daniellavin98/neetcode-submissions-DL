class Solution {
    public int[] twoSum(int[] nums, int target) {
         //Hash Map -> key value pairs 
        //the key is the number, the value is the index in the array
        HashMap<Integer, Integer> hash = new HashMap<>(); 
    
        for(int i = 0; i < nums.length; i++){
            int compliment = target - nums[i]; 

            if(hash.containsKey(compliment)){
                return new int[]{hash.get(compliment), i}; 
            }
            hash.put(nums[i], i); 
        }

        return nums;
    } 
}
