// Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

// Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

// Note:
// You are not suppose to use the library's sort function for this problem.


public class Solution {
    public void sortColors(int[] A) {
        int len = A.length;

        if(len == 0){
        	return;
        }

        int zero = 0;
        int two = len - 1;
        int tmp;

        for(int i = 0; i <= two; i++){
        	if(A[i] == 1){
        		continue;
        	}

        	if(A[i] == 0){
        		tmp = A[i];
        		A[i] = A[zero];
        		A[zero++] = tmp;
        	}else{
        		tmp = A[i];
        		A[i] = A[two];
        		A[two--] = tmp;
        		i--;
        	}
        }
    }
}