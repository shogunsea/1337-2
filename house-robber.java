// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.


public class Solution {
	// Failed test case:
	// 2,1,1,2
    // public int rob(int[] num) {
    //     int first = 0;
    //     int second = 0;
    //     for (int i = 0; i < num.length; i += 2) {
    //     	first += num[i];
    //     }
    //     for (int i = 1; i < num.length; i += 2) {
    //     	second += num[i];
    //     }
    //     return first > second? first : second;
    // }

	// Brute force: all possible combinations.
	// TLE
  //   public int rob(int[] num) {
  //   	int len = num.length;
  //   	if (len == 0) {
  //   		return 0;
  //   	}
		// // 2,1,1,2
		// int[] res = {0};

		// helper(num, res, 0, -2, 0);

		// return res[0];
  //   }

  //   public void helper(int[] num, int[] res, int index, int lastUsed, int cur) {
  //   	if (index >= num.length) {
  //   		return;
  //   	} 

  //   	// update the result
  //   	res[0] = res[0] < cur? cur : res[0];

  //   	for (int i = index + 1; i < num.length; i++) {
  //   		if (i - lastUsed > 1) {
  //   			int tempCur = cur + num[i];
  //   			helper(num, res, i, i, tempCur);
  //   		}
  //   	}

  //   }

	// DP approach.
	// record current max.
	// When to update: current index and last index are adjacent and
	//    picking current element will increase the sum.
	public int rob(int[] num) {
        int len = num.length;
        if (len == 0) {
            return 0;
        }

        int[] dp = new int[len];
        dp[0] = num[0];
        int lastIndex = 0;
        int res = num[0];

        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1];
            int cur = num[i];
            if (i - lastIndex == 1) {
            	int pre = dp[i - 1];
                if (i == 1 && cur > pre) {
                        dp[i] = cur;
                        lastIndex = i;
                } else if ( i > 1 && cur + dp[i - 2] > dp[i]) {
                        dp[i] = dp[i - 2] + cur;
                        lastIndex = i;
                }
            } else {
                dp[i] += cur;
                lastIndex = i;
            }
        }

        return dp[len - 1];
    }
}