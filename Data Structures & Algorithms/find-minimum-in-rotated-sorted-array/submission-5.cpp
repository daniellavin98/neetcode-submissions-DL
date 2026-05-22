class Solution {
public:
    int findMin(vector<int> &nums) {
         //if rotated, smaller values on right
        //so do binary search 
        //if nums[m] > nums[r], l = m+1, shift to right 
        //otherwise set r = m, 
        //the updated calculation of m means you can return either nums[l] or nums[r]

        int l = 0; 
        int r = nums.size() - 1; 

        while(l < r){
            int mid = l + (r-l)/2; 

            if(nums[mid] > nums[r]){
                l = mid + 1; 
            }
            else{
                r = mid ; 
            }
        }

        return nums[l]; 
    }
};
