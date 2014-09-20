// Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

// You may assume no duplicates in the array.

// Here are few examples.
// [1,3,5,6], 5 → 2
// [1,3,5,6], 2 → 1
// [1,3,5,6], 7 → 4
// [1,3,5,6], 0 → 0

public class Solution {
    public int searchInsert(int[] A, int target) {
        int len = A.length;
        if(len == 0){
            return 0;
        }
        int start = 0;
        int end = len - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(A[mid] == target){
                return mid;
            }else if(A[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        
        if(A[end] < target){
            return end + 1;
        }else if(A[start] >= target){
            return start;
        }else{
            return start + 1;
        }
    }
}