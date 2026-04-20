class Solution {
public:
    bool isAnagram(string s, string t) {
        //hash map in c++ is unordered map
        if(s.size() != t.size()){
            return false; 
        }

        unordered_map<char, int> hash; 

        for(int i = 0; i < s.size(); i++){
            char c = s[i];

            if(!hash.contains(c)){
                hash[c] = 1; 
            }
            else {
                hash[c]++;
            }
        }

        for(int i = 0; i < t.size(); i++){
            char c = t[i];

            if(!hash.contains(c) || hash[c] == 0){
                return false;
            }

            hash[c]--;
        }

        return true;


    }
};
