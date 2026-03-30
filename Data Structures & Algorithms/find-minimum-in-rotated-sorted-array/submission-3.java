class Solution {
    public int findMin(int[] nums) {
        //if rotated, smaller values on right
        //so do binary search 
        //if nums[m] > nums[r], l = m+1, shift to right 
        //otherwise set r = m, 
        //the updated calculation of m means you can return either nums[l] or nums[r]

        int l = 0; 
        int r = nums.length - 1; 

        while(l < r){
            int m = l + (r-l)/2; 

            //checking if left half is sorted
            //if so, move to right half because min is on right
            if(nums[m] > nums[r]){
                l = m + 1; 
            }
            //otherwise, minimum is on the left
            else{
                r = m; 
            }
        }

        return nums[l]; 
    }
}
