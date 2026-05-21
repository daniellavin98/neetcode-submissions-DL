class Solution {
public:
    bool isPalindrome(string s) {
        int i = 0; 
        int j = s.length() - 1; 

        while(i < j){
            while(i < j && !alphaNum(s[i])){
                i++; 
            }
            while(i < j && !alphaNum(s[j])){
                j--; 
            }

            if((char)tolower(s[i]) != (char)tolower(s[j])){
                return false; 
            }

            i++; 
            j--; 
        }

        return true; 
    }

    bool alphaNum(char c){
        return (c >= 'A' && c <= 'Z' ||
                c >= 'a' && c <= 'z' ||
                c >= '0' && c <= '9');
    }
};
