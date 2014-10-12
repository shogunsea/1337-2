public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        
        if (!checkValid(s, dict)) {
            return res;
        }
        
        // try all possible indexes and substirng length.
        dfsHelper(s, dict, res, sb, 0);
        
        return res;
    }
    
    public boolean checkValid(String s, Set<String> dict) {
        int len = s.length();
        if (len == 0 || dict == null || dict.size() == 0) {
            return false;
        }
        
        boolean[] splitPoint = new boolean[len + 1];
        splitPoint[0] = true;
        
        // the string s can be split in unexpected ways, the first time 
        // u found a valid cut at (i,j) doesnt meaning, u can find valid
        // cuts in (j,...), so u have to iterate over all possible indexes,
        // which takes o(n2).
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                if (splitPoint[i] && dict.contains(s.substring(i, j))) {
                    splitPoint[j] = true;
                }
            }
        }
        
        return splitPoint[len];
    }
    
    public void dfsHelper(String s, Set<String> dict, List<String> res, StringBuilder sb, int index) {
        if (index == s.length()) {
            res.add(sb.toString());
            return;
        }
        
        for (int i = index + 1; i <= s.length(); i++) {
            String sub = s.substring(index, i);
            if (dict.contains(sub)) {
                int sbLen = sb.length();
                if (sbLen == 0) {
                    sb.append(sub);
                } else {
                    sb.append(' ');
                    sb.append(sub);
                }
                dfsHelper(s, dict, res, sb, i);
                // backtracking, revert sb to original state
                sb.delete(sbLen, sb.length());
            }
        }
    }
}