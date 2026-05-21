class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        //two pointers, i at 0, j at nums.length - 1
        //check if they sum to target
        //if result too big, decrement j, if too small increment i

        int i = 0; 
        int j = numbers.size() - 1; 

        while(i < j){
            int sum = numbers[i] + numbers[j]; 

            if(sum > target){
                j--; 
            }
            else if(sum < target){
                i++; 
            }
            else{
                return {i + 1, j + 1};  
            }
        }

        return {};
    }
};
