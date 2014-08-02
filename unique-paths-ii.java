// Follow up for "Unique Paths":

// Now consider if some obstacles are added to the grids. How many unique paths would there be?

// An obstacle and empty space is marked as 1 and 0 respectively in the grid.

// For example,
// There is one obstacle in the middle of a 3x3 grid as illustrated below.

// [
//   [0,0,0],
//   [0,1,0],
//   [0,0,0]
// ]
// The total number of unique paths is 2.

// Note: m and n will be at most 100.

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        
        if(row == 0) return 0;
        
        int col = obstacleGrid[0].length;

        int[][] paths = new int[row][col];

		for(int i = 0; i <row; i++){
			if(obstacleGrid[i][0] == 1) break;

			paths[i][0] = 1;
		}

		for(int j = 0; j < col; j++){
			if(obstacleGrid[0][j] == 1) break;

			paths[0][j] = 1;
		}

		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(obstacleGrid[i][j] == 1) continue;
				paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
			}
		}

		return paths[row - 1][col - 1];
    }
}