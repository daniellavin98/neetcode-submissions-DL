class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()){
            return false;
        }

        //instead of frequencies with maps, use frequency arrays
        //but the intuition is the same 

        int k = s1.length(); 

        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        for(int i = 0; i < k; i++){
            s1Freq[s1.charAt(i) - 'a']++; 
            s2Freq[s2.charAt(i) - 'a']++; 
        }

        if(Arrays.equals(s1Freq, s2Freq)){
            return true;    
        }

        for(int i = k; i < s2.length(); i++){
            s2Freq[s2.charAt(i) - 'a']++; 
            s2Freq[s2.charAt(i-k) - 'a']--; 

            if(Arrays.equals(s1Freq, s2Freq)){
                return true;
            }
        }

        return false;
        
    }
}
