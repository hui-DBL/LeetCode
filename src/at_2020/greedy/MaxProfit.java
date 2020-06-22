package at_2020.greedy;

/**
 * @author hui.zhong
 * @date 2020-06-22
 */
public class MaxProfit {
	public static void main(String[] args) {
		int[] prices = {7, 1, 5, 3, 6, 4};
		System.out.println(maxProfit1(prices));
	}

	public static int maxProfit(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}
		int[][] profits = new int[prices.length][prices.length];

		boolean allNegative = true;
		// init，收益枚举
		for (int i = 0; i < prices.length; i++) {
			for (int j = 0; j < prices.length; j++) {
				if (j <= i) {
					continue;
				}
				int val = prices[j] - prices[i];
				profits[i][j] = val;
				if (val > 0) {
					allNegative = false;
				}
			}
		}
		// 全是亏的就不要买了
		if (allNegative) {
			return 0;
		}
		// 取最大化
		// todo 暴力求解
		return 0;
	}

	public static int maxProfit1(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}
		int max = 0;
		for (int i = 0; i < prices.length; i++) {
			if (i == 0) {
				continue;
			}
			if (prices[i] > prices[i - 1]) {
				max += prices[i] - prices[i - 1];
			}
		}
		return max;
	}
}
