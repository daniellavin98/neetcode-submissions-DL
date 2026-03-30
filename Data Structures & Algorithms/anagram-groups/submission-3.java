class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        //put all characters into hash map 
        //count the occurences of each
        //make the key the character and the number of times it occurs in the string 
        //so 1e, 1a, 1t, etc
        //then the value is the strings 

        HashMap<String, List<String>> anagrams = new HashMap<>();

        for(String s : strs){
            int[] count = new int[26]; 
            for(char c : s.toCharArray()){
                count[c - 'a']++; 
            }
            String key = Arrays.toString(count);
            anagrams.putIfAbsent(key, new ArrayList<>()); 
            anagrams.get(key).add(s); 
        }

        return new ArrayList<>(anagrams.values()); 

    }
}
