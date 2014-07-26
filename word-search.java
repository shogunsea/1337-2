// Given a 2D board and a word, find if the word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

// For example,
// Given board =

// [
//   ["ABCE"],
//   ["SFCS"],
//   ["ADEE"]
// ]
// word = "ABCCED", -> returns true,
// word = "SEE", -> returns true,
// word = "ABCB", -> returns false.

public class Solution {
    public boolean exist(char[][] board, String word) {
        int len = word.length();
        if(len == 0){
        	return false;
        }

        int row = board.length;
        int col = board[0].length;
        
        if(len > row * col) return false;

        boolean[][] used = new boolean[row][col];

        for(int i = 0; i < row; i++){
        	for(int j = 0; j < col; j++){
        		if(word.charAt(0) == board[i][j]){
        			if(dfs(board, used, i, j, word, 0)){
        				return true;
        			}
        		}
        	}
        }

        return false;
    }

    public boolean dfs(char[][] board, boolean[][] used, int row, int col, String word, int index){
    	if(row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1 || used[row][col]) return false;
    	if(word.charAt(index) == board[row][col] && !used[row][col]){
    		used[row][col] = true;

    		if(index == word.length() - 1) return true;

    		// LOL only this way JAVA solution will pass. The commented one will TLE.. So you have a idea of JAVA's optimization.
    		boolean result = dfs(board, used, row - 1, col, word, index + 1) || dfs(board, used, row + 1, col, word, index + 1) || dfs(board, used, row, col - 1, word, index + 1) || dfs(board, used, row, col + 1, word, index + 1);
    		// // go up.
    		// boolean up = dfs(board, used, row - 1, col, word, index + 1);
    		// // go down.
    		// boolean down = dfs(board, used, row + 1, col, word, index + 1);
    		// // go left.
    		// boolean left = dfs(board, used, row, col - 1, word, index + 1);
    		// // go right.
    		// boolean right = dfs(board, used, row, col + 1, word, index + 1);

    		used[row][col] = false;
    		return result;

    	}else{
    		return false;
    	}
    }
}