class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        int n = temperatures.size(); 
        vector<int> result(n, 0);

        stack<pair<int, int>> st; 

        for(int i = 0; i < n; i++){
            int temp = temperatures[i]; 

            while(!st.empty() && st.top().first < temp){
                auto prev = st.top();
                st.pop(); 
                result[prev.second] = i - prev.second;
            }

            st.push({temp, i});
        }

        return result;

    }
};
