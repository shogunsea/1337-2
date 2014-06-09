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