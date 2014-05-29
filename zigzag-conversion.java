// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

// P   A   H   N
// A P L S I I G
// Y   I   R
// And then read line by line: "PAHNAPLSIIGYIR"
// Write the code that will take a string and make this conversion given a number of rows:

// string convert(string text, int nRows);
// convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

public class Solution {
    public String convert(String s, int nRows) {
    	int len = s.length();

    	if(len <= 1 || nRows == 1){
    		return s;
    	}

    	char[] chars = new char[len];
    	int counter = 0;

    	for(int i = 0; i < nRows; i++){
    		for(int cycle = i; cycle < len; cycle += (nRows - 2) * 2 + 2){
    			chars[counter++] = s.charAt(cycle);

    			if(i > 0 && i < nRows - 1){
    				int fakeRow = nRows - i;
    				int mid = cycle + (fakeRow - 2) * 2 + 2;

    				if(mid < len){
    					chars[counter++] = s.charAt(mid);
    				}
    			}
    		}
    	}

    	return new String(chars);
	}
}