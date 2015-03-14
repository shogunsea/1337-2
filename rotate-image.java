// You are given an n x n 2D matrix representing an image.

// Rotate the image by 90 degrees (clockwise).

// Follow up:
// Could you do this in-place?

public class Solution {
	private class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

    public void rotate(int[][] matrix) {
       	int n = matrix.length;

       	if(n == 0){
       		return;
       	}

       	Point A, B, C, D;

       	for(int layer = 0; layer <= (n / 2) - 1; layer++){
       		int times = n - layer * 2 - 1;
       		A = new Point(layer, layer);
       		B = new Point(layer, layer + times);
       		C = new Point(layer + times, layer + times);
       		D = new Point(layer + times, layer);

       		while(times > 0){
       			int temp = matrix[A.x][A.y];
       			matrix[A.x][A.y] = matrix[D.x][D.y];
       			// A goes right.
       			A.y++;

       			matrix[D.x][D.y] = matrix[C.x][C.y];
       			// D goes up.
       			D.x--;

       			matrix[C.x][C.y] = matrix[B.x][B.y];
       			// C goes left.
       			C.y--;

       			matrix[B.x][B.y] = temp;
       			// B goes down.
       			B.x++;

       			times--;
       		}
       	}
    }
}



public class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length;

        if (row == 0) {
            return;
        }

        int col = matrix[0].length;
        int layer = row / 2;
        int count = 0;

        while (count < layer) {
            int[] A = {count, count};// x, y
              int[] B = {count, col - 1 - count};
              int[] C = {row - 1 - count, col - 1 - count};
              int[] D = {row - 1 - count, count};

              while (A[1] < col - 1 - count) {
                  int temp = matrix[A[0]][A[1]];
                  matrix[A[0]][A[1]] = matrix[D[0]][D[1]];
                  matrix[D[0]][D[1]] = matrix[C[0]][C[1]];
                  matrix[C[0]][C[1]] = matrix[B[0]][B[1]];
                  matrix[B[0]][B[1]] = temp;
                  A[1]++;
                  B[0]++;
                  C[1]--;
                  D[0]--;
              }

              count++;
        }

    }
}