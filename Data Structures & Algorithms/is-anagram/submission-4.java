class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false; 
        }
        
        HashMap<Character, Integer> hash = new HashMap<>(); 

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i); 
            if(!hash.containsKey(c)){
                hash.put(c, 1); 
            }
            else{
                hash.put(c, hash.get(c)+1); 
            }
        }

        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i); 

            if(!hash.containsKey(c) || hash.get(c) == 0){
                return false; 
            }

            hash.put(c, hash.get(c)-1);
        }


        return true;
    }
}
