// Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.

public class Solution {
    public int maximalRectangle(char[][] matrix) {
    	int row = matrix.length;
    	if(row == 0) return row;
    	int col = matrix[0].length;

    	// 2D matrix for storing the vertical/horizontal area acumulation. Here we
    	// choose the horizaltol approach.
    	int[][] dp = new int[row][col];

    	// initialize first col
    	for(int i = 0; i < row; i++){
    			dp[i][0] = matrix[i][0] == '1'? 1 : 0;
		}

		// fill the dp matrix, based on value at (i,j) in input matrix
    	for(int i = 0; i < row; i++){
    		for(int j = 1; j < col; j++){
    			dp[i][j] = matrix[i][j] == '1'? dp[i][j - 1] + 1 : 0;
    		}
    	}

    	int maxArea = 0;

    	// scan dp matrix again, for each element (i, j) check all valid 
    	// rectangles with (i, j) as right bottom corner. 
    	// How to identify valid: dp[i][j] != 0
    	for(int i = 0; i < row; i++){
    		for(int j = 0; j < col; j++){
    			int k = i;
    			int width = Integer.MAX_VALUE;

    			// starting from kth line until ith line.
    			while(k >= 0){
    				if(dp[k][j] == 0){
    					break;
    				}

    				// keep min value as width, width at (k,j) cound be larger than
    				// element value at initial k=i index.
    				width = Math.min(width, dp[k][j]);
    				int height = i - k + 1;
    				maxArea = Math.max(maxArea, width * height);
    				k--;
    			}
    		}
    	}

    	return maxArea;
    }
}