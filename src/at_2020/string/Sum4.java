package at_2020.string;

import java.util.*;

/**
 * @author hui.zhong
 * @date 2020-10-05
 */
public class Sum4 {

	public static void main(String[] args) {
		int[] nums = {1, 0, -1, 0, -2, 2};
		int target = 0;
		System.out.println(fourSum(nums, target));
	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		Set<List<Integer>> listSet = new HashSet<>();
		for (int i = 0; i < nums.length - 3; i++) {
			for (int j = i + 1; j < nums.length - 2; j++) {
				for (int k = j + 1; k < nums.length - 1; k++) {
					for (int l = k + 1; l < nums.length; l++) {
						if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
							List<Integer> list = new ArrayList<>(4);
							list.add(nums[i]);
							list.add(nums[j]);
							list.add(nums[k]);
							list.add(nums[l]);
							Collections.sort(list);
							listSet.add(list);
						}
					}
				}
			}
		}
		return new ArrayList<>(listSet);
	}
}
