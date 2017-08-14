package num16;

/**
 * Prefix Sum

 * Created by zhonghui on 2017/7/11.
 */
public class MaximumSubarray_1 {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        Solution_1 solution_1 = new Solution_1();
        System.out.println(solution_1.maxSubArray(nums));
    }
}


class Solution_1 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int minSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);//去掉最小的那一串
            minSum = Math.min(minSum, sum);
        }
        return max;
    }
}
/*-----------------------------------------------------------*/