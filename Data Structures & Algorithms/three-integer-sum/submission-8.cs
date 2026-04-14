public class Solution {
    public List<List<int>> ThreeSum(int[] nums) {
        
        Array.Sort(nums); 

        List<List<int>> result = new List<List<int>>(); 

        int n = nums.Length;

        
        // Iterate through the array as the first element of triplet
        // Stop at length-2 since we need at least 3 elements
        // Also stop early if current element is positive (sum can't be zero with all positive numbers)

        for(int i = 0; i < n-2 && nums[i] <=0; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue; 
            }

            int l = i+1; 
            int r = n-1;

            int target = -nums[i]; 

            while(l < r){
                if(nums[l] + nums[r] < target){
                    l++; 
                }
                else if(nums[l] + nums[r] > target){
                    r--; 
                }
                else{
                    result.Add(new List<int> {nums[i], nums[l], nums[r]});
                    l++;
                    r--;

                    //skip duplicates 
                    while(l < r && nums[l] == nums[l-1]){
                        l++; 
                    }

                    while(l < r && nums[r] == nums[r+1]){
                        r--;
                    }
                }
            }
        }

        return result; 
    }
}
