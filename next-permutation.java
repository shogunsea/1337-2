// Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

// If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

// The replacement must be in-place, do not allocate extra memory.

// Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
// 1,2,3 → 1,3,2
// 3,2,1 → 1,2,3
// 1,1,5 → 1,5,1

public class Solution {
    // This problem is more clearly illustrated by drawing a histogram of input 
    // array.
    // 'next': means smallest number that is greater than the current number.
    // The idea is that find a couple such that voilates the increasing order(from end to head of array),
    // that is left elemnt smaller than right element, swap them would produce a greater number, 
    // but not the smallest one, we have to reverse all the numbers on right of left element(which maintain the increasing property, left greater
    // than right), this number would be the possible smallest permutation that is greater than original number.
    // Last question here is that which left and right index to pick? We pick such couple that left index is largest one(the digit 
    // which has the least weight) --> to maintains that we get next greater number as small as possible. 
    public void nextPermutation(int[] num) {
         int len = num.length;

        if(len <= 1) return;

        int left = Integer.MIN_VALUE;
        int right = 0;

        for(int r = len - 1; r > 0; r--){
            for(int l = r - 1; l >= 0; l--){
                if(num[l] < num[r]){
                    if(left == Integer.MIN_VALUE){
                        left = l;
                        right = r;
                        continue;
                    }
                    if(l > left){
                        left = l;
                        right = r;
                    }
                }
            }
        }

        if(left != Integer.MIN_VALUE){
            //swap left and right then revse the rest.
            int l = num[left];
            num[left] = num[right];
            num[right] = l;
            reverse(num, left + 1);
        }else{
            reverse(num, 0);
        }
    }

    public void reverse(int[] num,int start){
        for(int i=start;i<=num.length-1-i+start;i++){
            int temp = num[i];
            int k = num.length-1-i+start;
            num[i] = num[k];
            num[k] = temp;
        }
        
    }
}

// 4354
// 4534
// 4435



// 4354
// 4453
// 4435


public class Solution {
    public void nextPermutation(int[] num) {
        int len = num.length;
        if(len == 0){
            return;
        }
        
        // left index: starting from end, first element that is smaller 
        // than its right elemnt.
        // right index: after we found left index, we find the smallest right element.
        int left = -1;
        int right = -1;
        for(int i = len - 2; i >= 0; i--){
            if(num[i] < num[i + 1]){
                // i should be left index.
                left = i;
                // search for right index.
                right = left + 1;
                for(int j = i + 1; j < len; j++){
                    if(num[j] > num[left]){
                        right = j;
                    }
                }
                break;
            }
        }
        
        if(left == -1){
            // if all array is decreasing: 321 -> 123, reverse the whole array
            reverse(num, 0, len - 1);
        }else{
            swap(num, left, right);
            reverse(num, left + 1, len - 1);
        }
    }
    
    public void swap(int[] num, int left, int right){
        num[left] ^= num[right];
        num[right] ^= num[left];
        num[left] ^= num[right];
    }
    
    public void reverse(int[] num, int start, int end){
        while(start < end){
            swap(num, start++, end--);
        }
    }
}

