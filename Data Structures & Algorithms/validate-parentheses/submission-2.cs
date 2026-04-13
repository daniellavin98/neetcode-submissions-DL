public class Solution {
    public bool IsValid(string s) {
        //make dictionary for closed and open brackets 

        Dictionary<char, char> dict = new Dictionary<char, char>(); 

        Stack<char> stack = new Stack<char>(); 

        dict.Add(')', '(');
        dict.Add(']', '[');
        dict.Add('}', '{');

        foreach(char c in s){
            if(dict.ContainsKey(c)){
                if(stack.Count != 0 && stack.Peek() == dict[c]){
                    stack.Pop();
                }
                else{
                    return false;
                }
            }
            else{
                stack.Push(c);
            }
        }

        return stack.Count == 0;
    }
}
