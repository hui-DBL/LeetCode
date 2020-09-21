package at_2020.dp;

/**
 * @author hui.zhong
 * @date 2020-08-24
 */
public class HouseRobber2 {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		System.out.println(rob(nums));

	}

	public static int rob(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int[] numMax = new int[4];
		boolean headSelect = false;

		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				numMax[i] = nums[i];
				headSelect = true;
			} else if (i == 1) {
				// 能不选则不选，确保tail可选
				if (nums[1] <= nums[2]) {
					numMax[i] = nums[2];
					headSelect = false;
				} else {
					numMax[i] = nums[1];
				}
			} else if (i == nums.length - 1) {
				if (headSelect) {
					numMax[i] = numMax[i - 1];
				} else {
					// preMax(n-2) + self
					int selfMax = numMax[i - 2] + nums[i];
					numMax[i] = Math.max(selfMax, numMax[i - 1]);
				}
			} else {
				if (headSelect) {
					// preMax(n-2) + self
					int selfMax = numMax[i - 2] + nums[i];
					if (selfMax <= numMax[i - 1]) {
						numMax[i] = numMax[i - 1];
						headSelect = false;
					} else {
						numMax[i] = selfMax;
					}
				} else {
					// preMax(n-2) + self
					int selfMax = numMax[i - 2] + nums[i];
					numMax[i] = Math.max(selfMax, numMax[i - 1]);
				}
			}
		}

		return numMax[nums.length - 1];
	}
}
