class Solution {
    //Use Kadanes algorithm 
        //have a current value, set at nums[0], set result at nums[0] too 
        //update current by getting the max between current + nums[i], and nums[i]
        //then update result by getting the max between itself and the current 
    public int maxSubArray(int[] nums) {
        int result = nums[0]; 
        int current = nums[0]; 

        for(int i = 1; i < nums.length; i++){
            current = Math.max(current + nums[i], nums[i]); 
            result = Math.max(result, current); 
        }

        return result;
    }
}
