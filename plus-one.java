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