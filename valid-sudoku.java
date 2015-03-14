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



public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
        	for (int j = 0; j < 9; j++) {
        		if (board[i][j] != '.') {
        			if (!isLocalValid(board, i, j)) {
        				return false;
        			}
        		}
        	}
        }

        return true;
    }

    public boolean isLocalValid(char[][] board, int row, int col) {
    	// check row, col, 3*3 sub matrix valid or not.
    	int[] count = new int[9];
    	// row validation:
		for(int j = 0; j < 9; j++) {
			if (board[row][j] == '.') {
				continue;
			}

			int tempIndex = board[row][j] - '0' - 1;
			if (count[tempIndex] != 0) {
				return false;
			} else {
				count[tempIndex] = 1;
			}
		}

		count = new int[9];
		// col validation.
		for (int i = 0; i < 9; i++) {
			if (board[i][col] == '.') {
				continue;
			}

			int tempIndex = board[i][col] - '0' - 1;

			if (count[tempIndex] != 0) {
				return false;
			} else {
				count[tempIndex] = 1;
			}
		}

		count = new int[9];
		// check 3 * 3 submatrix.
		int rowStart = (row / 3) * 3;
		int colStart = (col / 3) * 3;

		for (int i = rowStart; i < rowStart + 3; i++) {
			for (int j = colStart; j < colStart + 3; j++) {
				if (board[i][j] == '.') {
					continue;
				}

				int tempIndex = board[i][j] - '0' - 1;

				if (count[tempIndex] != 0) {
					return false;
				} else {
					count[tempIndex] = 1;
				}
			}
		}

		return true;
    }
}



public class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0);
    }

    public boolean solve(char[][] board, int n) {
        if (n == 81) {
            return true;
        }

        int x = n / 9;
        int y = n % 9;

        if (board[x][y] == '.') {
            char c = board[x][y];
            for (char a = '1'; a <= '9'; a++) {
                board[x][y] = a;
                if (isValid(board, x, y) && solve(board, n + 1)) {
                    return true;
                }
                board[x][y] = c;
            }
            return false;
        } else {
            if (solve(board, n + 1)) {
                return true;
            }
            return false;
        }
    }

    public boolean isValid(char[][] board, int x, int y){
        // dont have to count all occurrances in row/col/submatrix.
        // just check if current char has dups.
        char c = board[x][y];
        for (int i = 0; i < 9; i++) {
            if (i != x && board[i][y] == c) {
                return false;
            }
            if (i != y && board[x][i] == c) {
                return false;
            }
        }

        int xx = x / 3 * 3;
        int yy = y / 3 * 3;

        for (int i = xx; i < xx + 3; i++) {
            for (int j = yy; j < yy + 3; j++) {
                if (x != i && y != j && board[i][j] == c) {
                    return false;
                }
            }
        }

        return true;

    }
}