package Before.num16;

/**
 * Greedy

 * Created by zhonghui on 2017/7/11.
 */
public class MaximumSubarray_2 {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        Solution_2 solution_2 = new Solution_2();
        System.out.println(solution_2.maxSubArray(nums));
    }
}


class Solution_2 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);//只要那些加正值的sum
        }
        return max;
    }
}
/*-----------------------------------------------------------*/
