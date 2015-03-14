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



public class Solution {
    public List<String[]> solveNQueens(int n) {
        List<String[]> res = new ArrayList<String[]>();
        // try to fill the first row by each possible index.
        int[] qPosition = new int[n];

        // what should be a proper condition?
        if (n < 1) {
            return res;
        }

        // initialize the initial index for each row as -1.
        for (int i = 0; i < n; i++) {
            qPosition[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            qPosition[0] = i;
            dfsHelper(res, qPosition, 1);
            // backtracking.
            qPosition[0] = -1;
        }

        return res;
    }

    public void dfsHelper(List<String[]> res, int[] qPosition, int row) {
        if (row == qPosition.length) {
            // find a valid match. build a string array base
            // on the value of qposition.
            String[] temp = new String[qPosition.length];

            for (int i = 0; i < qPosition.length; i++) {
                // board is n by n.
                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < qPosition.length; j++) {
                    if (qPosition[i] == j) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }

                temp[i] = sb.toString();
            }

            res.add(temp);

            return;
        }

        // when trying all indexes at current row, should
        // check all rows above current row, dont have to check
        // whether if they are in the same row, just need to
        // check if they are in the same col, and diagonals.
        for (int i = 0; i < qPosition.length; i++) {
            // try all possible indexes at current row.
            if (isValid(qPosition, row, i)) {
                qPosition[row] = i;
                dfsHelper(res, qPosition, row + 1);
                // revert back to default value.
               qPosition[row] = -1;
            } 
        }
    }

    public static boolean isValid(int[] qPosition, int curRow, int curCol) {
        for (int preRow = 0; preRow < curRow; preRow++) {
            int preCol = qPosition[preRow];

            if (preCol == curCol) {
                // in the same col;
                return false;
            }

            // check diagonal.
            int colDiff = Math.abs(curCol - preCol);
            int rowDiff = Math.abs(curRow - preRow);

            if (colDiff == rowDiff) {
                return false;
            }
        }
        
        return true;
    }
}

