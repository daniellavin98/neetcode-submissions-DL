class Solution {
public:
    int characterReplacement(string s, int k) {
        //need to count the frequency of characters -> hash map 
        //then get the max frequency 
        //with a sliding window, check whether the window size - max frequency 
        //is greater than k 
        //if so, decrease the window size, and frequency of character at i 
        //the result is the max between result and window size

        int i = 0; 
        int maxFreq = 0 ; 
        int result = 0; 

        unordered_map<char, int> hashMap; 

        for(int j = 0; j < s.length(); j++){
            char c = s[j]; 

            if(!hashMap.contains(c)){
                hashMap[c] = 1; 
            }
            else{
                hashMap[c]++; 
            }

            maxFreq = max(maxFreq, hashMap[c]); 

            int windowSize = j - i + 1; 

            if((windowSize - maxFreq) > k){
                hashMap[s[i]]--;
                i++; 
            }

            result = max(result, j-i+1); 
        }

        return result; 
    }
};
