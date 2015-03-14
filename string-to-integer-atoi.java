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



public class Solution {
    public int atoi(String str) {
        int res = 0;
        int len = str.length();

        if (len == 0) {
         return res;
        }

        char[] ss = str.toCharArray();
        // remove the leading white spaces.
         int start = 0;
         boolean isNeg = false;
         boolean overflow = false;

        for (int i = 0; i < len; i++) {
         char c = ss[i];
         if (c != ' ') {
            if (c == '-' || c == '+') {
               isNeg = c == '-'? true : false;
               start = i + 1;
            } else {
               start = i;
            }
            break;
         }
        }


        for (int i = start; i < len; i++) {
         int num = ss[i] - '0';

         if (num > 9 || num < 0) {
            // invalid number.
            break;
         }

         int tenTimes = res * 10;

         if (tenTimes / 10 != res) {
            overflow = true;
            break;
         }

         res = res * 10 + num;

         if (res < 0) {
            overflow = true;
            break;
         }
        }

        if (overflow) {
         return isNeg? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        return isNeg? -res : res;
    }
}