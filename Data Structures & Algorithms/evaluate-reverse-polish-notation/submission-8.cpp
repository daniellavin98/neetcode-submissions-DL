class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<int> st; 

        for(int i = 0; i < tokens.size(); i++){
            if(tokens[i] == "+"){
                int val1 = st.top(); st.pop();
                int val2 = st.top(); st.pop();
                int res = val2 + val1; 
                st.push(res);
            }
            else if(tokens[i] == "-"){
                int val1 = st.top(); st.pop();
                int val2 = st.top(); st.pop();
                int res = val2 - val1; 
                st.push(res);
            }
            else if(tokens[i] == "*"){
                int val1 = st.top(); st.pop();
                int val2 = st.top(); st.pop();
                int res = val2 * val1; 
                st.push(res);
            }
            else if(tokens[i] == "/"){
                int val1 = st.top(); st.pop();
                int val2 = st.top(); st.pop();
                int res = val2 / val1; 
                st.push(res);
            }
            else{
                int res = stoi(tokens[i]);
                st.push(res);
            }
        } 

        return st.top();
    }
};
