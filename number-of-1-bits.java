public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return n % 2 == 0? methodA(n) : methodB(n);
        // return methodB(n);
    }
    
    public int methodB(int n) {
        int count = 0;
        
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
    
    public int methodA(int n) {
        // 00000111010
        
        // 00000111001
        // 00000111000
        
        // 00000110111
        // 00000110000
        int mask = 1;
        int count  = 0;
        int bits = 32;
        
        while (bits-- != 0) {
            if ((mask & n) != 0) {
                count++;
            }
            mask = mask<<1;
        }
        
        return count;
    }
}