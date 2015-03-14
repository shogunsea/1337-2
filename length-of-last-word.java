// Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

// If the last word does not exist, return 0.

// Note: A word is defined as a character sequence consists of non-space characters only.

// For example, 
// Given s = "Hello World",
// return 5.

public class Solution {
    public int lengthOfLastWord(String s) {
    	int len = 0;
		for(int i = s.length() - 1; i > 0; i--){
			if(s.charAt(i) != ' '){
				len = 1;
				for(int j = i - 1; j >= 0; j--){
					if(s.charAt(j) != ' '){
						len++;
					}else{
						break;
					}
				}
				break;
			}
		}
		return len;       
    }
}

public class Solution {
    public int lengthOfLastWord(String s) {
        int len = s.length();

        if (len == 0) {
        	return 0;
        }

        for (int i = len - 1; i >= 0; i++) {
        	if (s.charAt(i) == ' ') {
        		continue;
        	} else {
        		int j = i - 1;

        		while (j >= 0 && s.charAt(j) != ' ') {
        			j--;
        		}

        		return i - j;
        	}
        }

        return 0;
    }
}