class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //binary search, where left is 1 and right is max of piles
        //these are the min and max that k can be
        //then find the middle rate, check if it can work
        //calculate the hours given the mid value and the piles[i]
        //if less than h, set result to middle and then set right to mid - 1
        //gonna check again to see if we can find a smaller value
        //if not, set left to mid + 1
        //return result

        int left = 1; 
        int right = Arrays.stream(piles).max().getAsInt(); 
        int result = right; 

        while(left <= right){
            int k = left + (right-left)/2; 

            int totalTime = 0; 

            for(int pile : piles){
                totalTime += Math.ceil((double) pile / k); 
            }
            if(totalTime <= h){
                result = k; 
                right = k - 1; 
            }
            else{
                left = k + 1; 
            }
        }

        return result;


    }
}
