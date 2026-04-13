public class Solution {
    public bool IsAnagram(string s, string t) {
        //c# uses dictionarys and not hash maps 
        if(s.Length != t.Length){
            return false; 
        }

        Dictionary<char, int> dict = new Dictionary<char, int>(); 


        for(int i = 0; i < s.Length; i++){
            char c = s[i]; 

            if(!dict.ContainsKey(c)){
                dict[c] = 1; 
            }
            else{
                dict[c]++; 
            }
        }

        for(int i = 0; i < t.Length; i++){
            char c = t[i]; 

            if(!dict.ContainsKey(c) || dict[c] == 0){
                return false; 
            }

            dict[c]--; 
        }

        return true; 
    }
}
