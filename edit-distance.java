// Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

// You have the following 3 operations permitted on a word:

// a) Insert a character
// b) Delete a character
// c) Replace a character


// Follow UP:
// Given two strings S and T, determine if they are both one edit distance apart.

public class Solution {
    public int minDistance(String word1, String word2) {
        int lenOne = word1.length();
        int lenTwo = word2.length();

        if(lenOne == 0 || lenTwo == 0){
        	return lenTwo == 0? lenOne : lenTwo;
        }

        int[][] dis = new int[lenOne + 1][lenTwo + 1];

        for(int i = 0; i <= lenOne; i++){
        	dis[i][0] = i;
        }

        for(int j = 0; j <= lenTwo; j++){
        	dis[0][j] = j;
        }

        for(int i = 1; i <= lenOne; i++){
        	for(int j = 1; j <= lenTwo; j++){
        		if(word1.charAt(i - 1) == word2.charAt(j - 1)){
        			dis[i][j] = dis[i - 1][j - 1];
        		}else{
        			int op1 = dis[i - 1][j] + 1;
        			int op2 = dis[i][j - 1] + 1;
        			int replace = dis[i - 1][j - 1] + 1;
        			dis[i][j] = op1 < op2? Math.min(op1, replace) : Math.min(op2, replace);
        		}
        	}
        }

        return dis[lenOne][lenTwo];
    }
}