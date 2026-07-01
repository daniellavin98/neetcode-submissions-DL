class Solution {
    public int singleNumber(int[] nums) {
        //Bit manipulation

        int result = 0; 

        for(int num : nums){
            result ^= num; 
        }

        return result;
    }
}
