class Solution {
    //have to find the pivot - at index of smallest value 
    //two binary searches
    //first find the pivot 
    //then do binary search on where we should be looking 
    public int search(int[] nums, int target) {
        

        int l = 0; 
        int r = nums.length - 1; 

        while(l < r){
            int m = l + (r-l)/2; 

            //firsy binary search 
            //left side is sorted, so min is on right 
            if(nums[m] > nums[r]){
                l = m + 1; 
            }
            else{
                r = m;
            }
        }

        //set the pivot to l
        //then call binary seraches for either the left or right side
        //one will return the answer and not -1
        int pivot = l; 

        int result = binarySearch(nums, target, 0, pivot-1); 

        if(result != -1){
            return result;
        }

        return binarySearch(nums, target, pivot, nums.length-1); 


    }

    //function to do binary search on sub array
    public int binarySearch(int[] nums, int target, int left, int right){
        while(left <= right){
            int mid = left + (right - left)/2; 

            if(nums[mid] == target){
                return mid; 
            }
            else if(nums[mid] > target){
                right = mid - 1; 
            }
            else{
                left = mid + 1; 
            }
        }

        return -1; 
    }
}
