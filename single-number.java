public class Solution {
    public int singleNumber(int[] A) {
        // XOR operation: add without carry 0^0 = 0; 1^0 = 1, 1^1=0
        // same bit appear twice will get cleared out.
        int res = 0;
        for (int i : A) {
            res ^= i;
        }
        
        return res;
    }
}