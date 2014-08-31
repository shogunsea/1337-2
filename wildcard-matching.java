// public class Solution {
//     public boolean isMatch(String s, String p) {
//         int sIndex = 0, pIndex = 0;
//         int ss=-1, pp =-1;
//         while(sIndex<s.length()){
//             if(sIndex<s.length() && pIndex<p.length() && s.charAt(sIndex)==p.charAt(pIndex)){sIndex++; pIndex++; continue;}
//             if(sIndex<s.length() && pIndex<p.length() && p.charAt(pIndex)=='?'){sIndex++; pIndex++; continue;}
//             if(sIndex<s.length() && pIndex<p.length() && p.charAt(pIndex)=='*'){ss=sIndex; pp=pIndex++; continue;}
//             if(pp!=-1 && pp <p.length()){sIndex =ss++; pIndex=pp+ 1; continue;}
//             return false;
//         }
//         while (pIndex<p.length() && p.charAt(pIndex)=='*'){pIndex++;}
//         return pIndex==p.length();
//     }
// }

public class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        if(sLen == 0 || pLen == 0){
            return sLen == pLen || p.equals("*");
        }


        int counter = 0;

        for(int i = 1; i < pLen; i++){
            if(p.charAt(i) != '*') counter++;
            if(p.charAt(i) == '*' && p.charAt(i - 1) == '*') return false;
        }

        if(counter > sLen) return false;

        // OMG!!! if put this line before previous line then get 
        // TLE!!! WTF!!!
        boolean[][] m = new boolean[sLen][pLen];

        for(int i = 0; i < sLen; i++){
            char charS = s.charAt(i);
            for(int j = 0; j < pLen; j++){
                char charP = p.charAt(j);
                if(i == 0 || j == 0){
                    if(i == j){
                        m[i][j] = charP == charS || charP == '?' || charP == '*';
                    }else if(i == 0) {
                    	if(charP == '*'){
                    		m[i][j] = m[i][j - 1];
                    	}else{
                    		break;
                    	}
                    	// if(charP == '*'){
                    	// 	 m[i][j] = m[i][j - 1];
                    	// }else if(charP == charS || charP == '?'){
                    	// 	if(p.charAt(j - 1) == '*'){
                    	// 		m[i][j] = m[i][j - 1];
                    	// 	}
                    	// }
                        // m[i][j] = charP == '*' ? m[i][j - 1] : false;
                    }else if(j == 0){
                        m[i][j] = charP == '*' ? m[i - 1][j] : false;
                    }
                }else{
                    if(charP == charS || charP == '?'){
                        m[i][j] = m[i - 1][j - 1];
                    }else if(charP == '*'){
                        m[i][j] = m[i - 1][j - 1] || m[i - 1][j] || m[i][j - 1];
                    }else{
                        m[i][j] = false;
                    }
                }
            }
        }

        return m[sLen - 1][pLen - 1];
    }
}




// public boolean isMatch(String s, String p) {
//         int len_s = s.length();
//         int len_p = p.length();

//         int count = 0;
//         for(int i = 0;i< len_p;i++){
//             if(p.charAt(i) != '*') count++;
//         }
//         if(count > len_s) return false;

//         boolean[][] mark = new boolean[len_s+1][len_p+1];
//         mark[0][0] = true;
//         for (int i = 0; i < len_p; i++) {
//             if(p.charAt(i) == '*'){
//                 mark[0][i+1] = true;
//             }else{
//                 break;
//             }
//         }
//         for (int i = 1; i <= len_s; i++) {
//             char ch_s = s.charAt(i-1);
//             for(int j = 1;j<= len_p;j++){
//                 char ch_p = p.charAt(j-1);
//                 if(ch_p == ch_s  || ch_p == '?'){
//                     mark[i][j] = mark[i-1][j-1];
//                 }else if(ch_p == '*'){
//                     mark[i][j] = mark[i][j-1] | mark[i-1][j-1]|mark[i-1][j];
//                 }else{
//                     mark[i][j] = false;
//                 }
//             }
//         }
//         return mark[len_s][len_p];
//     }
