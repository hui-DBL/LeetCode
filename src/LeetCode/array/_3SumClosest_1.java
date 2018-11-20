package LeetCode.array;

import java.util.Arrays;

public class _3SumClosest_1 {
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
        // must
        Arrays.sort(nums);
        int re = nums[0] + nums[1] + nums[2];
        int cloRe = Math.abs(re - target);
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    re = sum;
                    break;
                }
                int diff = Math.abs(sum - target);
                if (cloRe > diff) {
                    cloRe = diff;
                    re = sum;
                }
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return re;
    }
}

