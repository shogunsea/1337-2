// Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

// The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


// A partially filled sudoku which is valid.

// Note:
// A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

public class Solution {
    public boolean isValidSudoku(char[][] board) {
		int n = 9;

		if(board.length != n) return false;

		// check rows and cols first, at the same time. use O(n2) loop, scan the matrix once.
		for(int i = 0; i < n; i++){
			int[] rowCol = new int[n];
			int[] colRow = new int[n];
			for(int j = 0; j < n; j++){
				if(board[i][j] != '.'){
					int num = board[i][j] - '1';
					if(rowCol[num] == 1){
						return false;
					}else{
						rowCol[num] = 1;
					}
				}

				if(board[j][i] != '.'){
					int num = board[j][i] - '1';
					if(colRow[num] == 1){
						return false;
					}else{
						colRow[num] = 1;
					}
				}
			}
		}

		// check 3*3 grids
		for(int i = 0; i < n; i++){
			int[] count = new int[n];
			for(int x = 0; x < 3; x++){
				for(int y = 0; y < 3; y++){
					int absX = x + (i / 3) * 3;
					int absY = y + (i % 3) * 3;
                    
                    if(board[absX][absY] != '.'){
                        int num = board[absX][absY] - '1';
    					if(count[num] == 1){
    						return false;
    					}else{
    						count[num] = 1;
    					} 
                    }
				}
			}
		}

		return true;
    }
}