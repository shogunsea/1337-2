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
		// absorb singular bits, i.e. this var keeps bits info of elements that has shown up only once,
		// if same elem came second time, its bits info are cleard and stored in var 'twos'. Similarly, if same
		// elem show up for the third time, 'ones' will store this occurrence, while previous two occurs are
		// stored in 'twos', combining bits info in 'ones' and 'twos' will tell us whether elements have shown
		// up three times.
        int ones = 0;
        // only store bits info of elems that have shown up twice.
        int twos = 0;
        // only store bits info of elems that have shown up three times.
        int threes = 0;
        // tmp var that store bits of elems that show up for the second time.
        int one2two = 0;

        for(int i : A){
        	one2two = i & ones;
        	twos |= one2two;
        	// XOR clear the same bits, so if bits of same element show up twice, the bits info of that
        	// element will be abandoned.
        	ones ^= i;
             //if both once and twice(once &twice) saved a certain bit,it means this bit appears three times.
            threes= ~(ones&twos);
            //clear the bit locations which appear three times
            ones &= threes;
            twos &= threes;
        }
        return ones;
    }
}
