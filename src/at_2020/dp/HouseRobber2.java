package at_2020.dp;

/**
 * @author hui.zhong
 * @date 2020-08-24
 */
public class HouseRobber2 {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
		System.out.println(rob(nums));

	}

	public static int rob(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		// 切换成2列
		int[] nums1 = new int[nums.length - 1];
		int[] nums2 = new int[nums.length - 1];

		System.arraycopy(nums, 0, nums1, 0, nums.length - 1);
		System.arraycopy(nums, 1, nums2, 0, nums.length - 1);

		return Math.max(rob1(nums1), rob1(nums2));
	}

	public static int rob1(int[] nums) {
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
