class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //init array to be 0 of length n 
        //have a stack of ints, where 0 is degree, and 1 is index in temps
        //loop through temps
        //if the stack is not empty and the peek has a smaller degree than the current
        //pop from the stack, and put the difference between the two indeces at the index of the peek
        //so the result array will have the days inbetween until warmer temperature
        //otherwise, push current to stack 
        int n = temperatures.length; 
        int[] result = new int[n]; 

        Stack<int[]> stack = new Stack<>(); 

        for(int i = 0; i < n; i++){
            int temp = temperatures[i]; 

            while(!stack.isEmpty() && stack.peek()[0] < temp){
                int prev[] = stack.pop(); 
                result[prev[1]] = i - prev[1];  
            }
            stack.push(new int[]{temp, i});
        }

        return result;

    }
}
