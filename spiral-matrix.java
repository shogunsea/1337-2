// Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

// For example,
// Given the following matrix:

// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]
// You should return [1,2,3,6,9,8,7,4,5].

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
 		List<Integer> list = new ArrayList<Integer>();

            int row = matrix.length;

            if(row == 0) return list;

            int col = matrix[0].length;
            int coveredLayer = 0;

            while( coveredLayer * 2 < row && coveredLayer * 2 < col){

            	for(int i = coveredLayer; i < (col - coveredLayer); i++){
            		list.add(matrix[coveredLayer][i]);
            	}

            	for(int i = coveredLayer + 1; i < (row - coveredLayer); i++){
            		list.add(matrix[i][col - 1 - coveredLayer]);
            	}

            	// if current sub-matrix only contains one row or one col, then should break,
            	// since all elements in it have been added to the list.
            	if(coveredLayer * 2 + 1 ==row || coveredLayer * 2 + 1 == col){
            		break;
            	}

            	for(int i = col - 1 - coveredLayer - 1; i >= coveredLayer; i--){
            		list.add(matrix[row - 1 - coveredLayer][i]);
            	}

            	for(int i = row - 1 - coveredLayer - 1; i >= coveredLayer + 1; i--){
            		list.add(matrix[i][coveredLayer]);
            	}

            	coveredLayer++;
            }

            return list;
    }
}