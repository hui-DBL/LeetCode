package at_2018.LeetCode.array;

import java.util.*;

/**
 * 题解：与3sum类似（固定一个左右夹），4sum固定两个左右夹
 * 本题递归，但时间复杂度太高
 */
public class _4Sum_1 {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(fourSum(nums, target));
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            int newTarget = target - nums[i];
            List<Integer> toSelected = new ArrayList<>(4);
            toSelected.add(nums[i]);
            int[] newNums = new int[nums.length - i - 1];
            System.arraycopy(nums, i + 1, newNums, 0, nums.length - i - 1);
            calNum4Sum(set, toSelected, newNums, newTarget);
        }
        List<List<Integer>> list = new ArrayList<>();
        for (List<Integer> item : set) {
            list.add(item);
        }
        return list;
    }

    private static void calNum4Sum(Set<List<Integer>> set, List<Integer> toSelected, int[] nums, int target) {
        if (toSelected.size() > 3) {
            return;
        }
        if (toSelected.size() == 3) {
            for (int i = 0; i < nums.length; i++) {
                List<Integer> selected = new ArrayList<>(4);
                selected.addAll(toSelected);
                if (target == nums[i]) {
                    selected.add(nums[i]);
                    Collections.sort(selected);
                    set.add(selected);
                }
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            List<Integer> selected = new ArrayList<>(4);
            int newTarget = target - nums[i];
            selected.add(nums[i]);
            int[] newNums = new int[nums.length - i - 1];
            System.arraycopy(nums, i + 1, newNums, 0, nums.length - i - 1);
            selected.addAll(toSelected);
            calNum4Sum(set, selected, newNums, newTarget);
        }
    }
}
