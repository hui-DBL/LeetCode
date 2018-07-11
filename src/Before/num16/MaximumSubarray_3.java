package Before.num16;

/**
 * Created by zhonghui on 2017/7/11.
 */
public class MaximumSubarray_3 {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        Solution_3 solution_3 = new Solution_3();
        System.out.println(solution_3.maxSubArray(nums));
    }
}


class Solution_3 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] local = new int[2];
        int[] global = new int[2];//两个数来回倒
        local[0] = nums[0];
        global[0] = nums[0];
        int i = 1;
        for(i=1;i<nums.length;i++) {
            local[i % 2] = Math.max(nums[i], local[(i - 1) % 2] + nums[i]);//取正数加
            global[i % 2] = Math.max(local[i % 2], global[(i - 1) % 2]);//上面的局部最大和之前的全局最大比
        }
        return global[(i - 1) % 2];
    }
}
/*-----------------------------------------------------------*/