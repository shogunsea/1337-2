// Follow up for "Search in Rotated Sorted Array":
// What if duplicates are allowed?

// Would this affect the run-time complexity? How and why?

// Write a function to determine if a given target is in the array.

public class Solution {
    public boolean search(int[] A, int target) {
        int len = A.length;

        if(len == 0) return false;

        int left = 0;
        int right = len - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(A[mid] == target) return true;

            if(A[mid] < A[right]){
                // if right half is sorted
                if(target <= A[right] && target > A[mid]){
                    // if target is in the right half
                    left = mid + 1;
                }else{
                    // if target is not in the right half, we cut it.
                    right = mid - 1;
                }
            }else if(A[mid] > A[left]){
                // if left half is sorted
                if(A[mid] > target && A[left] <= target){
                    // if target is in the right half
                    right = mid - 1;
                }else{
                    // if target value is not in the right half.
                    left = mid + 1;
                }
            }else if(A[mid] == A[right]){
                right--;
            }else if(A[mid] == A[left]){
                left++;
            }
        }

        return false;        
    }
}