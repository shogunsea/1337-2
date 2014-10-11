public class Solution {
	public int[] twoSum(int[] num, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < num.length; i++) {
			if (map.containsKey(target - num[i])) {
				return new int[] {map.get(target - num[i]) + 1, i + 1};
			}
			map.put(num[i], i);
		}
		return new int[] {-1,-1};
	}
}