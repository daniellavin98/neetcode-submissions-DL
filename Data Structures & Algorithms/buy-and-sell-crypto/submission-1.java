class Solution {
    public int maxProfit(int[] prices) {
        //Sliding Window 
        //Two pointers - Buy when left is less than right 
        //Set the curret profit to max if greater than
        //Only update l when it is greater than r, but always update r


        int n = prices.length; 
        int l = 0; 
        int r = 1; 

        int maxProfit = 0; 

        while(r < n){
            if(prices[r] > prices[l]){
                int currentProfit = prices[r] - prices[l]; 

                if(currentProfit > maxProfit){
                    maxProfit = currentProfit; 
                }
            }
            else{
                l = r; 
            }

            r++; 
        }

        return maxProfit; 
    }
}
