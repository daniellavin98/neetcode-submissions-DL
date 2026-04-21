class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> anagrams; 

        for(const string& s : strs){
            vector<int> count(26,0);

            for(char c : s){
                count[c - 'a']++; 
            }

            string key = "";

            for(int n : count){
                key += "#" + to_string(n);
            }

            anagrams[key].push_back(s);
        }

        vector<vector<string>> result; 

        for(const auto& [key, group] : anagrams){
            result.push_back(group);
        }

        return result;


    }
};
