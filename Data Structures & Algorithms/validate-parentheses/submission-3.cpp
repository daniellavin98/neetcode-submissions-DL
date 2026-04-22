class Solution {
public:
    bool isValid(string s) {
        //Make hash map for close to open brackets
        //Key is close, value is opening - key: ], value: [
        //if the character is an opening bracket, we push it into the stack
        //if the character is closed, we check if the top of the stack is equal to the value of the character - so the opening bracket
        //if so, we pop it, if not return false
        //at the end, stack should be empty, if so return true

        unordered_map<char, char> hash; 
        stack<char> st; 

        hash.insert({')', '('});
        hash.insert({']', '['});
        hash.insert({'}', '{'});

        for(char c : s){
            if(hash.contains(c)){
                if(!st.empty() && st.top() == hash[c]){
                    st.pop();
                }
                else{
                    return false;
                }
            }
            else{
                st.push(c);
            }
        }

        return st.empty();

    }
};
