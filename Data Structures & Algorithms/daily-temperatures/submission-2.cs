public class Solution {
    public int[] DailyTemperatures(int[] temperatures) {
        //stack of arrays -> 0 is degree and 1 is position
        //loop through temps
        //if stack is not empty and its peek is less than current temp
        //pop from stack, append to result array the difference in positions 
        //between the current - i - and the position of the popped element

        int n = temperatures.Length; 
        int[] result = new int[n]; 

        var stack = new Stack<int[]>(); 

        for(int i = 0; i < n; i++){
            int temp = temperatures[i]; 

            while(stack.Count != 0 && stack.Peek()[0] < temp){
                int[] prev = stack.Pop(); 
                result[prev[1]] = i - prev[1]; 
            }
            stack.Push(new int[]{temp, i});
        } 

        return result;

    }
}
