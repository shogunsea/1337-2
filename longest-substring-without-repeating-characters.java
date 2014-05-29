// Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.


public class Solution {
	public int lengthOfLongestSubstring(String s){
		int len = s.length();
		int leftBound = 0, counter = 0;
		int[] dp = new int[100];

		for(int i = 0; i < len; i++){
			if(dp[s.charAt(i)] == 1){
				counter = counter < i - leftBound? i - leftBound : counter;
				while(leftBound < i && s.charAt(leftBound) != s.charAt(i)){
					dp[s.charAt(leftBound)] = 0;
					leftBound++;
				}
				leftBound++;
				dp[s.charAt(i)] = 1;
			}else{
				dp[s.charAt(i)] = 1;
				// counter = Math.max(counter, i - leftBound + 1);
			}
		}

		counter = counter < len - leftBound? len - leftBound : counter;

		return counter;
	}


    // public int lengthOfLongestSubstring(String s){
    // 	if(s.length() == 0){
    // 		return 0;
    // 	}

    // 	char[] ss = s.toCharArray();
    //     int len = Integer.MIN_VALUE;
    //     int[] dp;

    //     for(int i = 0; i < ss.length; i++){
    //     	dp = new int[256];
    //     	int index = ss[i]; 
    //     	dp[index] = 1;
    //     	int j = i + 1;

    //     	if(len > ss.length - i){
    //     		break;
    //     	}

    //     	for(; j < ss.length; j++){
    //     	    // if(len > ss.length - j){
    //     	    //     break;
    //     	    // }
    //     		index = ss[j];
    //     		if(dp[index] == 1){
    //     			//found dups.
    //     			len = Math.max(len, j - i);
    //     			break;
    //     		}
    //     		dp[index] = 1;
    //     	}

    //     	len = Math.max(len , j - i);
    //     }

    //     return len;
    // }
}