class Solution {
    //variable sized sliding window 
    //for t -> store in hash map, count the duplicates 
    //have two pointers starting at 0, l and r 
    //create a new hash table to count the frequency of characters in window that exist in other
    //increment r until you statisfy all char and frequencys in first hash table 
    //get the length of this window, once done, increment the l by one, start again 
    //return string on min size
    //
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return ""; 
        }

        //Create first hash table 
        HashMap<Character, Integer> tMap = new HashMap<>(); 

        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i); 

            tMap.put(c, tMap.getOrDefault(c, 0)+1); 
        }

        //Create Second hash map 
        HashMap<Character, Integer> sMap = new HashMap<>(); 

        //init integers 
        //have a have value -> how many chars currently meet required amount 
        //have a need value -> number of characters needed for substring 

        int l = 0; 
        int minLength = Integer.MAX_VALUE; 
        int have = 0; 
        int need = tMap.size(); 

        //this is for window 
        int[] res = {-1, -1};

        for(int r = 0; r < s.length(); r++){
            char c = s.charAt(r); 

            sMap.put(c, sMap.getOrDefault(c, 0)+1); 

            if(tMap.containsKey(c) && sMap.get(c).equals(tMap.get(c))){
                have++; 
            }

            while(have == need){
                //update min window size
                if((r - l + 1) < minLength){
                    minLength = r - l + 1; 
                    res[0] = l; 
                    res[1] = r; 
                }

                char lChar = s.charAt(l); 

                sMap.put(lChar, sMap.get(lChar) - 1); 

                if(tMap.containsKey(lChar) && sMap.get(lChar) < tMap.get(lChar)){
                    have--;
                }

                l++; 
            }

        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);  
     

        


    }
}
