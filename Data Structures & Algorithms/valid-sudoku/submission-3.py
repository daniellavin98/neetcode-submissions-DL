class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        # Don't want duplicates, hash set because it can't handle duplucates 
        # could use a hash set for rows and one for columns 
        # make a new hash set for each row and column

        # length is 9 

        for i in range(9):
            row = set()
            for j in range(9):
                item = board[i][j]

                if item in row:
                    return False
                
                elif item != '.':
                    row.add(item)

        for i in range(9):
            col = set()
            for j in range(9):
                item = board[j][i]

                if item in col:
                    return False
                
                elif item != '.':
                    col.add(item)

            
        boxes = [[0, 0], [0, 3], [0, 6],
                [3, 0], [3, 3], [3, 6],
                [6, 0], [6, 3], [6, 6]]


        for row_start, col_start in boxes:
            box_set = set()

            for row_int in range(row_start, row_start + 3):
                for col_int in range(col_start, col_start + 3):
                    item = board[row_int][col_int]

                    if item in box_set:
                        return False
                    
                    elif item != '.':
                        box_set.add(item)
        
        return True

