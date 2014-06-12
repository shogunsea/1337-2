// Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

// A region is captured by flipping all 'O's into 'X's in that surrounded region.

// For example,
// X X X X
// X O O X
// X X O X
// X O X X
// After running your function, the board should be:

// X X X X
// X X X X
// X X X X
// X O X X

public class Solution {
    public void solve(char[][] board) {
    	int row = board.length;
    	
    	if(row == 0){
    		return;
    	}

    	int col = board[0].length;
    	Queue<Integer> q = new LinkedList<Integer>();

		for(int j = 0; j < col; j++){
			flip(q, board, 0, j, row, col);
			flip(q, board, row - 1, j, row, col);
		}

    	for(int i = 0; i < row; i++){
			flip(q, board, i, 0, row, col);
			flip(q, board, i, col - 1, row, col);
		}

		while(!q.isEmpty()){
			int pos = q.poll();
			int x = pos / col;
			int y = pos - x * col;

			if(board[x][y] == 'O') board[x][y] = 'P';

			flip(q, board, x + 1, y, row, col);
			flip(q, board, x - 1, y, row, col);
			flip(q, board, x, y + 1, row, col);
			flip(q, board, x, y - 1, row, col);
		}

		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(board[i][j] == 'X') continue;
				if(board[i][j] == 'O'){
					board[i][j] = 'X';
				}else{
					// 'P'
					board[i][j] = 'O';
				}
			}
		}

		return;
	}

	public void flip(Queue<Integer> q, char[][] board, int row, int col, int rowMax, int colMax){
		if(row <  0 || row > rowMax - 1 || col < 0 || col > colMax - 1) return;

		if(board[row][col] != 'O') return;

		q.add(row * colMax + col);
	}
}