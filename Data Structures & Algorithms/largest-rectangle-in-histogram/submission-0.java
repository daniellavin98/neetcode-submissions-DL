class Solution {
    //if they are a histogram - bars are joint together 
    //so to get an area, the next value must be equal or greater than  
    //so create a stack of arrays - get the height value and the position, 
    //stack must be in ascending order - monotonic 
    //once you encounter a value that is less than the peek - 
    //area is peek * difference between positions 
    //put this as max area, repeat 
    //return max area

    //Time - O(n)
    //Space - O(n)

    

    public int largestRectangleArea(int[] heights) {

        int n = heights.length; 
        int maxArea = 0; 

        Stack<int []> stack = new Stack<>(); 

        for(int i = 0; i < n; i++){
            int height = heights[i]; 
            int start = i; 

            while(!stack.isEmpty() && height < stack.peek()[0]){
                int[] popped = stack.pop(); 

                int h = popped[0]; 
                int j = popped[1]; 

                int w = i - j; 

                int area = h * w; 

                maxArea = Math.max(maxArea, area); 
                start = j; 
            }

            stack.push(new int[]{height, start}); 
        }

        //there may be stuff left on stack 
        while(!stack.isEmpty()){
            int[] popped = stack.pop(); 

            int h = popped[0]; 
            int j = popped[1];

            int w = n - j; 

            int area = h * w; 

            maxArea = Math.max(maxArea, area); 
        }

        return maxArea;


    }
}
