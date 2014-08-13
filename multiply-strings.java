// Given two numbers represented as strings, return multiplication of the numbers as a string.

// Note: The numbers can be arbitrarily large and are non-negative.

public class Solution {
    public String multiply(String num1, String num2) {
    	int len1 = num1.length();
    	int len2 = num2.length();

    	if(len1 == 0 || len2 == 0){
    		return "";
    	}

    	int[] num = new int[len1 + len2];

    	for(int i = len1 - 1; i >= 0; i--){
    		int carry = 0;
    		int product = 0;
    		int j = len2 - 1;

    		for(; j >= 0; j--){
    			int first = num1.charAt(i) - '0';
    			int second = num2.charAt(j) - '0';
    			product = carry + num[i + j + 1] + first * second;
    			num[i + j + 1] = product % 10;
    			carry = product / 10;
    		}

    		num[i + j + 1] = carry;
    	}

    	StringBuilder sb = new StringBuilder();

    	for(int i = 0; i < num.length; i++){
    		if(num[i] != 0){
    			for(int j = i; j < num.length; j++){
    				sb.append(num[j]);
    			}
    			break;
    		}
    		if(i == num.length - 1) sb.append('0');
    	}

    	return sb.toString();
    }
}