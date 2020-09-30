package at_2020.array;

import java.util.Arrays;

/**
 * @author hui.zhong
 * @date 2020-09-30
 */
public class SingleNumber {

	public static void main(String[] args) {
		int[] nums = {4, 1, 2, 1, 2};
		System.out.println(singleNumber(nums));
	}

	public static int singleNumber(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i + 1 >= nums.length) {
				return nums[i];
			}
			if (nums[i] != nums[i + 1]) {
				return nums[i];
			}
			i++;
		}
		return nums[nums.length - 1];
	}
}
