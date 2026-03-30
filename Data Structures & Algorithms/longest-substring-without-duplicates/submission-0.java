class Solution {
    public int lengthOfLongestSubstring(String s) {
        //sliding window and hash set 
        //set i at 0 and j at zero
        //while j is less than length, check whether character at j is in set 
        //if not, add to set 
        //find max between max and size of set 
        //if so, remove from set the character at i and then increment i
        //return max

        int i = 0;
        int j = 0;
        int max = 0;

        HashSet<Character> hashSet = new HashSet<>(); 

        while(j < s.length()){
            if(!hashSet.contains(s.charAt(j))){
                hashSet.add(s.charAt(j)); 
                j++; 

                max = Math.max(max, hashSet.size()); 
            }
            else{
                hashSet.remove(s.charAt(i)); 
                i++; 
            }

        }

        return max;
    }
}
