public class Solution {
    public bool SearchMatrix(int[][] matrix, int target) {
        //treat matrix as 1d array of size n*m
        //m is size of columns
        //low is 0, while high is n*m-1
        //while low is less than high find the mid, l + (h-l)/2
        //get position of mid, row is mid/m, col is mid % m 
        //if matrix[row][col] > target, high = mid - 1
        //if matrix[row][col] < target, low = mid + 1
        //if equal return true, else false

        int n = matrix.Length; 
        int m = matrix[0].Length; 

        int low = 0; 
        int high = n*m - 1;

        while(low <= high){
            int mid = low + (high - low)/2; 

            int row = mid / m; 
            int col = mid % m ;

            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] > target){
                high = mid - 1; 
            }
            else{
                low = mid + 1; 
            }
        } 

        return false; 
    }
}
