public class Solution {
    public int EvalRPN(string[] tokens) {
        var stack = new Stack<int>();

        for(int i = 0; i < tokens.Length; i++){
            if(tokens[i] == "+"){
                int val1 = stack.Pop();
                int val2 = stack.Pop();
                int res = val1 + val2;
                stack.Push(res);
            }
            else if(tokens[i] == "*"){
                int val1 = stack.Pop();
                int val2 = stack.Pop();
                int res = val1 * val2;
                stack.Push(res);
            }
            else if(tokens[i] == "-"){
                int val1 = stack.Pop();
                int val2 = stack.Pop();
                int res = val2 - val1;
                stack.Push(res);
            }
            else if(tokens[i] == "/"){
                int val1 = stack.Pop();
                int val2 = stack.Pop();
                int res = val2 / val1;
                stack.Push(res);
            }
            else{
                int res = Int32.Parse(tokens[i]);
                stack.Push(res);
            }
        }

        return stack.Peek();
    }
}
