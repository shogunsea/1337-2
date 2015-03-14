// Given a roman numeral, convert it to an integer.

// Input is guaranteed to be within the range from 1 to 3999.

public class Solution {
    public int romanToInt(String s) {
 		int res = 0;

 		for(int i = 0; i < s.length(); i++){
 			int current = getValue(s.charAt(i));
 			if(i == s.length() - 1 || current >= getValue(s.charAt(i + 1))){
 				res += current;
 			}else{
 				res -= current;
 			}
 		}

 		return res;
    }

    public int getValue(char c){
    	int value = 0;
    	switch(c){
    		case 'I' : value = 1; break;
    		case 'V' : value = 5; break;
    		case 'X' : value = 10; break;
    		case 'L' : value = 50; break;
    		case 'C' : value = 100; break;
    		case 'D' : value = 500; break;
    		case 'M' : value = 1000; break;
    		default: value = 0; break;
    	}

    	return value;
    }
}



public class Solution {
    public int romanToInt(String s) {
        int len = s.length();

        if (len == 0) {
            return 0;
        }

        int res = 0;

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            int val = getInt(c);
            if (i < len - 1) {
                char nextChar = s.charAt(i + 1);
                int nextVal = getInt(nextChar);

                if (nextVal > val) {
                    res = res + nextVal - val;
                    i++;
                    continue;
                }
            }

            res = res + val;
        }

        return res;
    }

    public int getInt(char c) {
        int res = 0;

        switch (c) {
            case 'I':
                res = 1;
                break;
            case 'V':
                res = 5;
                break;
            case 'X':
                res = 10;
                break;
            case 'L':
                res = 50;
                break;
            case 'C':
                res = 100;
                break;
            case 'D':
                res = 500;
                break;
            case 'M':
                res = 1000;
                break;
            default:
                res = 0;
                break;
        }

        return res;
    }
}