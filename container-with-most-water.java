// Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

// Note: You may not slant the container.

public class Solution {
    public int maxArea(int[] height) {
    	int len = height.length;

    	if(len < 2) return 0;

    	int left = 0;
    	int right = len - 1;
    	int maxArea = 0;

    	while(left < right){
    		int tempArea = Math.min(height[left], height[right]) * (right - left);
    		maxArea = maxArea > tempArea? maxArea : tempArea;
            int preLeft = left;
            int preRight = right;
    		if(height[left] > height[right]){
    			right--;
                while (left < right && height[right] < height[preRight]){
                    right--;
                }
    		}else{
    			left++;
                while (left < right && height[left] < height[preLeft]) {
                    left++;
                }
    		}
    	}

    	return maxArea;
    }
}


public class Solution {
    public int maxArea(int[] height) {
        int len = height.length;

        if(len < 2) return 0;

        int left = 0;
        int right = len - 1;
        int maxArea = 0;

        while(left < right){
            int tempArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = maxArea > tempArea? maxArea : tempArea;
            if(height[left] > height[right]){
                right--;
            }else{
                left++;
            }
        }

        return maxArea;
    }
}
