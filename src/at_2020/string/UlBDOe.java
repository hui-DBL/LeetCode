package at_2020.string;

/**
 * @author hui.zhong
 * @date 2020-10-01
 */
public class UlBDOe {

	public static void main(String[] args) {
		System.out.println(minimumOperations("rrryyyrryyyrr"));
	}

	/**
	 * 一种：选择将中间的r换成y
	 * 一种：选择将中间的y换成r
	 *
	 * @param leaves
	 * @return
	 */
	public static int minimumOperations(String leaves) {
		int index = 0;
		int op = 0;
		// r
		if (leaves.charAt(index) == 'r') {
			index++;
		} else {
			op++;
			index++;
		}
		// r往下走，找第一个y
		while (leaves.charAt(index) == 'r') {
			index++;
			if (index >= leaves.length()) {
				break;
			}
		}
		// 全为r
		if (index >= leaves.length()) {
			return 1;
		}
		// y在最后
		if (index == leaves.length() - 1) {
			return op + 2;
		}
		// y不在最后
		if (leaves.charAt(index) == 'y') {
			index++;
		} else {
			op++;
			index++;
		}
		// 最后一个是否为r
		if (leaves.charAt(leaves.length() - 1) != 'r') {
			op++;
		}

		// 确定中间
		int start = index;
		int end = leaves.length() - 2;
		if (start >= end) {
			return op;
		} else {
			return op + minimumOperations(leaves, start, end);
		}
	}

	private static int minimumOperations(String leaves, int start, int end) {
		int min = Integer.MAX_VALUE;
		for (int i = start; i <= end; i++) {
			// 计算i左边[start,i)的r,i右边[i,end]的y
			int nums_r = 0;
			int nums_y = 0;
			if (i == start) {
				for (int j = start; j <= end; j++) {
					if (leaves.charAt(j) == 'y') {
						nums_y++;
					} else {
						nums_r++;
					}
				}
				if (nums_r > nums_y) {
					min = nums_y;
				} else {
					min = nums_r;
				}
			} else {
				for (int j = start; j <= i - 1; j++) {
					if (leaves.charAt(j) == 'r') {
						nums_r++;
					}
				}
				for (int j = i; j <= end; j++) {
					if (leaves.charAt(j) == 'y') {
						nums_y++;
					}
				}
				min = Math.min(min, nums_r + nums_y);
			}
		}
		return min;
	}
}
