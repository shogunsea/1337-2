// Suppose a sorted array is rotated at some pivot unknown to you beforehand.

// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

// You are given a target value to search. If found in the array return its index, otherwise return -1.

public class Solution{
    public int search(int[] A, int target){
        //if only one pivot exists in the array and no duplicates.
        int len = A.length;

        if(len == 0) return -1;

        int left = 0;
        int right = len - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(A[mid] == target){
                return mid;
            }else if(A[mid] <= A[right]){
                // if right half is sorted
                if(target <= A[right] && target > A[mid]){
                    // target value is in right half.
                    left = mid + 1;
                }else{
                    // though right half is sorted, but target value is still in left half.
                    right = mid - 1;
                }
            }else if(A[mid] >= A[left]){
                // if left half is sorted
                if(target >= A[left] && target < A[mid]){
                    // target value is in left half.
                    right = mid -1;
                }else{
                    // target value is in right half.
                    left = mid + 1;
                }
            }
        }
        return -1;  
    }

}