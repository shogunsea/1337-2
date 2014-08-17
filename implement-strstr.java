// Implement strStr().

// Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.


public class Solution {
    public String strStr(String haystack, String needle) {
    	if(needle == null || haystack == null ) return null;

    	int hayLen = haystack.length();
    	int nLen = needle.length();
    	if(nLen == 0) return haystack;

    	if(nLen > hayLen) return null;

    	for(int i = 0; i < hayLen; i++){
    	    if(hayLen - i < nLen) return null;
    		int counter = i + 1;
    		if(haystack.charAt(i) == needle.charAt(0)){
    			int j = 1;
    			for(; counter < hayLen && j < nLen; counter++,j++){
    				if(haystack.charAt(counter) != needle.charAt(j)){
    					break;
    				}
    				// counter++;
    			}
    			if(j == nLen){
    				return haystack.substring(i);
    			}
    		}
    	}

    	return null;
    }
}