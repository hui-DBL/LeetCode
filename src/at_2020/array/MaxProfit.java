package at_2020.array;

/**
 * @author hui.zhong
 * @date 2020/11/8
 */
public class MaxProfit {
    public static void main(String[] args) {

    }

    public static int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                max += prices[i + 1] - prices[i];
            }
        }
        return max;
    }
}
