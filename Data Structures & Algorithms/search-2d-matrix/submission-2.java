class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //treat matrix as 1d array of size n*m
        //m is size of columns
        //low is 0, while high is n*m-1
        //while low is less than high find the mid, l + (h-l)/2
        //get position of mid, row is mid/m, col is mid % m 
        //if matrix[row][col] > target, high = mid - 1
        //if matrix[row][col] < target, low = mid + 1
        //if equal return true, else false

        int n = matrix.length; 
        int m = matrix[0].length; 

        int l = 0; 
        int r = n*m - 1; 

        while(l <= r){
            int mid = l + (r - l)/2; 

            int row = mid / m; 
            int col = mid % m; 

            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] > target){
                r = mid - 1; 
            }
            else{
                l = mid + 1;
            }
        }

        return false; 
    }
}
