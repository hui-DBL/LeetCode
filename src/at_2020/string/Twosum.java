package at_2020.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hui.zhong
 * @date 2020-10-03
 */
public class Twosum {

	public static void main(String[] args) {

	}

	public static int[] twoSum(int[] nums, int target) {
		int[] re = new int[2];
		for (int i = 0; i < nums.length - 1; i++) {
			int other = target - nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				if (other == nums[j]) {
					re[0] = i;
					re[1] = j;
				}
			}
		}
		return re;
	}
}
