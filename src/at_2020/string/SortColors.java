package at_2020.string;

/**
 * @author hui.zhong
 * @date 2020-10-07
 */
public class SortColors {

	public static void main(String[] args) {
		int[] nums = {0, 0};
		sortColors(nums);
	}

	public static void sortColors(int[] nums) {
		int color_1 = -1;
		int color_2 = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				if (color_1 != -1) {
					// 和1换
					nums[color_1] = 0;
					nums[i] = 1;
					color_1++;
				} else if (color_2 != -1) {
					// 和2换
					nums[color_2] = 0;
					nums[i] = 2;
					color_2++;
				}
				if (nums[i] == 1) {
					if (color_1 == -1) {
						color_1 = i;
					}
					if (color_2 != -1) {
						// 和2换
						nums[color_2] = 1;
						nums[i] = 2;
						if (color_2 < color_1) {
							color_1 = color_2;
						}
						color_2++;
					}
				} else if (nums[i] == 2) {
					if (color_2 == -1) {
						color_2 = i;
					}
				}
			} else if (nums[i] == 1) {
				if (color_1 == -1) {
					color_1 = i;
				}
				if (color_2 != -1) {
					// 和2换
					nums[color_2] = 1;
					nums[i] = 2;
					if (color_2 < color_1) {
						color_1 = color_2;
					}
					color_2++;
				}
			} else if (nums[i] == 2) {
				if (color_2 == -1) {
					color_2 = i;
				}
			}
		}
	}
}
