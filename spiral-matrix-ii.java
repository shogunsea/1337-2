// Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

// For example,
// Given n = 3,

// You should return the following matrix:
// [
//  [ 1, 2, 3 ],
//  [ 8, 9, 4 ],
//  [ 7, 6, 5 ]
// ]

public class Solution {
    public int[][] generateMatrix(int n) {
		int[][] m = new int[n][n];

		if(n == 0) return m;

		int startRowCol = 0;
		int endRowCol = n - 1;
		int counter = 1;

		while(startRowCol <= endRowCol){
			if(startRowCol == endRowCol){
				m[startRowCol][startRowCol] = counter;
				break;
			}

			for(int i = startRowCol; i < endRowCol; i++){
				m[startRowCol][i] = counter++;
			}

			for(int i = startRowCol; i < endRowCol; i++){
				m[i][endRowCol] = counter++;
			}

			for(int i = endRowCol; i > startRowCol; i--){
				m[endRowCol][i] = counter++;
			}

			for(int i = endRowCol; i > startRowCol; i--){
				m[i][startRowCol] = counter++;
			}

			startRowCol++;
			endRowCol--;
		}     

		return m;
    }
}

