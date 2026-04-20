class Solution {
public:
    bool hasDuplicate(vector<int>& nums) {
        //for hash set use unodered set 
        unordered_set<int> hashSet; 

        for(int i = 0; i < nums.size(); i++){
            
            if(hashSet.contains(nums[i])){
                return true;
            }
            hashSet.insert(nums[i]);
        }

        return false;
    }
};