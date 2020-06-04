package at_2020.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hui.zhong
 * @date 2020-05-25
 */
public class Triangle {

	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();
		list1.add(2);
		List<Integer> list2 = new ArrayList<>();
		list2.add(3);
		list2.add(4);
		List<Integer> list3 = new ArrayList<>();
		list3.add(6);
		list3.add(5);
		list3.add(7);
		List<Integer> list4 = new ArrayList<>();
		list4.add(4);
		list4.add(1);
		list4.add(8);
		list4.add(3);
		triangle.add(list1);
		triangle.add(list2);
		triangle.add(list3);
		triangle.add(list4);

		System.out.println(minimumTotal(triangle));
	}

	public static int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null) {
			return 0;
		}
		// 确定矩阵大小
		int maxLen = 0;
		for (List<Integer> list : triangle) {
			if (list.size() > maxLen) {
				maxLen = list.size();
			}
		}
		int init = triangle.get(0).get(0);
		if (maxLen == 1) {
			return init;
		}
		// 构造矩阵
		int[][] matrix = new int[maxLen][maxLen];
		matrix[0][0] = init;
		for (int i = 1; i < maxLen; i++) {
			List<Integer> list = triangle.get(i);
			for (int j = 0; j <= i; j++) {
				int self = list.get(j);
				if (j == 0) {
					matrix[i][j] = matrix[i - 1][0] + self;
				} else if (j == i) {
					matrix[i][j] = matrix[i - 1][j - 1] + self;
				} else {
					matrix[i][j] = Math.min(matrix[i - 1][j - 1] + self, matrix[i - 1][j] + self);
				}
			}
		}
		// 输出结果
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < maxLen; i++) {
			int tmp = matrix[maxLen - 1][i];
			if (tmp < min) {
				min = tmp;
			}
		}
		return min;
	}
}
