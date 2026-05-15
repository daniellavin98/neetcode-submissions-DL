class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:

        my_hash = {}

        for i in range(len(nums)):
            compliment = target - nums[i]

            if(compliment in my_hash):
                return [my_hash[compliment], i]

            my_hash[nums[i]] = i
        
        return nums
        