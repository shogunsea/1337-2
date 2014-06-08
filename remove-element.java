// Given an array and a value, remove all instances of that value in place and return the new length.

// The order of elements can be changed. It doesn't matter what you leave beyond the new length.

public class Solution {
    public int removeElement(int[] A, int elem) {
        // 1 3 4 4 5, 4
        // 1 3 5 4 5
        int count = 0;

        for(int i = 0; i < A.length; i++){
        	if(A[i] == elem) continue;

        	A[count] = A[i];
        	count++;
        }

        return count;
    }
}