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
            // find first element that is decreasing.
            // if we come to the while loop, stack contains
            // all large values that are greater than current
            // elements, we can iterate through them, with each
            // element as left bound, each elements right index 
            // minus current index as width, each elements value
            // as height.
        	while(!st.isEmpty() && current < heights[st.peek()]){
        		int height = heights[st.pop()];
                // is stack is empty, we should calculate
                // the rectangle which covers up to current index i.
        		int width = st.isEmpty()? i : i - st.peek() - 1;
        		max = max < (height * width)? height * width : max;
        	}

        	st.push(i);
        }

        return max;
    }
}