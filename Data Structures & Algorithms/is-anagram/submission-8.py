class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if(len(s) != len(t)):
            return False

        hashDict = {}

        for i in range(len(s)):
            c = s[i]

            if(c not in hashDict):
                hashDict[c] = 1
            else:
                hashDict[c] += 1
        
        for i in range(len(t)):
            c = t[i]

            if(c not in hashDict or hashDict[c] == 0):
                return False

            hashDict[c] -= 1

        return True