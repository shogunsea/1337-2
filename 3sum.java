public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        return kSum(num, target, 4, 0);
    }

    public List<List<Integer>> kSum(int[] num, int target, int k, int index) {
        // base case
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tempList = new ArrayList<Integer>();

        if (k == 2) {
            int left = index;
            int right = num.length - 1;
            while (left < right) {
                int sum = num[left] + num[right];

                if (sum == target) {
                    tempList.add(num[left]);
                    tempList.add(num[right]);
                    res.add(tempList);
                    tempList = new ArrayList<Integer>();
                    left++;
                    right--;
                    while (left < right && num[left] == num[left- 1]) {
                        left++;
                    }
                    while (left < right && num[right] == num[right + 1]) {
                        right--;
                    }
                } else if (sum < target) {
                    left++;
                    while (left < right && num[left] == num[left - 1]) {
                        left++;
                    }
                } else {
                    right--;
                    while (left < right && num[right] == num[right + 1]) {
                        right--;
                    }
                }
            }
            return res;
        }

        for (int i = index; i < num.length; i++) {
            if (i > index && num[i] == num[i - 1]) {
                continue;
            }
            List<List<Integer>> previous = kSum(num, target - num[i], k - 1, i + 1);
            for (List<Integer> preRes : previous) {
                preRes.add(0,num[i]);
                res.add(preRes);
            }
        }

        return res;
    }

}