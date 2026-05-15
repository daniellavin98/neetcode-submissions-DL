class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        #put all characters into hash map 
        #count the occurences of each
        #make the key the character and the number of times it occurs in the string 
        #so 1e, 1a, 1t, etc
        #then the value is the strings

        anagrams = {}

        for s in strs:
            count = [0] * 26

            for c in s:
                count[ord(c) - ord('a')] += 1

            key = tuple(count)

            if key not in anagrams:
                anagrams[key] = []
            
            anagrams[key].append(s)
        
        return list(anagrams.values())