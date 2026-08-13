class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length; 
        for(int i = n-1; i>=0; i--){

            if(digits[i] < 9){
                digits[i]++; 
                return digits; 
            }

            //if the digit is 9, change to 0, add 1 to next digit
            digits[i] = 0; 
        }
         
         //if all 9s, make new number 

        int[] new_number = new int[n+1]; 
        new_number[0] = 1; 

        return new_number; 
    }
}
