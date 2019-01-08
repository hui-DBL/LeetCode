package LeetCode.array;

import util.ListUtil;

import java.util.*;

public class _4Sum_2 {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        ListUtil.showLists(fourSum(nums, target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return new ArrayList<>();
        }

        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);

        int l = 0;
        int r = nums.length - 1;

        while (r - 3 >= l) {
            for (int i = l + 1; i < r - 1; i++) {
                for (int j = i + 1; j < r; j++) {
                    for (int k = j + 1; k <= r; k++) {
                        if (cal(l, i, j, r, nums, target) == 0) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[l]);
                            list.add(nums[r]);
                            list.add(nums[i]);
                            list.add(nums[j]);
                            lists.add(list);
                        }
                    }
                }
            }
            l++;

        }
        return lists;
    }

    private static int cal(int l, int r, int lr, int rl, int[] nums, int target) {
        int sum = nums[l] + nums[r] + nums[lr] + nums[rl];
        return sum - target;
    }

}