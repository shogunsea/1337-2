// Say you have an array for which the ith element is the price of a given stock on day i.

// If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

public class Solution {
    public int maxProfit(int[] prices) {
 		int min = Integer.MAX_VALUE;
 		int profit = 0;

 		for(int i : prices){
 			if(min > i){
 				min = i;
 			}
 			if(profit < i - min){
 				profit = i - min;
 			}
 		}       

 		return profit;
    }
}