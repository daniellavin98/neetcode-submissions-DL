class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        //Create a stack of doubles
        Stack<Double> stack = new Stack<>(); 

        //join the two arrays
        int[][] vector = new int[position.length][2]; 

        for(int i = 0; i < position.length; i++){
            vector[i][0] = position[i]; 
            vector[i][1] = speed[i]; 
        }
        //sort array in descending order based on position
        Arrays.sort(vector, (a, b) -> Integer.compare(b[0], a[0])); 

        for(int[] v : vector){
            //calculate time
            stack.push((double) (target-v[0])/v[1]); 

            //check whether part of same fleet
            //push time to stack
            //check if time (new peek) is less than or equal time before
            //it means they are part of same fleet
            //pop the peek 
            if(stack.size() >= 2 && stack.peek() <= stack.get(stack.size()-2)){
                stack.pop(); 
            }

        }
        return stack.size(); 
    }

}
