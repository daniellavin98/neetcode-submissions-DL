class Solution {
    public int characterReplacement(String s, int k) {
        //need to count the frequency of characters -> hash map 
        //then get the max frequency 
        //with a sliding window, check whether the window size - max frequency 
        //is greater than k 
        //if so, decrease the window size, and frequency of character at i 
        //the result is the max between result and window size

        int i = 0; 
        int maxFreq = 0;
        int result = 0;  

        HashMap<Character, Integer> hashMap = new HashMap<>(); 

        for(int j = 0; j < s.length(); j++){
            char c = s.charAt(j); 
            if(!hashMap.containsKey(c)){
                hashMap.put(c, 1); 
            }
            else{
                hashMap.put(c, hashMap.get(c)+1);
            }

            maxFreq = Math.max(maxFreq, hashMap.get(c)); 

            int windowSize = j - i + 1; 

            if((windowSize - maxFreq) > k){
                hashMap.put(s.charAt(i), hashMap.get(s.charAt(i))-1); 
                i++; 
            }

            result = Math.max(result, j-i+1); 
        }

        return result;
    }
}
