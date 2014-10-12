// Given an array of integers, every element appears three times except for one. Find that single one.

// Note:
// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

public class Solution {
    // HashMap version, O(n) + O(n) = O(n) time. O(n) space.
    // public int singleNumber(int[] A) {
    //     HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    //     for(int i : A){
    //     	map.put(i, map.containsKey(i)? map.get(i) + 1 : 1);
    //     }

    //     for(int i : map.keySet()){
    //     	if(map.get(i) == 1){
    //     		return i;
    //     	}
    //     }

    //     return 0;
    // }

    // Bit manipulation version. O(n) time, O(1) space.
	public int singleNumber(int[] A) {
		int ones = 0;
        int twos = 0;
        int threes = 0;
        int one2two = 0;

        for(int i : A){
            one2two = i & ones;
            twos = twos | one2two;
            ones ^= i;
            threes = (ones & twos);
            ones = ones&(~threes);
            twos = twos&(~threes);
        }
        return ones;
    }
}

public class Solution {
    public int singleNumber(int[] A) {
        // look at all the numbers from a bitwise perspective,
        // iterate over all integers, we extract the bits info and 
        // store them in three variables:
        // ones: all bits that appear once so far.
        // twos: bits appear twice so far.
        // threes: bits appear three times so far.
        // we keep update bits info, at last, ones have value of the single number.
        int ones = 0;
        int twos = 0;
        int threes = 0;
        
        for (int i = 0; i < A.length; i++) {
            // ones ^= num;
            // 1 + 1 = 2;
            // 1 + 2 = 3;
            // which bits info to update first:
            // XOR on ones will lose info of carry. so we update twos first, then 
            // update ones, update threes based on ones and twos.
            twos = twos | (ones & A[i]);
            ones = ones ^ A[i];
            threes = ones & twos;
            // clear threes bits from ones and twos.
            ones = (~threes) & ones;
            twos = (~threes) & twos;
        }
        
        return ones;
    }
}
