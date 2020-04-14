package at_2020.backtrating;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hui.zhong
 * @date 2020-04-13
 */
public class GenerateParentheses {
	public static void main(String[] args) {
		List<String> result = generateParenthesis(3);
	}

	public static List<String> generateParenthesis(int n) {
		if (n == 0) {
			return new ArrayList<>();
		}
		// 构造n对应的所有情况
		List<String> list = generate(n);
		// 筛选出合适的情况
		List<String> result = new ArrayList<>();
		for (String str : list) {
			if (filterParenthesis(str)) {
				result.add(str);
			}
		}
		return result;
	}

	private static boolean filterParenthesis(String it) {
		// stack
		List<Character> list = new ArrayList<>();
		for (int i = 0; i < it.length(); i++) {
			char c = it.charAt(i);
			if (i == 0) {
				// 第一个必须为"("
				if (c != '(') {
					return false;
				}
				list.add(c);
			} else {
				if (c == '(') {
					// "("存
					list.add(c);
				} else {
					// ")"消
					int index = list.lastIndexOf('(');
					if (index < 0) {
						return false;
					}
					list.remove(index);
				}
			}
		}
		return list.isEmpty();
	}

	private static List<String> generate(int n) {
		List<String> list = new ArrayList<>();
		int times = 0;
		return generate(list, n * 2, times);
	}

	private static List<String> generate(List<String> list, int max, int times) {
		if (times == max - 1) {
			return list;
		}
		if (list.size() == 0) {
			list.add("(");
			list.add(")");
		}

		List<String> strings = new ArrayList<>();
		for (String str : list) {
			str = str + "(";
			strings.add(str);
		}
		for (String str : list) {
			str = str + ")";
			strings.add(str);
		}
		return generate(strings, max, times + 1);
	}
}
