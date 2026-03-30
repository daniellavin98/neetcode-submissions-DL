class Solution {
    public int maxArea(int[] heights) {
        
        // Linear Time solution
        // two pointer solution 
        // l is at 0, r is at the end 
        // The area is the width x height(smaller side) 
        // while the l < r, get the area, if area is greater than result, result is area 
        // if height of l is less than height of r, increment l 

     

        int l = 0; 
        int r = heights.length - 1;

        int result = 0;  

        while(l < r){
            int area = (r-l) * Math.min(heights[l], heights[r]); 

            result = Math.max(area, result); 

            if(heights[l] < heights[r]){
                l++; 
            }
            else{
                r--;
            }
        }

        return result;

    }
}
