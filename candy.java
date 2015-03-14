public class Solution {
    public int candy(int[] ratings) {
        // based on the definition and requirement, we do the following:
        // 1.initial each child with 1 candy
        // 2. check in both directions to make sure that each child
        // gets more candy if s/he has a higher rating.
        int len = ratings.length;
        if (len == 0) {
            return 0;
        }
        
        int[] candies = new int[len];
        
        for (int i = 0; i < len; i++) {
            candies[i] = 1;
        }
        
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
        }
        
        int sum = 0;
        for (int i : candies) {
            sum += i;
        }
        
        return sum;
    }
}