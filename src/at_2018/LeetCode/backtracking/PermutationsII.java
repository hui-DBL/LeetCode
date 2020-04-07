package at_2018.LeetCode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permutations.showList(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int start = 0;
        Set<List<Integer>> sets = new HashSet<>();
        permuteHelp(start, nums, lists);
        lists.addAll(sets);
        return lists;
    }

    private static void permuteHelp(int start, int[] nums, List<List<Integer>> lists) {
        if (start >= nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            lists.add(list);
        }
        for (int i = start; i < nums.length; i++) {
            transLocation(start, i, nums);
            permuteHelp(start + 1, nums, lists);
            transLocation(start, i, nums);
        }
    }

    private static void transLocation(int start, int i, int[] nums) {
        int tmp = nums[start];
        nums[start] = nums[i];
        nums[i] = tmp;
    }
}
