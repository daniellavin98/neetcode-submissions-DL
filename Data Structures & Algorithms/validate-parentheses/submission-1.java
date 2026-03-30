class Solution {
    public boolean isValid(String s) {
        
        //Make hash map for close to open brackets
        //Key is close, value is opening - key: ], value: [
        //if the character is an opening bracket, we push it into the stack
        //if the character is closed, we check if the top of the stack is equal to the value of the character - so the opening bracket
        //if so, we pop it, if not return false
        //at the end, stack should be empty, if so return true

        Stack<Character> stack = new Stack<>();

        HashMap<Character, Character> hash = new HashMap<>(); 

        hash.put(')', '('); 
        hash.put(']', '['); 
        hash.put('}', '{'); 

        for(char c : s.toCharArray()){
            if(hash.containsKey(c)){
                if(!stack.isEmpty() && stack.peek() == hash.get(c)){
                    stack.pop(); 
                }
                else{
                    return false;
                }
            }
            else{
                stack.push(c); 
            }
        }

        return stack.isEmpty(); 
    }
}
