class Solution {
    public int findDuplicate(int[] nums) {
        //can use a hash set to find duplicate but that is O(n) space
        //use fast and slow pointers - hare and tortoise method 
        //both start at zero, slow moves one step, fast moves two 
        //when they meet, in a cycle so  break 
        //set a new pointer at 0, slow is now where fast is 
        //move both at one step per time, where they meet is the duplicate 

        int slow = 0; 
        int fast = 0; 

        while(true){
            slow = nums[slow]; 
            fast = nums[nums[fast]];

            if(slow == fast){
                break; 
            }
        }
        
        int slow2 = 0; 

        while(true){

            slow = nums[slow]; 
            slow2 = nums[slow2]; 

            if(slow == slow2){
                return slow; 
            }

        }
        
    }
}
