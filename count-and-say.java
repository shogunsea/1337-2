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


