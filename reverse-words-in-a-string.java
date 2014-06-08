// Given an input string, reverse the string word by word.

// For example,
// Given s = "the sky is blue",
// return "blue is sky the".

public class Solution {
    public String reverseWords(String s){
    	s = s.trim();
        int len = s.length();

        if(len == 0){
            return s;
        }

        StringBuilder sb = new StringBuilder();
        String[] ss = s.split(" ");

        for(int i = ss.length - 1; i >= 0; i--){
            if(i != 0 && ss[i].length() != 0){
                sb.append(ss[i]);
                sb.append(" ");
            }else if(i == 0){
                sb.append(ss[i]);
            }
        }

        return sb.toString();

    }
}