class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> hash;

        for(int i = 0; i < nums.size(); i++){
            int compliment = target - nums[i];

            if(hash.contains(compliment)){
                return {hash[compliment], i};
            }

            hash.insert({nums[i], i});
        }

        return nums;
 
    }
};
