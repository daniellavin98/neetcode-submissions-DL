class Solution {
    public boolean isValidSudoku(char[][] board) {
        //Don't want duplicates, hash set because it can't handle duplucates 
        //could use a hash set for rows and one for columns 
        //make a new hash set for each row and column

        //length is 9 

        //Validate Rows 
        for(int i = 0; i < 9; i++){
            HashSet<Character> row = new HashSet<>();
            for(int j = 0; j < 9; j++){
                char item = board[i][j]; 

                if(row.contains(item)){
                    return false; 
                }
                else if(item != '.'){
                    row.add(item); 
                }
            }
        }

        //Validate Columns 
        for(int i = 0; i < 9; i++){
            HashSet<Character> col = new HashSet<>();
            for(int j = 0; j < 9; j++){
                char item = board[j][i]; 

                if(col.contains(item)){
                    return false; 
                }
                else if(item != '.'){
                    col.add(item); 
                }
            }
        }

        // Validate 3x3 Sub-grids
        int[][] boxes = {{0, 0}, {0, 3}, {0, 6},
                          {3, 0}, {3, 3}, {3, 6},
                          {6, 0}, {6, 3}, {6, 6}};

        
        for(int[] box : boxes){
            HashSet<Character> boxSet = new HashSet<>();
            for(int row = box[0]; row < box[0]+3; row++){
                for(int col = box[1]; col < box[1]+3; col++){
                    char item = board[row][col]; 

                    if(boxSet.contains(item)){
                        return false; 
                    }
                    else if(item != '.'){
                        boxSet.add(item); 
                    }
                }
            }
        }

        return true;

    }
}
