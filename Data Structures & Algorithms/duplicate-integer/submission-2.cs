public class Solution {
    public bool hasDuplicate(int[] nums) {
        //use a hash set 

        HashSet<int> hashSet = new HashSet<int>(); 

        for(int i = 0; i < nums.Length; i++){

            if(hashSet.Contains(nums[i])){
                return true;
            }

            hashSet.Add(nums[i]);
        }

        return false;
    }
}