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
        	int tmpMax = 0;
        	int duplicates = 1;

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

        	for(int n : slopeCount.values()){
        		tmpMax = tmpMax > i? tmpMax : n;
        	}

        	tmpMax += duplicates;
        	maxPoint = maxPoint > tmpMax? maxPoint : tmpMax;
        }

        return maxPoint;
    }
}
