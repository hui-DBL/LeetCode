package at_2020.dp;


/**
 * @author hui.zhong
 * @date 2020-08-24
 */
public class HouseRobber {

	public static void main(String[] args) {
		int[] nums = {2,7,9,3,1};
		System.out.println(rob(nums));
	}

	/**
	 * preMax(n-2) + self
	 *
	 * @param nums
	 * @return
	 */
	public static int rob(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int[] numMax = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				numMax[i] = nums[i];
			} else if (i == 1) {
				numMax[i] = Math.max(nums[i], nums[i - 1]);
			} else {
				// preMax(n-2) + self
				int selfMax = numMax[i - 2] + nums[i];
				numMax[i] = Math.max(selfMax, numMax[i - 1]);
			}
		}

		return numMax[nums.length - 1];
	}
}
