// The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



// Given an integer n, return all distinct solutions to the n-queens puzzle.

// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

// For example,
// There exist two distinct solutions to the 4-queens puzzle:

// [
//  [".Q..",  // Solution 1
//   "...Q",
//   "Q...",
//   "..Q."],

//  ["..Q.",  // Solution 2
//   "Q...",
//   "...Q",
//   ".Q.."]
// ]
public class Solution{
    public ArrayList<String[]> solveNQueens(int n){
        ArrayList<String[]> solution = new ArrayList<String[]>();
        if(n == 0){
            return solution;
        }

        int[] cols = new int[n];

        helper(solution, 0, cols);
        return solution;
    }

    public void helper(ArrayList<String[]> solution, int row, int[] cols){
        int n = cols.length;
        if(row == n){
            // found one solution.
            String[] sols = new String[n];

            for(int i = 0; i < n; i++){
                StringBuilder sb = new StringBuilder();
                for(int col = 0; col < n; col++){
                    if(cols[i] == col){
                        sb.append('Q');
                    }else{
                        sb.append('.');
                    }
                }

                sols[i] = sb.toString();
            }

            solution.add(sols);
            return;
        }

        for(int col = 0; col < n; col++){
            if(isValid(cols, row, col)){
                cols[row] = col;
                helper(solution, row + 1, cols);
            }
        }
    }

    public boolean isValid(int[] cols, int row, int col){
        for(int preRow = 0; preRow < row; preRow++){
            if(col == cols[preRow] || Math.abs(row - preRow) == Math.abs(col - cols[preRow])){
                return false;
            }
        }
        return true;
    }
}












