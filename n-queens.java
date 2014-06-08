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

public class Solution {
    public List<String[]> solveNQueens(int n) {
        
        int[] dp = new int[n];
        StringBuilder sb= new StringBuilder();
        List<String[]> lists = new ArrayList<String[]>();

        // i represents the col index of first row.
        for(int i = 0; i < n; i++){
        	dp = new int[n];
        	// set the last row as no-placement.
        	dp[n - 1] = -1;
        	dp[0] = i;

        	// rows under first row.
        	int j = 1;
        	for(; j < n; j++){
        		// check each column.
        		for(int k = 0; k < n; k++){
        			// check collision with previous rows.
        			int m = 0;
        			for(; m < j; m++){
        				// relationship between (m, dp[m]) && (j, k)
        				boolean collision = dp[m] == k || Math.abs(m - j) == Math.abs(dp[m] - k);
        				if(collision){
        					break;
        				}
        			}

        			if(m == j - 1){
        				dp[j] = k;
        				break;
        			}
        		}
        	}

        	// if(last row has placement){
    		if(dp[n - 1] != -1){
    			// transform the solution and add it to the list.
    			String[] solution = new String[n];
    			for(int ii = 0; ii < n; ii++){
    				for(int jj = 0; jj < n; jj++){
    					if(dp[ii] == jj){
    						sb.append('Q');
    					}else{
    						sb.append('.');
    					}
    				}
    				solution[ii] = sb.toString();
    				sb = new StringBuilder();
    			}

    			lists.add(solution);
    		}
        }

        return lists;
    }
}