// Write a program to solve a Sudoku puzzle by filling the empty cells.

// Empty cells are indicated by the character '.'.

// You may assume that there will be only one unique solution.


// A sudoku puzzle...


// ...and its solution numbers marked in red.

public class Solution {
    public void solveSudoku(char[][] board){
    	solve(board);
	}

	public boolean solve(char[][] board){
		int row = board.length;
		int col = board[0].length;

		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(board[i][j] == '.'){
					for(int k = 1; k <= 9; k++){
						char c = (char)(k + '0');
						board[i][j] = c;

						if(isValid(board, i, j)){
							if(solve(board)){
								return true;
							}
						}
						// its possible that, at current stack level, 
						// no matter what number we put in this spot,
						// it's always invalid, meaning current assignment
						// is wrong, we should set it back and go back to 
						// previous level to try another assignment.
						board[i][j] = '.';
					}
					// if current assignment did not return a valid
					// solution, then it's impossible to be valid
					// with current slot not being solved.
					return false;
				}
			}
		}

		return true;
	}

	public boolean isValid(char[][] board, int row, int col){
		Set<Character> set = new HashSet<Character>();

		// check each row where current element is at.
		for(int i = 0; i < board.length; i++){
			char c = board[i][col]; 
			if(c != '.'){
				if(!set.contains(c)){
					set.add(c);
				}else{
					return false;
				}
			}
		}

		set = new HashSet<Character>();
		// check each col.
		for(int j = 0; j < board[0].length; j++){
			char c = board[row][j];
			if(c != '.'){
				if(!set.contains(c)){
					set.add(c);
				}else{
					return false;
				}
			}
		}

		set = new HashSet<Character>();
		// check 3*3 grid
		int rowUnit = row / 3;
		int colUnit = col / 3;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				int absRow = i + rowUnit * 3;
				int absCol = j + colUnit * 3;
				char c = board[absRow][absCol];
				if(c != '.'){
					if(!set.contains(c)){
						set.add(c);
					}else{
						return false;
					}
				}
			}
		}

		return true;
	}
}


public class Solution {
    public void solveSudoku(char[][] board) {
        int n = board.length;
        if(n != 9){
            return;
        }
        
        dfsHelper(board, 0);
    }    

    public boolean dfsHelper(char[][] board, int pos){
        if (pos == 81) {
            return true;
        }

        int row = pos / 9;
        int col = pos % 9;
        // check if current is not empty, fill it, or just passed down to next 
        // index.
        if (board[row][col] != '.'){
            if (dfsHelper(board, pos + 1)) {
                return true;
            }
        }else{
            // current index is not filled yet.
            for(char k = '1'; k <= '9'; k++){
                board[row][col] = k;
                // if current board is valid then we continue the
                // dfs, otherwise we revert it back.
                if(isValidAt(board, row, col) && dfsHelper(board, pos + 1)){
                    return true;
                }

                board[row][col] = '.';
            }
        }
        
        return false;
    }
    
    public boolean isValidAt(char[][] board, int i, int j){
        // 1-9
        boolean[] occured = new boolean[9];
        // check row
        for(int col = 0; col < 9; col++){
            char c = board[i][col];
            if(c == '.'){
                continue;
            }

            int num = c - '0' - 1;
            if(occured[num]){
                return false;
            }else{
                occured[num] = true;
            }
        }
        // check col
        occured = new boolean[9];
        for(int row = 0; row < 9; row++){
            char c = board[row][j];
            if(c == '.'){
                continue;
            }

            int num = c - '0' - 1;
            if(occured[num]){
                return false;
            }else{
                occured[num] = true;
            }
        }
        // check 3*3 cell.
        occured = new boolean[9];
        int cellX = (i / 3) * 3;
        int cellY = (j / 3) * 3;
        for(int row = cellX; row < cellX + 3; row++){
            for(int col = cellY; col < cellY + 3; col++){
                char c = board[row][col];
                if(c == '.'){
                    continue;
                }
                int num = c - '0' - 1;
                if(occured[num]){
                    return false;
                }else{
                    occured[num] = true;
                }
            }
        }
        return true;
    }
}