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

public class Solution {
    public String convert(String s, int nRows) {
        int len = s.length();
        if (len == 0 || nRows == 1) {
            return s;
        }
        
        List<StringBuilder> res = new ArrayList<StringBuilder>();
        for (int i = 0; i < nRows; i++) {
            res.add(new StringBuilder());
        }
        
        int cycle = (nRows - 1) * 2;
        
        for (int i = 0; i < len; i++) {
            int pos = i % cycle;
            if (pos < nRows) {
                res.get(pos).append(s.charAt(i));
            } else {
                // offSet is pos's mirror index regarding to the bottom.
                int offSet = 2 * (nRows - 1) - pos;
                res.get(offSet).append(s.charAt(i));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (StringBuilder temp : res) {
            sb.append(temp.toString());
        }
        
        return sb.toString();
    }
}
            
        
        


public class Solution {
    public String convert(String s, int nRows) {
        int len = s.length();

        if (len == 0 || nRows == 1) {
            return s;
        }

        List<StringBuilder> list = new ArrayList<StringBuilder>();

        for (int i = 0; i < nRows; i++) {
            list.add(new StringBuilder());
        }

        // T for period.
        int t = (nRows - 1) * 2;

        for (int i = 0; i < len; i++) {
            int tempIndex = i % t;
            if (tempIndex >= nRows) {
                tempIndex = (nRows - 1) - (tempIndex - (nRows - 1));
            }

            StringBuilder sb = list.get(tempIndex);
            sb.append(s.charAt(i));
        }

        StringBuilder result = new StringBuilder();

        for (StringBuilder sb : list) {
            result.append(sb.toString());
        }

        return result.toString();
    }
}