package at_2018.LeetCode.sort;

import at_2018.util.ArrayUtil;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        ArrayUtil.showArray(nums);
    }

    public static void sortColors(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        quickSortOwn(nums, 0, nums.length - 1);
    }

    private static void quickSortOwn(int[] nums, int l, int r) {
        if (l < r) {
            int i, j, k;
            i = l;
            j = r;
            k = nums[i];
            while (i < j) {
                while (i < j && nums[j] > k) {
                    j--;
                }
                if (i < j) {
                    nums[i] = nums[j];
                    i++;
                }

                while (i < j && nums[i] < k) {
                    i++;
                }
                if (i < j) {
                    nums[j] = nums[i];
                    j--;
                }
            }
            nums[i] = k;
            quickSortOwn(nums, l, i - 1);
            quickSortOwn(nums, i + 1, r);
        }
    }
}
