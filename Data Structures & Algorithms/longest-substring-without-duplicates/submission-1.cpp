class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        //sliding window and hash set 
        //set i at 0 and j at zero
        //while j is less than length, check whether character at j is in set 
        //if not, add to set 
        //find max between max and size of set 
        //if so, remove from set the character at i and then increment i
        //return max

        int i = 0; 
        int j = 0; 
        int n = s.length(); 

        int maxSize = 0; 

        unordered_set<char> hashSet; 

        while(j < n){
            if(!hashSet.contains(s[j])){
                hashSet.insert(s[j]); 
                j++; 

                maxSize = max(maxSize, (int)hashSet.size()); 
            }
            else{
                hashSet.erase(s[i]); 
                i++; 
            }
        }

        return maxSize; 
    }
};
