// Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

// click to show follow up.

// Follow up:
// Did you use extra space?
// A straight forward solution using O(mn) space is probably a bad idea.
// A simple improvement uses O(m + n) space, but still not the best solution.
// Could you devise a constant space solution?

public class Solution {
    public void setZeroes(int[][] matrix) {
		// O(mn) solution, use one additional matrix;

		// O(m + n) solution, use two arrays to store the 0s positions.
		int row = matrix.length;

		if(row == 0) return;

		int col = matrix[0].length;

		boolean[] rowIndex = new boolean[row];
		boolean[] colIndex = new boolean[col];

		for(int i = 0; i < row; i++){
			for(int j= 0; j < col; j++){
				// if(rowIndex[i] || colIndex[j]){
				// 	continue;
				// }

				if(matrix[i][j] == 0){
					rowIndex[i] = true;
					colIndex[j] = true;
					// continue;
				}
			}
		}

		for(int i = 0; i < rowIndex.length; i++){
			if(rowIndex[i]){
				// clear a certain row in input matrix.
				for(int j = 0; j < col; j++){
					matrix[i][j] = 0;
				}
			}
		}

		for(int j = 0; j < colIndex.length; j++){
			if(colIndex[j]){
				// same as the above.
				for(int i = 0; i < row; i++){
					matrix[i][j] = 0;
				}
			}
		}

    }
}