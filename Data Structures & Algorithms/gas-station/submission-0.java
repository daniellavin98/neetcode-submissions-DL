class Solution {
    //Greedy 
    //sum of gas array has be greater or equal to sum of cost array
    //have a total value, set to difference 
    //if less than 0, change total to next position
    //if greater than 0, add elements to total
    //so the solution is the index that allows us to get to end of array without changing starting position
    //O(n)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = Arrays.stream(gas).sum(); 
        int costSum = Arrays.stream(cost).sum(); 

        if(gasSum < costSum){
            return -1; 
        }

        int total = 0; 
        int result = 0; 

        for(int i = 0; i < gas.length; i++){
            total += (gas[i] - cost[i]); 

            if(total < 0){
                total = 0; 
                result = i + 1; 
            }
        }

        return result; 
    }
}
