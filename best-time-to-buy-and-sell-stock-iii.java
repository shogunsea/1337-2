// Say you have an array for which the ith element is the price of a given stock on day i.

// Design an algorithm to find the maximum profit. You may complete at most two transactions.

// Note:
// You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

public class Solution {
    public int maxProfit(int[] prices) {
    	if(prices.length < 2){
    		return 0 ;
    	}
 		int[] profit = new int[prices.length];
 		int tmpProfit = 0;
 		int min = Integer.MAX_VALUE;

 		for(int i = 0; i < prices.length; i++){
 			if(min > prices[i]){
 				min = prices[i];
 			}
 			if(tmpProfit < prices[i] - min){
 				tmpProfit = prices[i] - min;
 			}
 			profit[i] = tmpProfit;
 		}       

 		int max = Integer.MIN_VALUE;
 		int[] profitBack = new int[prices.length];
 		tmpProfit = 0;

 		for(int i = prices.length - 1; i >= 0; i--){
 			if(max < prices[i]){
 				max = prices[i];
 			}

 			if(tmpProfit < max - prices[i]){
 				tmpProfit = max - prices[i];
 			}

 			profitBack[i] = tmpProfit;
 		}

 		int res = tmpProfit;

 		for(int i = prices.length - 1; i >= 1; i--){
 			if(profitBack[i] + profit[i - 1] >= res){
 				res = profitBack[i] + profit[i - 1];
 			}
 		}
 		// for(int i = 1; i < prices.length; i++){
 		// 	if(profit[i] + profitBack[i + 1] > res){
 		// 		res = profit[i] + profitBack[i + 1];
 		// 	}
 		// }

 		return res;
    }
}


public class Solution {
    public int maxProfit(int[] prices) {
    	int len = prices.length;
    	if (len == 0) {
    		return 0;
    	}

    	int[] leftProfit = new int[len];
    	int min = prices[0];
    	int tempProfit = 0;

    	for (int i = 1; i < len; i++) {
    		min = min < prices[i]? min : prices[i];
    		tempProfit = tempProfit > (prices[i] - min)? tempProfit : (prices[i] - min);
    		leftProfit[i] = tempProfit;
    	}

    	int globalMax = 0;
    	tempProfit = 0;
    	int max = prices[len - 1];

    	for (int i = len - 2; i >= 0; i--) {
    		max = max > prices[i]? max : prices[i];
    		tempProfit = tempProfit > (max - prices[i])? tempProfit : (max - prices[i]);
    		globalMax = globalMax > (tempProfit + leftProfit[i])? globalMax : (tempProfit + leftProfit[i]);
    	}

    	return globalMax;
    }
}