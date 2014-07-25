// Validate if a given string is numeric.

// Some examples:
// "0" => true
// " 0.1 " => true
// "abc" => false
// "1 a" => false
// "2e10" => true
// Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.


public class Solution {
    public boolean isNumber(String s) {
        // skip white spaces first.
        s = s.trim();
        if(s.equals("")){
        	return false;
        }

        boolean num = false;
        boolean dot = false;
        boolean exp = false;
        // boolean sign = false;

        int start = 0;
        int end = s.length() - 1;

        if(s.charAt(start) == '+' || s.charAt(start) == '-') start++;

        while(start <= end ){
        	char c = s.charAt(start);

        	if(c == '.'){
        		if(exp || dot) return false;
        		dot = true;
        	}else if( c == 'e'){
        		if(exp || num == false) return false;
        		exp = true;
        		num = false;
        	}else if( c >= '0' && c <= '9'){
        		num = true;
        	}else if (c == '+' || c == '-'){
        		if (s.charAt(start - 1) != 'e' ) return false;
        	}else {
        		return false;
        	}

        	start++;
        }

        return num;
    }
}	