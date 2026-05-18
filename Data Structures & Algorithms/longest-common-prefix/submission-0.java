class Solution {
    public String longestCommonPrefix(String[] strs) {
        //sort the array, then compare first to last as they are most different 
        //can only go as far as smallest length between first and last 

        Arrays.sort(strs); 
        int n = strs.length; 

        String first = strs[0]; 
        String last = strs[n-1]; 

        int minLength = Math.min(first.length(), last.length()); 

        //find the number of elements that are the same and store that number in i
        //i can't be greater than min length
        int i = 0; 

        while(i < minLength && first.charAt(i) == last.charAt(i)){
            i++; 
        }

        return first.substring(0, i);
    }
}