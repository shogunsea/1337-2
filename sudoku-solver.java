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