class Solution {
    public int reverseBits(int n) {
        int result = 0; 

        for(int i = 0; i < 32 && n != 0; i++){
            //get least significant bit 
            int currBit = n & 1; 

            // Place the extracted bit at the mirrored position from the left
            result |= currBit << (31 - i); 

            n >>>= 1; 
        }
        return result; 
    }
}
