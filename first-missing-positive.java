// Given an unsorted integer array, find the first missing positive integer.

// For example,
// Given [1,2,0] return 3,
// and [3,4,-1,1] return 2.

// Your algorithm should run in O(n) time and uses constant space.

public class Solution {
	// Find the first missing positive integer, meaning we 
	// should start checking from 1, and for an input 
	// array of size N, the missing integer should not be
	// larger than N+1.
	// For example: A = {1,2,3} N = 3, we have N+1 = 4 missing
	// with elements in A being all increasing integers starting
	// with 1. If A = {1,2, 130}. 3 is missing. So we just need
	// to map all values in A to a similar size array.
    public int firstMissingPositive(int[] A) {
    	int len = A.length;
    	if(len == 0) return 1;

    	int[] dp = new int[len + 1];

    	for(int i = 0; i < len; i++){
    		if(A[i] > 0 && A[i] <= len){
    			dp[A[i]] = 1;
    		}
    	}

    	int miss = 1;

    	for(int i = 1; i <= len; i++){
    		if(dp[i] == 0){
    			miss = i;
    			break;
    		}

    		if(dp[i] == 1 && i == len){
    			miss = i + 1;
    			break;
    		}
    	}

    	return miss;
    }
}




public class Solution {
    // O(n) time adn O(n) space solution.
    // public int firstMissingPositive(int[] A) {
    //     int len = A.length;

    //     if (len == 0) {
    //      return 1;
    //     }

    //     HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    //     for (int i : A) {
    //      map.put(i, 0);
    //     }

    //     for (int i = 0; i < len; i++) {
    //      if (!map.containsKey(i + 1)) {
    //          return i + 1;
    //      }
    //     }

    //     return len + 1;
    // }

    public int firstMissingPositive(int[] A) {
        int len = A.length; 

        if (len == 0) {
            return 1;
        }

        int pos = -1;

        for (int i = 0; i < len; i++) {
            if (A[i] > 0) {
                // swap positive values to left half of the array.
                int temp = A[++pos];
                A[pos] = A[i];
                A[i] = temp;
            }
        }

        
        for (int i = 0; i <= pos; i++) {
            // why use abs here: cound be negated by pos index that appeared
            // before it.
            int posIndex = Math.abs(A[i]) - 1;
            // if posIndex is greater than pos, we dont bother to go further,
            // becauze after pos index, all elemnts are negative, and we dont care
            // about elemnts that appear after first missing positive.
            if (posIndex > pos) {
                continue;
            } else {
                A[posIndex] = A[posIndex] < 0? A[posIndex] : -A[posIndex];
            }
        }

        // next index, if no missing.
        int miss = pos + 1;

        for (int i = 0; i <= pos; i++) {
            if (A[i] > 0) {
                miss = i;
                break;
            }
        }

        // index to number.
        return miss + 1;

    }

}