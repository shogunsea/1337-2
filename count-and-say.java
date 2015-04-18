// The count-and-say sequence is the sequence of integers beginning as follows:
// 1, 11, 21, 1211, 111221, ...

// 1 is read off as "one 1" or 11.
// 11 is read off as "two 1s" or 21.
// 21 is read off as "one 2, then one 1" or 1211.
// Given an integer n, generate the nth sequence.

// Note: The sequence of integers will be represented as a string.

public class Solution {
    public String countAndSay(int n) {
        // 11
        // 21
        // 1211
        // 111221
        // 312211
        // 13112221
        // 1113213211
        // 31131211131221

        // algorithm : 
        // scan previous string, 
        // for each char, get the currentChar and current count
        // append count then current char, continue at element
        // that differ from current one.
    	if(n < 1){
    		return "";
    	}else if(n == 1){
    		return "1";
    	}

        StringBuilder previousString = new StringBuilder();
        previousString.append("11");
        // start from the second string.
        int counter = 2;

        while(counter < n){
        	StringBuilder currentString = new StringBuilder();

        	for(int i = 0; i < previousString.length();){
        		int times = 1;
        		int end = i;
        		while(end < previousString.length() - 1 && previousString.charAt(end) == previousString.charAt(end + 1)){
        			end++;
        			times++;
        		}

        		currentString.append(times);
        		currentString.append(previousString.charAt(i));

        		i += times;
        	}

        	previousString = currentString;
        	// increment counter at last.
        	counter++;
        }

        return previousString.toString();
    }
}




public class Solution {
    public String countAndSay(int n) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb1.append('1');

        for (int i = 1; i < n; i++) {
            int pointer = 0;

            while (pointer < sb1.length()) {
                int runner = pointer + 1;

                while (runner < sb1.length() && sb1.charAt(runner) == sb1.charAt(runner - 1)) {
                    runner++;
                }

                sb2.append(runner - pointer);
                sb2.append(sb1.charAt(pointer));
                pointer = runner;
            }

            sb1 = new StringBuilder(sb2);
            sb2.setLength(0);
        }

        return sb1.toString();
    }
}

public class Solution {
    public String countAndSay(int n) {
        if (n < 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder tempSb = new StringBuilder();
        sb.append(1);
        
        
        // 1
        // 11
        // 21
        // 1211
        // 111221
        // 
        for (int i = 1; i < n; i++) {
            // generate i-th string.
            tempSb.setLength(0);
            int len = sb.length();
            int pos = 0;
            
            while (pos < len) {
                int tempPos = pos + 1;
                while (tempPos < len && sb.charAt(tempPos) == sb.charAt(tempPos-1)) {
                    tempPos++;
                }
                int times = tempPos - pos;
                tempSb.append(times);
                tempSb.append(sb.charAt(pos));
                pos = tempPos;
            }
            
            sb = new StringBuilder(tempSb);
        }
        
        return sb.toString();
    }
}