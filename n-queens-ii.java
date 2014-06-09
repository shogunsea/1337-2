// Follow up for N-Queens problem.

// Now, instead outputting board configurations, return the total number of distinct solutions.

public class Solution {
    public int totalNQueens(int n) {
    	ArrayList<String[]> solution = new ArrayList<String[]>();
        if(n == 0){
            return 0;
        }

        int[] cols = new int[n];

        helper(solution, 0, cols);
        return solution.size();
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

