public class Solution {
    public boolean isMatch(String s, String p) { 
        return matchHelper(s, p, 0, 0);
    }
    
    public boolean matchHelper(String s, String p, int sIndex, int pIndex) {
        if (pIndex == p.length()) {
            return sIndex == s.length();
        }
        if (pIndex == p.length() - 1) {
            return sIndex == s.length() - 1 && (p.charAt(pIndex) == s.charAt(sIndex) || p.charAt(pIndex) == '.');
        }
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
            while ( sIndex < s.length() && pIndex < p.length() && (p.charAt(pIndex) == s.charAt(sIndex) || p.charAt(pIndex) == '.' )) {
                if (matchHelper(s, p, sIndex, pIndex + 2)) {
                    return true;
                }
                sIndex++;
            }
            
            return matchHelper(s, p, sIndex, pIndex + 2);
        }
    }
}
        