package at_2020.dp;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hui.zhong
 * @date 2020-04-26
 */
public class LongestValidParentheses {
	public static void main(String[] args) {
		System.out.println(longestValidParentheses("()(()"));
	}

	public static int longestValidParentheses(String s) {
		if (s == null) {
			return 0;
		}
		// init 0
		int[] bitMap = new int[s.length()];
		List<Character> strs = new LinkedList<>();
		// 借助栈来统计
		for (int i = 0; i < s.length(); i++) {
			char tmp = s.charAt(i);
			if (tmp == '(') {
				strs.add(tmp);
			} else {
				// 找到最近的'('
				int index = strs.lastIndexOf('(');
				if (index == -1) {
					strs.add('*');
					// 没找到
					continue;
				}
				bitMap[i] = 1;
				bitMap[index] = 1;
				strs.set(index,'*');
				strs.add(tmp);
			}
		}
		// 统计bitMap
		int result = 0;
		int longestTmp = 0;
		for (int i = 0; i < bitMap.length; i++) {
			if (bitMap[i] == 1) {
				longestTmp++;
			} else {
				result = Math.max(longestTmp, result);
				longestTmp = 0;
			}
		}
		return Math.max(longestTmp, result);
	}
}
