class Solution {
    public int evalRPN(String[] tokens) {
        //create a stack for ints
        //loop through the array, 
        //if a number, convert to int and push into stack 
        //if a mathimatical sign, pop the previous two values, get the result and push to stack
        // return stack.peek()

        Stack<Integer> stack = new Stack<>(); 

        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+")){
                int val2 = stack.pop();
                int val1 = stack.pop(); 
                int res = val1 + val2; 
                stack.push(res);  
            }
            else if(tokens[i].equals("*")){
                int val2 = stack.pop();
                int val1 = stack.pop(); 
                int res = val1 * val2; 
                stack.push(res);  
            }
            else if(tokens[i].equals("-")){
                int val2 = stack.pop();
                int val1 = stack.pop(); 
                int res = val1 - val2; 
                stack.push(res);  
            }
            else if(tokens[i].equals("/")){
                int val2 = stack.pop();
                int val1 = stack.pop(); 
                int res = val1 / val2; 
                stack.push(res);  
            }
            else{
                int res = Integer.parseInt(tokens[i]);
                stack.push(res);
            }
        }

        return stack.peek(); 
    }
}