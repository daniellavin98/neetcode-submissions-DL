class Solution {
    public int numIslands(char[][] grid) {
        //Use BFS 
        //increment counter when 1 is found 
        //once found, set to 0, 
        //then check if it is connected to other 1s
        //if so, change them to zero

        int count = 0; 

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    count += 1; 
                    bfsHelper(grid, i, j); 
                }
            }
        }

        return count;  
    }

    private void bfsHelper(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0'){
            return; 
        }

        grid[i][j] = '0'; 

        bfsHelper(grid, i+1, j);      //up
        bfsHelper(grid, i-1, j);      //down
        bfsHelper(grid, i, j-1);      //left
        bfsHelper(grid, i, j+1);      //right  
    }
}
