class Solution {
    public boolean isPalindrome(String s) {
        //to read the same forward and backward, the string at the start must be equal to that at end 
        //so two pointers, i at 0, j at s.length-1
        //if i not equal to j, return false
        //else increment i and decrement j while i < j

        int i = 0; 
        int j = s.length() - 1;

        while(i < j){

            while(i < j && !alphaNum(s.charAt(i))){
                i++;
            }
            while(j > i && !alphaNum(s.charAt(j))){
                j--;
            }

            char c1 = s.charAt(i);
            char c2 = s.charAt(j); 

            if(Character.toLowerCase(c1) != Character.toLowerCase(c2)){
                return false;
            }
            i++; 
            j--; 
        }

        return true;

    }

     public boolean alphaNum(char c) {
        return (c >= 'A' && c <= 'Z' ||
                c >= 'a' && c <= 'z' ||
                c >= '0' && c <= '9');
    }
}
