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


public class Solution {
    public int[][] generateMatrix(int n) {
        int layer = n / 2;
        // n % 2 == 0 : done.
        // n % 2 != 0 : res[x + 1][y + 1] = nextValue.
        int[][] res = new int[n][n];
        int nextValue = 1;
        int x = -1;
        int y = -1;
        int currentLayer = 0;

        // A..B
        // .  .
        // D..C

        while (currentLayer < layer) {
        	x++;
        	y++;
        	// A to B
        	while (y < n - 1 - currentLayer) {
        		res[x][y++] = nextValue++;
        	}
        	// B to C
        	while (x < n - 1 - currentLayer) {
        		res[x++][y] = nextValue++;
        	}
        	// C to D, current layer as offset.
        	while (y > currentLayer) {
        		res[x][y--] = nextValue++;
        	}
        	// D to A
        	while (x > currentLayer) {
        		res[x--][y] = nextValue++;
        	}

        	currentLayer++;
        }

        if (n % 2 != 0) {
        	res[++x][++y] = nextValue;
        }

        return res;
    }
}
