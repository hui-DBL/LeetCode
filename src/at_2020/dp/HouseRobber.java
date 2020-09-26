package at_2020.dp;

import java.util.Scanner;

/**
 * @author hui.zhong
 * @date 2020/9/21
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob(nums));
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            in.nextInt();
        }
        in.nextLine();
        in.nextInt();
    }

    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] profit = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                profit[i] = nums[0];
            } else if (i == 1) {
                profit[i] = Math.max(nums[0], nums[1]);
            } else {
                profit[i] = Math.max(profit[i - 1], profit[i - 2] + nums[i]);
            }
        }
        return profit[nums.length - 1];
    }
}
