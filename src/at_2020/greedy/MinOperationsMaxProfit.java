package at_2020.greedy;

/**
 * @author hui.zhong
 * @date 2020-09-27
 */
public class MinOperationsMaxProfit {
	public static void main(String[] args) {
		int[] customers = {10,10,6,4,7};
		System.out.println(minOperationsMaxProfit(customers, 3, 8));
	}

	public static int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
		int max = -1;
		int maxOrder = 0;
		int acc = 0;
		int index = 0;
		int len = customers.length;
		int order = 1;
		int num = 0;
		do {
			// 累计
			if (index < len) {
				int customer = customers[index];
				acc += customer;
			}
			index++;
			// 缓冲池
			if (acc > 4) {
				num = num + 4;
				acc = acc - 4;
			} else {
				num = num + acc;
				acc = 0;
			}
			// 利润
			int profit = boardingCost * num - runningCost * order;

			if (max < profit) {
				max = profit;
				maxOrder = order;
			}
			order++;
		} while (index < len || acc > 0);
		if (max <= 0) {
			return -1;
		} else {
			return maxOrder;
		}
	}
}
