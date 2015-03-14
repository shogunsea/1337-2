// Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        int len = points.length;
        int maxPoint = 0;
        HashMap<Double, Integer> slopeCount;

        for(int i = 0; i < len; i++){
        	// Iterate over all the points in the array.
        	slopeCount = new HashMap<Double, Integer>();
        	Point first = points[i];
        	int duplicates = 0;

        	for(int j = 0; j < len; j++){
        		// If two comparing points are identical, skip the other one.
        		// Count the number of points at each slope.
        		// At the end of each iteration, iterate over the hashmap and return the max count.
        		if(j == i) continue;

        		Point second = points[j];

        		if(first.x == second.x && first.y == second.y){
        			duplicates++;
        			continue;
        		}

        		double slope = (second.y - first.y) / ((second.x - first.x)*1.0);
        		slopeCount.put(slope, slopeCount.containsKey(slope)? slopeCount.get(slope) + 1 : 1 );
        	}

            int pointsExceptFirst = 0; // assume no other points in the line.
        	for(int n : slopeCount.values()){
        		pointsExceptFirst = pointsExceptFirst > n? pointsExceptFirst : n;
        	}

            // tempMax should be: first point itself, dups, other points.
            int tmpMax = 1 + duplicates + pointsExceptFirst; 

        	maxPoint = maxPoint > tmpMax? maxPoint : tmpMax;
        }

        return maxPoint;
    }
}
