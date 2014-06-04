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