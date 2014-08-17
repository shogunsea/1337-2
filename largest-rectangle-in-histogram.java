// Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


// Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


// The largest rectangle is shown in the shaded area, which has area = 10 unit.

// For example,
// Given height = [2,1,5,6,2,3],
// return 10.

public class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if(len == 0) return len;

        Stack<Integer> st = new Stack<Integer>();
        int max = 0;

        for(int i = 0; i <= len; i++){
        	int current = (i == len)? -1 : heights[i];
        	while(!st.isEmpty() && current < heights[st.peek()]){
        		int height = heights[st.pop()];
        		int width = st.isEmpty()? i : i - st.peek() - 1;
        		max = max < (height * width)? height * width : max;
        	}

        	st.push(i);
        }

        return max;
    }
}