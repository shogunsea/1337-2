// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

// Note: You can only move either down or right at any point in time.

public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0) return 0;

        int row = grid.length;
        int col = grid[0].length;

        int[][] dp = new int[row][col];

        for(int i = 0; i < row; i++){
        	if(i == 0){
        		dp[i][0] = grid[i][0];
        	}else{
        		dp[i][0] = dp[i - 1][0] + grid[i][0];
        	}
        }

        for(int j = 0; j < col; j++){
        	if(j == 0){
        		dp[0][j] = grid[0][j];
        	}else{
        		dp[0][j] = grid[0][j] + dp[0][j - 1];
        	}
        }

        for(int i = 1; i < row; i++){
        	for(int j = 1; j < col; j++){
        		dp[i][j] = dp[i - 1][j] < dp[i][j - 1]? grid[i][j] + dp[i - 1][j] : grid[i][j] + dp[i][j - 1];
        	}
        }

        return dp[row - 1][col - 1];
    }
        
    }
}