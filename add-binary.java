// Given two binary strings, return their sum (also a binary string).

// For example,
// a = "11"
// b = "1"
// Return "100".

public class Solution {
    public String addBinary(String a, String b) {
    	StringBuilder sb = new StringBuilder();
    	int aLen = a.length();
    	int bLen = b.length();
    	if(aLen == 0) return b;
    	if(bLen == 0) return a;

    	int aPointer = aLen - 1;
    	int bPointer = bLen - 1;
    	int carry = 0;

    	while(aPointer >= 0 || bPointer >= 0){
    		if(bPointer < 0){
    			int aBit = a.charAt(aPointer--) - '0';
    			int sum = (aBit + carry) % 2;
    			carry = (aBit + carry) / 2;
    			sb.append(sum);
    		}else if(aPointer < 0){
    			int bBit = b.charAt(bPointer--) - '0';
    			int sum = (bBit + carry) % 2;
    			carry = (bBit + carry) / 2;
    			sb.append(sum);
    		}else{
    			int aBit = a.charAt(aPointer--) - '0';
    			int bBit = b.charAt(bPointer--) - '0';
    			int sum = (aBit + bBit + carry) % 2;
    			carry = (aBit + bBit + carry) / 2;
    			sb.append(sum);
    		}
    	}

    	if(carry != 0){
    		sb.append(carry);
    	}

    	sb.reverse();
    	return sb.toString();
    }
}