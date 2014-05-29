// Implement atoi to convert a string to an integer.

// Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

// Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

public class Solution {
   public int atoi(String str) {
   		str = str.trim();
   		int len = str.length();

   		if(len == 0){
   			return 0;
   		}

   		long res = 0;
   		int index = 0;
   		boolean positive = true;

   		if(str.charAt(index) == '+'){
   			index++;
   		}else if(str.charAt(index) == '-'){
   			index++;
   			positive = false;
   		}

   		for(; index < len; index++){
   			if(str.charAt(index) < '0' || str.charAt(index) > '9'){
   				break;
   			}

   			res = res * 10 + str.charAt(index) - '0';

   			if(res > Integer.MAX_VALUE){
   				break;
   			}
   		}

   		if(res > Integer.MAX_VALUE){
   			return positive? Integer.MAX_VALUE : Integer.MIN_VALUE;
   		}

   		return positive? (int)res : -(int)res;
	}
}