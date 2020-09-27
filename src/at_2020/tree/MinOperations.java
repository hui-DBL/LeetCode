package at_2020.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hui.zhong
 * @date 2020-09-27
 */
public class MinOperations {


	public static void main(String[] args) {
		String[] logs = {"d1/","../","../","../"};
		System.out.println(minOperations(logs));
	}

	public static int minOperations(String[] logs) {
		List<List<String>> lists = new ArrayList<>();
		// head
		List<String> mainList = new ArrayList<>();
		mainList.add("main");
		lists.add(mainList);

		int current = 0;
		for (int i = 0; i < logs.length; i++) {
			if ("./".equals(logs[i])) {
				continue;
			} else if ("../".equals(logs[i])) {
				if (current == 0) {
					continue;
				} else {
					current--;
				}
			} else {
				current++;
				if (current >= lists.size()) {
					List<String> list = new ArrayList<>();
					list.add("x");
					lists.add(list);
				} else {
					List<String> list = lists.get(current);
					list.add("x");
				}
			}
		}
		return current;
	}
}
