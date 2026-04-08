class Solution {
    public int trap(int[] height) {
        //two pointers
        //create two arrays, max height on the left and 
        //max heights on the right 
        //the find the minimum between the values at i between the two new arrays 
        //thats the potential amount that can be stored 
        //then sum = potential - height

        int l = 0; 
        int r = 0; 
        int n = height.length; 

        int[] maxL = new int[n];  
        int[] maxR = new int[n]; 

        for(int i = 0; i < n; i++){
            int j = n - i - 1;     //head backwards
            
            maxL[i] = l; 
            maxR[j] = r; 

            l = Math.max(l, height[i]); 
            r = Math.max(r, height[j]); 

        }

        int sum = 0; 

        for(int i = 0; i < n; i++){
            int pot = Math.min(maxL[i], maxR[i]); 

            sum += Math.max(0, pot - height[i]); 
        }

        return sum; 
    }
}
