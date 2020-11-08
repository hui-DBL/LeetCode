package at_2020.array;

/**
 * @author hui.zhong
 * @date 2020/11/7
 */
public class CountRangeSum {
    public static void main(String[] args) {
        int[] n = {-2147483647, 0, -2147483647, 2147483647};
        int l = -564;
        int u = 3864;

        System.out.println(countRangeSum(n, l, u));
    }

    public static int countRangeSum(int[] nums, int lower, int upper) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                long num = 0;
                for (int k = i; k <= j; k++) {
                    num += nums[k];
                }
                if (num <= upper && num >= lower) {
                    n++;
                }
            }
        }
        return n;
    }
}
