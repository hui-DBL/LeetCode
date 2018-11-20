package LeetCode.array;

/**
 * Array, Two Pointers
 */
public class _3SumClosest {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length <= 3) {
            int re = 0;
            for (int i = 0; i < nums.length; i++) {
                re += nums[i];
            }
            return re;
        }
        int minRe = Integer.MAX_VALUE;
        int re = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (minRe >= closeTo1(nums[i], nums[j], nums[k], target)) {
                        minRe = closeTo1(nums[i], nums[j], nums[k], target);
                        re = nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }
        return re;
    }

    private static int closeTo1(int a, int b, int c, int t) {
        return Math.abs(a + b + c - t);
    }
}
