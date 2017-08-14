package num16;

/**
 * Created by zhonghui on 2017/7/11.
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2,-1};
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(nums));
    }
}


class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = nums[0];//要考虑到小于0的情况
        for (int i = 0; i < nums.length; i++) {
            int sum=0;
            for(int j=i;j<nums.length;j++) {
                sum += nums[j];
                if (sum >= max) {
                    max = sum;
                }
            }
        }
        return max;
    }
}
/*-----------------------------------------------------------*/
