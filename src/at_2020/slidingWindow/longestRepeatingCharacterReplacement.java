package at_2020.slidingWindow;


/**
 * @author hui.zhong
 * @date 2020-07-13
 */
public class longestRepeatingCharacterReplacement {

	public static void main(String[] args) {
		System.out.println(characterReplacement("ABBB", 2));
	}

	public static int characterReplacement(String s, int k) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int max = 0;

		for (int i = 0; i < s.length(); i++) {
			// 以该起点开始，范围内的最大值
			int len = calMaxRepeatLen(s, i, k);
			max = Math.max(max, len);

			// 是否需要提前返回
			if (s.length() - i <= max) {
				return max;
			}
		}

		return max;
	}

	private static int calMaxRepeatLen(String s, int i, int k) {
		int maxNums = 0;
		for (int end = i; end < s.length(); end++) {

			int[] nums = new int[26];
			for (int index = i; index <= end; index++) {
				int charIndex = s.charAt(index) - 'A';
				nums[charIndex]++;
			}

			int max = 0;
			for (int j = 0; j < nums.length; j++) {
				max = Math.max(nums[j], max);
			}

			if (max + k >= end - i + 1) {
				maxNums = Math.max(end - i + 1, maxNums);
			}
		}
		return maxNums;
	}
}
