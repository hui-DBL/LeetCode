package at_2020.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hui.zhong
 * @date 2020-07-06
 */
public class longestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		String s = "pwwkew";
		System.out.println(lengthOfLongestSubstring1(s));
	}

	public static int lengthOfLongestSubstring1(String s) {
		int max = 0;
		int left = 0;
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				left = Math.max(left, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			max = Math.max(max, i - left + 1);
		}
		return max;
	}

	public static int lengthOfLongestSubstring(String s) {

		int maxLen = 0;

		// slide
		for (int i = 0; i < s.length(); i++) {
			int start = i;
			// expand
			int len = calMaxLen(s, start, maxLen);
			if (maxLen < len) {
				maxLen = len;
			}
			if (maxLen == s.length()) {
				return maxLen;
			}
			if (maxLen >= s.length() - start) {
				return maxLen;
			}
			if (start + len == s.length()) {
				continue;
			}
		}

		return maxLen;
	}

	private static int calMaxLen(String s, int start, int max) {
		for (int end = start + max; end < s.length(); end++) {
			if (isRepeat(s, start, end)) {
				return end - start;
			}
		}
		return s.length() - start;
	}

	private static boolean isRepeat(String s, int start, int end) {
		if (end - start == 0) {
			return false;
		}
		Set<Character> characters = new HashSet<>(s.length());
		for (int i = start; i <= end; i++) {
			if (characters.contains(s.charAt(i))) {
				return true;
			}
			characters.add(s.charAt(i));
		}
		return false;
	}
}
