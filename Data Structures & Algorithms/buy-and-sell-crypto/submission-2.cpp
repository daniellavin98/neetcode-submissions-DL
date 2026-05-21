class Solution {
public:
    int maxProfit(vector<int>& prices) {
        //Sliding Window 
        //Two pointers - Buy when left is less than right 
        //Set the curret profit to max if greater than
        //Only update l when it is greater than r, but always update r

        int l = 0; 
        int r = 1; 
        int n = prices.size(); 

        int maxProfit = 0; 

        while(r < n){
            if(prices[r] > prices[l]){
                int currentProfit = prices[r] - prices[l]; 

                maxProfit = max(maxProfit, currentProfit); 
            }
            else{
                l = r; 
            }
            r++; 
        }
        
        return maxProfit; 
        
    }
};
