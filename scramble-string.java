// Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

// Below is one possible representation of s1 = "great":

//     great
//    /    \
//   gr    eat
//  / \    /  \
// g   r  e   at
//            / \
//           a   t
// To scramble the string, we may choose any non-leaf node and swap its two children.

// For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

//     rgeat
//    /    \
//   rg    eat
//  / \    /  \
// r   g  e   at
//            / \
//           a   t
// We say that "rgeat" is a scrambled string of "great".

// Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

//     rgtae
//    /    \
//   rg    tae
//  / \    /  \
// r   g  ta  e
//        / \
//       t   a
// We say that "rgtae" is a scrambled string of "great".

// Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.


public class Solution{
    // Recursive apporach. For each group of input strings,
    // split each string into two substrings, then check 
    // each group of substrings that have same size is 
    // scrabmle string or not. 
    public boolean isScramble(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        // Pruning check.
        if(len1 != len2) return false;

        if(len1 == 1){
          return s1.charAt(0) == s2.charAt(0);
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        String sorted1 = new String(chars1);
        String sorted2 = new String(chars2);

        // Pruning check.
        if(!sorted2.equals(sorted1)) return false;

        for(int i = 1; i < len1; i++){
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);


            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i);

            if(isScramble(s11, s21) && isScramble(s12, s22)) return true;

            s21 = s2.substring(len1 - i);
            s22 = s2.substring(0, len1 - i);

            if(isScramble(s11, s21) && isScramble(s12, s22)) return true;
        }

        return false;
    }
}