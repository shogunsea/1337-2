public class Solution {
    public int findMin(int[] num) {
        // binary search.
        // T(n) = T(n / 2) + O(1) ----> T(N) = O(logN)
        int len = num.length;
        if (len == 1) {
        	return num[0];
        }

        return minHelper(num, 0, len - 1);
    }

    public int minHelper(int[] num, int start, int end) {
    	if (start + 1 == end) {
    		return num[start] < num[end]? num[start] : num[end];
    	}

    	int mid = start + (end - start) / 2;

    	// at least one half is sorted.
    	if (num[start] <= num[mid]) {
    		int leftMin = num[start];
    		int rightMin = minHelper(num, mid, end);
    		return leftMin < rightMin? leftMin : rightMin;
    	} else {
    		int rightMin = num[mid];
    		int leftMin = minHelper(num, start, mid);
    		return leftMin < rightMin? leftMin : rightMin;
    	}
    }
}