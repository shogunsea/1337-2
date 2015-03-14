public class Solution {
    public boolean isMatch(String s, String p) { 
        return matchHelper(s, p, 0, 0);
    }
    
    public boolean matchHelper(String s, String p, int sIndex, int pIndex) {
        if (pIndex == p.length()) {
            return sIndex == s.length();
        }
        if (pIndex == p.length() - 1) {
            // p == '*' case?
            return sIndex == s.length() - 1 && (p.charAt(pIndex) == s.charAt(sIndex) || p.charAt(pIndex) == '.');
        }
        // pindex is at least two chars to end, and next p char is
        // not asterisk
        if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) != '*') {
            if (sIndex == s.length()) {
                return false;
            }
            if (p.charAt(pIndex) == s.charAt(sIndex) || p.charAt(pIndex) == '.') {
                return matchHelper(s, p, sIndex + 1, pIndex + 1);
            } else {
                return false;
            }
        } else {
            // try to cover all chars in s that can be matched by first two chars in p
            // while current char in S can be matched, increment by one.
            while ( sIndex < s.length() && pIndex < p.length() && (p.charAt(pIndex) == s.charAt(sIndex) || p.charAt(pIndex) == '.' )) {
                // dont move too fast!!: might not work if move pointer in S too fast. Example.
                // if (matchHelper(s, p, ++sIndex, pIndex + 2)) {
                if (matchHelper(s, p, sIndex, pIndex + 2)) {
                    return true;
                }
                sIndex++;
            }
            
            return matchHelper(s, p, sIndex, pIndex + 2);
        }
    }
}
        