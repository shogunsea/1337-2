// Given a non-negative number represented as an array of digits, plus one to the number.

// The digits are stored such that the most significant digit is at the head of the list.

public class Solution {
    public int[] plusOne(int[] digits) {
		return rollOver(digits, digits.length - 1);        
    }

    public int[] rollOver(int[] digits, int index){
    	if(index == -1){
    		// resize
    		int[] resize = new int[digits.length + 1];
    		resize[0] = 1;
    		for(int i = 1; i < resize.length; i++){
    			resize[i] = digits[i - 1];
    		}
    		return resize;
    	}

    	int target = digits[index];

    	if(target + 1 == 10){
    		// carry && recurse
    		digits[index] = 0;
    		return rollOver(digits, index - 1);
    	}

    	digits[index] = target + 1;

    	return digits;
    }

}


public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if (len == 0) {
            return digits;
        }

        // adding from last index, each iteration 
        // relax from right to left based on the carry
        // value.
        int carry = 0;
        for (int i = len - 1; i >= 0; i--) {
            int num = digits[i];
            num += (i == len - 1)? 1 : carry;
            carry = num / 10;
            num %= 10;
            digits[i] = num;
            if (carry == 0) {
                break;
            }
        }

        if (carry != 0) {
            // resize the array.
            int[] res = new int[len + 1];
            for (int i = 1; i < len + 1; i++) {
                res[i] = digits[i - 1];
            }
            res[0] = 1;
            return res;
        } else {
            return digits;
        }
    }
}