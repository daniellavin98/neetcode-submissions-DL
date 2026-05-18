class Solution {
    public int majorityElement(int[] nums) {
        //use hash map
        //key is number, value is number of occurences
        //majority element, value is greater than n/2
        int n = nums.length; 
        HashMap<Integer, Integer> map = new HashMap<>(); 

        for(int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1); 
        } 

        for(HashMap.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > (n/2)){
                return entry.getKey(); 
            }
        }

        return 0; 
    }
}