public class Solution {
    public List<List<string>> GroupAnagrams(string[] strs) {
        Dictionary<string, List<string>> anagrams = new Dictionary<string, List<string>>(); 

        foreach(string s in strs){
            int[] count = new int[26]; 
            
            foreach(char c in s){
                count[c - 'a']++; 
            }

            string key = string.Join(",", count); 

            if(!anagrams.ContainsKey(key)){
                anagrams[key] = new List<string>(); 
            }

            anagrams[key].Add(s); 
        }

        return anagrams.Values.ToList<List<string>>(); 
    }
}
