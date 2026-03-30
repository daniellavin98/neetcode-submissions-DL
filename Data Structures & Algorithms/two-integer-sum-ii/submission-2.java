class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //two pointers, i at 0, j at nums.length - 1
        //check if they sum to target
        //if result too big, decrement j, if too small increment i
        int i = 0; 
        int j = numbers.length - 1; 

        while(i < j){
            int sum = numbers[i] + numbers[j]; 

            if(sum > target){
                j--;
            }
            else if(sum < target){
                i++; 
            }
            else{
                return new int[]{i+1, j+1}; 
            }

        }

        return new int[0];
    }
}
