package at_2018.LeetCode.linkedList;

import at_2018.util.ArrayUtil;

public class RemoveDuplicatesfromSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(removeDuplicates(nums));
        ArrayUtil.showArray(nums);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int sum = 0;
        int count = 0;
        int tmp = nums[0];


        for (int i = 0; i < nums.length; i++) {
            if (tmp == nums[i]) {
                if (count < 2) {
                    count++;
                    if (i > sum) {
                        nums[sum] = tmp;
                    }
                    sum++;
                } else {
                    continue;
                }
            } else {
                tmp = nums[i];
                count = 1;
                if (i > sum) {
                    nums[sum] = tmp;
                }
                sum++;
            }
        }
        return sum;
    }
}
