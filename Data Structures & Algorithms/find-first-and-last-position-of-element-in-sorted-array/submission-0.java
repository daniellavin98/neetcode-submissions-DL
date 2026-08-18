class Solution {
    //have to use two functions
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2]; 
        result[0] = findStartIndex(nums, target); 
        result[1] = findEndIndex(nums, target);

        return result;  
    }

    //search in left subarray
    public int findStartIndex(int[] nums, int target){
        int index = -1; 

        int l = 0; 
        int r = nums.length - 1; 

        while(l <= r){
            int mid = l + (r-l)/2; 

            if(nums[mid] >= target){
                r = mid - 1; 
            }
            else{
                l = mid + 1; 
            }

            if(nums[mid] == target){
                index = mid; 
            }
        }

        return index; 
    }

    //search in right subarray
    public int findEndIndex(int[] nums, int target){
        int index = -1; 

        int l = 0; 
        int r = nums.length - 1; 

        while(l <= r){
            int mid = l + (r-l)/2; 

            if(nums[mid] <= target){
                l = mid + 1; 
            }
            else{
                r = mid - 1; 
            }

            if(nums[mid] == target){
                index = mid; 
            }
        }

        return index; 
    }
}