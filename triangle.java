// Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

// For example, given the following triangle
// [
//      [2],
//     [3,4],
//    [6,5,7],
//   [4,1,8,3]
// ]
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

// Note:
// Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.


// Space : O(2n * n) --> O(n2) space.

// public class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         if(triangle == null || triangle.size() == 0) return 0;

//         int level = triangle.size();

//         for(int i = 1; i < level; i++){
//         	List<Integer> previous = triangle.get(i - 1);
//         	List<Integer> current = triangle.get(i);

//         	for(int j = 0; j < current.size(); j++){
//         		if(j == 0){
//         			current.set(j, previous.get(0) + current.get(j));
//         		}else if(j == current.size() - 1){
//         			current.set(j, current.get(j) + previous.get(previous.size() - 1));
//         		}else{
// 	        		int left = previous.get(j - 1);
// 	        		int right = previous.get(j);

// 	        		current.set(j, left > right? right + current.get(j) : left + current.get(j));	
//         		}
//         	}
//         }

//         int min = Integer.MAX_VALUE;

//         for(int i : triangle.get(level - 1)){
//         	min = min > i? i : min;
//         }

//         return min;
//     }
// }

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }
        
        int len = triangle.size();
        List<Integer> min = triangle.get(triangle.size() - 1);
        
        for(int i = len - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                min.set(j, min.get(j) < min.get(j + 1)? triangle.get(i).get(j) + min.get(j) : triangle.get(i).get(j) + min.get(j + 1)); 
            }
        }
        
        return min.get(0);
    }
}