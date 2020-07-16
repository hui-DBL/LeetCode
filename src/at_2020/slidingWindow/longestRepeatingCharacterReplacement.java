package at_2020.slidingWindow;


/**
 * @author hui.zhong
 * @date 2020-07-13
 */
public class longestRepeatingCharacterReplacement {


	public static void main(String[] args) {
		System.out.println(characterReplacement2("ABAAABABABABABABA", 0));
	}

	public static int characterReplacement2(String s, int k) {

		int[] map = new int[26];

		if (s == null) {
			return 0;
		}
		char[] chars = s.toCharArray();
		int left = 0;
		int right = 0;
		int historyCharMax = 0;
		for (right = 0; right < chars.length; right++) {
			int index = chars[right] - 'A';
			map[index]++;
			historyCharMax = Math.max(historyCharMax, map[index]);
			if (right - left + 1 > historyCharMax + k) {
				map[chars[left] - 'A']--;
				left++;
			}
		}
		// 窗口的宽度保持不变，滑动就行
		return chars.length - left;
	}


	public static int characterReplacement1(String s, int k) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		// 全局的统计指标
		int[] nums = new int[26];

		int max = 0;

		int left = 0;
		for (int end = 0; end < s.length(); end++) {
			int currIndex = s.charAt(end) - 'A';
			nums[currIndex]++;
			max = Math.max(nums[currIndex], max);

			// 当替换超出上限，窗口需要滑动
			if (max + k < end - left + 1) {
				int leftIndex = s.charAt(left) - 'A';
				nums[leftIndex]--;
				left ++;
			}
		}

		return Math.min(s.length(), max + k);
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
