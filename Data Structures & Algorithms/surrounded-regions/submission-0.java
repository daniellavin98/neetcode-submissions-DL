class Solution {
        //so use dfs -> change O connected to boundary to *
    //then in next pass change * to O, and O to X
    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0) return; 

        int rows = board.length; 
        int cols = board[0].length;

        for(int i = 0; i < rows; i++){
            if(board[i][0] == 'O'){
                dfsHelper(board, i, 0); 
            }
            if(board[i][cols-1] == 'O'){
                dfsHelper(board, i, cols - 1); 
            }
        } 

        for(int j = 0; j < cols; j++){
            if(board[0][j] == 'O'){
                dfsHelper(board, 0, j);
            }
            if(board[rows-1][j] == 'O'){
                dfsHelper(board, rows-1, j); 
            }
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == '*'){
                    board[i][j] = 'O'; 
                }
                else if(board[i][j] == 'O'){
                    board[i][j] = 'X'; 
                }
            }
        }
    }

    private void dfsHelper(char[][] board, int i, int j){

        if(i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1){
            return;
        }

        if(board[i][j] == 'O'){
            board[i][j] = '*'; 
        }

        if(i > 0 && board[i-1][j] == 'O'){
            dfsHelper(board, i-1, j); 
        }

        if(i < board.length - 1 && board[i+1][j] == 'O'){
            dfsHelper(board, i+1, j); 
        }
        if(j > 0 && board[i][j-1] == 'O'){
            dfsHelper(board, i, j-1);
        }
        if(j < board[0].length - 1 && board[i][j+1] == 'O'){
            dfsHelper(board, i, j+1);
        }

        return;
    }
}
